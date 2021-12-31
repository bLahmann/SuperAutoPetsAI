package Pets;

import Base.Pet;
import Base.Utils;

public class Sheep extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Sheep");
    }

    public Sheep() {
        super("Sheep",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}