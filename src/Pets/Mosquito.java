package Pets;

import Base.Pet;
import Base.Utils;

public class Mosquito extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Mosquito");
    }

    public Mosquito() {
        super("Mosquito",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}