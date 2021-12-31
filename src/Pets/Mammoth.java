package Pets;

import Base.Pet;
import Base.Utils;

public class Mammoth extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Mammoth");
    }

    public Mammoth() {
        super("Mammoth",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}