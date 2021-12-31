package Pets;

import Base.Pet;
import Base.Utils;

public class Beaver extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Beaver");
    }

    public Beaver() {
        super("Beaver",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}