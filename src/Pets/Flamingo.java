package Pets;

import Base.Pet;
import Base.Utils;

public class Flamingo extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Flamingo");
    }

    public Flamingo() {
        super("Flamingo",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}