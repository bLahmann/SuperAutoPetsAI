package Base;

import Program.Program;

import java.lang.reflect.Method;
import java.util.*;

public class Battle {

    private List<List<Pet>> teams = new ArrayList<List<Pet>>();
    public enum RESULT {ONGOING, DRAW, TEAM_A_WON, TEAM_B_WON};

    public Battle(List<Pet> teamA, List<Pet> teamB) {
        teams.add(teamA);
        teams.add(teamB);
    }

    public RESULT simulate(){

        if (Program.DEBUG) System.out.println("Battle Start: " + this);

        // Check for battle start reactions
        List<Reaction> reactions = checkForOnBattleReactions();

        resolveReactions(reactions);
        if (getResult() != RESULT.ONGOING)  return getResult();

        if (Program.DEBUG) System.out.println("After Battle Start Reactions: " + this);

        // Damage phase
        while (getResult() == RESULT.ONGOING) {

            // Clear reactions
            reactions = new ArrayList<>();
            Pet petA = teams.get(0).get(0);
            Pet petB = teams.get(1).get(0);

            // PetA gets damaged by PetB
            if (petA.takeDamage(petB.getDamage())) {
                reactions.addAll(checkForHurtPetReactions(petA, 0));
                if (petA.getHealth() <= 0) {
                    reactions.addAll(checkForFaintedPetReactions(petA, 0));
                }
            }

            // PetB gets damaged by PetA
            if (petB.takeDamage(petA.getDamage())) {
                reactions.addAll(checkForHurtPetReactions(petB, 1));
                if (petB.getHealth() <= 0) {
                    reactions.addAll(checkForFaintedPetReactions(petB, 1));
                }
            }

            // Resolve the reactions if we're not done
            if (getResult() != RESULT.ONGOING) return getResult();
            if (Program.DEBUG) System.out.println("After Damage: " + this);
            resolveReactions(reactions);
            if (Program.DEBUG) System.out.println("After Reactions : " + this);
        }

        // Return
        return getResult();
    }

    public List<Reaction> checkForOnBattleReactions(){

        List<Reaction> reactions = new ArrayList<>();
        for (Pet pet : teams.get(0)) {
            reactions.add(pet.onBattleStart());
        }

        for (Pet pet : teams.get(1)) {
            reactions.add(pet.onBattleStart());
        }
        return reactions;

    }

    public List<Reaction> checkForFaintedPetReactions(Pet faintedPet, int teamIndex){

        List<Reaction> reactions = new ArrayList<>();
        for (Pet pet : teams.get(0)) {
            reactions.add(pet.onFaint(faintedPet, teamIndex == 0));
        }

        for (Pet pet : teams.get(1)) {
            reactions.add(pet.onFaint(faintedPet, teamIndex == 1));
        }
        return reactions;

    }

    public List<Reaction> checkForHurtPetReactions(Pet hurtPet, int teamIndex){

        List<Reaction> reactions = new ArrayList<>();
        for (Pet pet : teams.get(0)) {
            reactions.add(pet.onHurt(hurtPet, teamIndex == 0));
        }

        for (Pet pet : teams.get(1)) {
            reactions.add(pet.onHurt(hurtPet, teamIndex == 1));
        }
        return reactions;

    }

    public List<Reaction> checkForSummonPetReactions(Pet summonedPet, int teamIndex){

        List<Reaction> reactions = new ArrayList<>();
        for (Pet pet : teams.get(0)) {
            reactions.add(pet.onSummon(summonedPet, teamIndex == 0));
        }

        for (Pet pet : teams.get(1)) {
            reactions.add(pet.onSummon(summonedPet, teamIndex == 1));
        }
        return reactions;

    }

    private void resolveReactions(List<Reaction> reactions){

        // Remove null members
        while (reactions.remove(null));

        // Randomize the order
        Collections.shuffle(reactions);

        // Resolve reactions
        List<Event> events = new ArrayList<>();
        for (Reaction reaction : reactions){
            try {
                events.addAll( (List) reaction.invoke(this));
            }catch (Exception e){
                e.printStackTrace();
                System.exit(-1);
            }
        }

        // Go through events and see if any reactions occur
        reactions = new ArrayList<>();
        for (Event event : events){

            // Get the team index
            int teamIndex = 0;
            if (teams.get(1).contains(event.affectedPet)){
                teamIndex = 1;
            }

            // Fainted pet reactions
            if (event.type == Event.TYPE.FAINTED_PET){
                reactions.addAll(checkForFaintedPetReactions(event.affectedPet, teamIndex));
            }

            // Hurt pet reactions
            else if (event.type == Event.TYPE.HURT_PET){
                reactions.addAll(checkForHurtPetReactions(event.affectedPet, teamIndex));
            }

            // Summon pet reactions
            else if (event.type == Event.TYPE.SUMMONED_PET){
                reactions.addAll(checkForHurtPetReactions(event.affectedPet, teamIndex));
            }
        }

        // We can safely remove fainted pets
        clearFaintedPets();

        // Check to see if the battle is over
        if (getResult() != RESULT.ONGOING)  return;

        // If there's more reactions, start over
        if (!reactions.isEmpty()){
            resolveReactions(reactions);
        }



    }

    private void clearFaintedPets(){

        List<Method> reactions = new ArrayList<>();
        teams.get(0).removeIf(pet -> pet.getHealth() <= 0);
        teams.get(1).removeIf(pet -> pet.getHealth() <= 0);

    }

    private RESULT getResult(){
        if (teams.get(0).isEmpty()) {
            if (teams.get(1).isEmpty()) return RESULT.DRAW;
            else                        return RESULT.TEAM_B_WON;
        }
        if (teams.get(1).isEmpty())     return RESULT.TEAM_A_WON;
        else                            return RESULT.ONGOING;
    }



    public List<List<Pet>> getTeams() {
        return teams;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        switch (getResult()) {

            case ONGOING -> {
                String prefix = "";
                for (int i = teams.get(0).size() - 1; i >= 0; i--) {
                    builder.append(prefix).append(teams.get(0).get(i).toString());
                    prefix = ", ";
                }

                builder.append("  vs  ");

                prefix = "";
                for (Pet pet : teams.get(1)) {
                    builder.append(prefix).append(pet.toString());
                    prefix = ", ";
                }
            }

            case TEAM_A_WON -> builder.append("Team A Won!");
            case TEAM_B_WON -> builder.append("Team B Won!");
            case DRAW ->       builder.append("Draw!");
        }

        return builder.toString();
    }
}
