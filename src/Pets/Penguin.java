package Pets;

import Base.Pet;
import Base.Utils;

public class Penguin extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Penguin");
    }

    public Penguin() {
        super("Penguin",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}