package Pets;

import Base.Pet;
import Base.Utils;

public class Crab extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Crab");
    }

    public Crab() {
        super("Crab",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}