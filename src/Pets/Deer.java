package Pets;

import Base.Pet;
import Base.Utils;

public class Deer extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Deer");
    }

    public Deer() {
        super("Deer",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}