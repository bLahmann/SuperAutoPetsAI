package Pets;

import Base.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dodo extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Dodo");
    }

    public Dodo() {
        super("Dodo",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
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

        float fraction;
        int damageBuff;

        if (getLevel() == 1){
            fraction = parameters[4];
        }
        else if (getLevel() == 2){
            fraction = parameters[5];
        }
        else {
            fraction = parameters[6];
        }

        damageBuff = (int) Math.ceil(fraction * getDamage());


        // Find what team I'm on
        List<Pet> myTeam = battle.getTeams().get(0);
        if (!myTeam.contains(this)){
            myTeam = battle.getTeams().get(1);
        }

        // Find my index
        int myIndex = myTeam.indexOf(this);

        if (myIndex != 0){
            myTeam.get(myIndex-1).giveTempDamage(damageBuff);
        }

        // No new events
        return new ArrayList<>();

    }

}