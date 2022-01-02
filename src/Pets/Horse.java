package Pets;

import Base.*;

import java.util.ArrayList;
import java.util.List;

public class Horse extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Horse");
    }

    public Horse() {
        super("Horse",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }

    @Override
    public Reaction onSummon(Pet summonedPet, boolean onMyTeam) {

        // Check if the pet is on my team
        if (onMyTeam){
            try {
                Reaction reaction = new Reaction(this, summonedPet,
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

    public List<Event> doEffect(Pet summonedPet, Battle battle) {

        int damageBuff;
        if (getLevel() == 1){
            damageBuff = Math.round(parameters[4]);
        }
        else if (getLevel() == 2){
            damageBuff = Math.round(parameters[5]);
        }
        else {
            damageBuff = Math.round(parameters[6]);
        }

        // Give the summoned pet bonus damage
        summonedPet.giveTempDamage(damageBuff);

        // No new events
        return new ArrayList<>();

    }



}