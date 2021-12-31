package Pets;

import Base.Pet;
import Base.Utils;

public class Tiger extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Tiger");
    }

    public Tiger() {
        super("Tiger",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}