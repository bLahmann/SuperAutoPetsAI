package Pets;

import Base.Pet;
import Base.Utils;

public class Seal extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Seal");
    }

    public Seal() {
        super("Seal",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}