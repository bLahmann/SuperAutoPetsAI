package Pets;

import Base.Pet;
import Base.Utils;

public class Camel extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Camel");
    }

    public Camel() {
        super("Camel",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}