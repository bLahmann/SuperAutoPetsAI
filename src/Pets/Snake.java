package Pets;

import Base.Pet;
import Base.Utils;

public class Snake extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Snake");
    }

    public Snake() {
        super("Snake",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}