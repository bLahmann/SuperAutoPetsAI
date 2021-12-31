package Pets;

import Base.Pet;
import Base.Utils;

public class Shark extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Shark");
    }

    public Shark() {
        super("Shark",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}