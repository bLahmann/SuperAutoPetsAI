package Pets;

import Base.Pet;
import Base.Utils;

public class Swan extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Swan");
    }

    public Swan() {
        super("Swan",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}