package Pets;

import Base.Pet;
import Base.Utils;

public class Skunk extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Skunk");
    }

    public Skunk() {
        super("Skunk",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}