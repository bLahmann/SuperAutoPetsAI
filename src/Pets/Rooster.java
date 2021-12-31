package Pets;

import Base.Pet;
import Base.Utils;

public class Rooster extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Rooster");
    }

    public Rooster() {
        super("Rooster",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}