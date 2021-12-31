package Pets;

import Base.Pet;
import Base.Utils;

public class Bison extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Bison");
    }

    public Bison() {
        super("Bison",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}