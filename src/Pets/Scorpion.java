package Pets;

import Base.Pet;
import Base.Utils;

public class Scorpion extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Scorpion");
    }

    public Scorpion() {
        super("Scorpion",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}