package Pets;

import Base.Pet;
import Base.Utils;

public class Peacock extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Peacock");
    }

    public Peacock() {
        super("Peacock",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}