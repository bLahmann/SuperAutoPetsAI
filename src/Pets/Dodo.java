package Pets;

import Base.Pet;
import Base.Utils;

public class Dodo extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Dodo");
    }

    public Dodo() {
        super("Dodo",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}