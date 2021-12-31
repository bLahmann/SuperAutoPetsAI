package Pets;

import Base.Pet;
import Base.Utils;

public class Turkey extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Turkey");
    }

    public Turkey() {
        super("Turkey",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}