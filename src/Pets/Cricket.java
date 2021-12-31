package Pets;

import Base.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cricket extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Cricket");
    }

    public Cricket() {
        super("Cricket",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }

    @Override
    public Reaction onFaint(Pet faintedPet, boolean onMyTeam) {

        // Check if I'm the fainted pet
        if (onMyTeam && this.equals(faintedPet)){
            try {
                Reaction reaction = new Reaction(this, this.getClass().getMethod("doEffect", Battle.class));
                return reaction;
            }catch (NoSuchMethodException e){
                e.printStackTrace();
                System.exit(-1);
            }
        }

        // Otherwise, ignore this
        return null;
    }

    public List<Event> doEffect(Battle battle) {

        int summonDamage, summonHealth;
        if (getLevel() == 1){
            summonDamage = Math.round(parameters[4]);
            summonHealth = Math.round(parameters[5]);
        }
        else if (getLevel() == 2){
            summonDamage = Math.round(parameters[6]);
            summonHealth = Math.round(parameters[7]);
        }
        else {
            summonDamage = Math.round(parameters[8]);
            summonHealth = Math.round(parameters[9]);
        }

        // Create the pet summon
        Pet summon = new Pet("Cricket Summon", 1, summonDamage, summonHealth);

        // Find what team I'm on
        List<Pet> myTeam = battle.getTeams().get(0);
        if (!myTeam.contains(this)){
            myTeam = battle.getTeams().get(1);
        }

        // Replace me with the pet summon
        int myIndex = myTeam.indexOf(this);
        myTeam.remove(this);
        myTeam.add(myIndex, summon);

        // Trigger a summon event
        List<Event> events = new ArrayList<>();
        events.add(new Event(Event.TYPE.SUMMONED_PET, summon));
        return events;

    }



}