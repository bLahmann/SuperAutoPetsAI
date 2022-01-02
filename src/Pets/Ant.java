package Pets;

import Base.*;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ant extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Ant");
    }

    public Ant() {
        super("Ant",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }

    @Override
    public Reaction onFaint(Pet faintedPet, boolean onMyTeam) {

        // Check if I'm the fainted pet
        if (this.equals(faintedPet)){
            try {
                Reaction reaction = new Reaction(this, faintedPet,
                        this.getClass().getMethod("doEffect", Pet.class, Battle.class));
                return reaction;
            }catch (NoSuchMethodException e){
                e.printStackTrace();
                System.exit(-1);
            }
        }

        // Otherwise, ignore this
        return null;
    }

    public List<Event> doEffect(Pet faintedPet, Battle battle) {

        int damageBuff, healthBuff;
        if (getLevel() == 1){
            damageBuff = Math.round(parameters[4]);
            healthBuff = Math.round(parameters[5]);
        }
        else if (getLevel() == 2){
            damageBuff = Math.round(parameters[6]);
            healthBuff = Math.round(parameters[7]);
        }
        else {
            damageBuff = Math.round(parameters[8]);
            healthBuff = Math.round(parameters[9]);
        }

        // Find what team I'm on
        List<Pet> myTeam = battle.getTeams().get(0);
        if (!myTeam.contains(this)){
            myTeam = battle.getTeams().get(1);
        }

        List<Pet> eligibleTargets = new ArrayList<>();
        for (Pet pet : myTeam){
            if (pet.getHealth() > 0)    eligibleTargets.add(pet);
        }

        if (!eligibleTargets.isEmpty()) {
            Pet target = eligibleTargets.get(new Random().nextInt(eligibleTargets.size()));
            target.giveTempDamage(damageBuff);
            target.giveTempHealth(healthBuff);
        }


        // No new events
        return new ArrayList<>();
    }
}