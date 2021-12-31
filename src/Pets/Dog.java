package Pets;

import Base.Pet;
import Base.Utils;

public class Dog extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Dog");
    }

    public Dog() {
        super("Dog",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}