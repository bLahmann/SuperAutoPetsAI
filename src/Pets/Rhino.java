package Pets;

import Base.Pet;
import Base.Utils;

public class Rhino extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Rhino");
    }

    public Rhino() {
        super("Rhino",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}