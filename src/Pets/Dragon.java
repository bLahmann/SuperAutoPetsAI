package Pets;

import Base.Pet;
import Base.Utils;

public class Dragon extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Dragon");
    }

    public Dragon() {
        super("Dragon",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}