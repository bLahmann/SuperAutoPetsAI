package Pets;

import Base.Pet;
import Base.Utils;

public class Fly extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Fly");
    }

    public Fly() {
        super("Fly",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}