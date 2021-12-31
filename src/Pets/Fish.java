package Pets;

import Base.Pet;
import Base.Utils;

public class Fish extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Fish");
    }

    public Fish() {
        super("Fish",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}