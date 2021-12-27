package Pets;

import Base.Pet;
import Base.Utils;

public class Ant extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Ant");
    }

    public Ant() {
        super("Ant",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}
