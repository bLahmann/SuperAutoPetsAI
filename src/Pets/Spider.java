package Pets;

import Base.Pet;
import Base.Utils;

public class Spider extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Spider");
    }

    public Spider() {
        super("Spider",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}