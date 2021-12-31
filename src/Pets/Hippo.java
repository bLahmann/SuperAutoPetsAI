package Pets;

import Base.Pet;
import Base.Utils;

public class Hippo extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Hippo");
    }

    public Hippo() {
        super("Hippo",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}