package Pets;

import Base.Pet;
import Base.Utils;

public class Rabbit extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Rabbit");
    }

    public Rabbit() {
        super("Rabbit",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}