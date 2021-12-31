package Pets;

import Base.Pet;
import Base.Utils;

public class Pig extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Pig");
    }

    public Pig() {
        super("Pig",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}