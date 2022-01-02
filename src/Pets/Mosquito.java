package Pets;

import Base.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mosquito extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Mosquito");
    }

    public Mosquito() {
        super("Mosquito",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }

    @Override
    public Reaction onBattleStart() {


        try {
            Reaction reaction = new Reaction(this, null,
                    this.getClass().getMethod("doEffect", Pet.class, Battle.class));
            return reaction;
        }catch (NoSuchMethodException e){
            e.printStackTrace();
            System.exit(-1);
        }


        // Otherwise, ignore this
        return null;
    }

    public List<Event> doEffect(Pet junk, Battle battle) {

        int damage, numTargets;
        if (getLevel() == 1){
            damage = Math.round(parameters[4]);
            numTargets = Math.round(parameters[5]);
        }
        else if (getLevel() == 2){
            damage = Math.round(parameters[6]);
            numTargets = Math.round(parameters[7]);
        }
        else {
            damage = Math.round(parameters[8]);
            numTargets = Math.round(parameters[9]);
        }

        // Find what team I'm on
        List<Pet> enemyTeam = battle.getTeams().get(0);
        if (enemyTeam.contains(this)){
            enemyTeam = battle.getTeams().get(1);
        }

        List<Pet> eligibleTargets = new ArrayList<>();
        for (Pet pet : enemyTeam){
            if (pet.getHealth() > 0)    eligibleTargets.add(pet);
        }

        if (!eligibleTargets.isEmpty()) {
            for (int i = 0; i < numTargets; i++) {
                Pet target = eligibleTargets.get(new Random().nextInt(eligibleTargets.size()));
                target.takeDamage(damage);
            }
        }

        // No new events
        return new ArrayList<>();

    }



}