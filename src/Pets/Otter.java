package Pets;

import Base.Pet;
import Base.Utils;

public class Otter extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Otter");
    }

    public Otter() {
        super("Otter",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}