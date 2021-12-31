package Pets;

import Base.Pet;
import Base.Utils;

public class Hedgehog extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Hedgehog");
    }

    public Hedgehog() {
        super("Hedgehog",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}