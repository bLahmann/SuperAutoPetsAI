package Pets;

import Base.Pet;
import Base.Utils;

public class Horse extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Horse");
    }

    public Horse() {
        super("Horse",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}