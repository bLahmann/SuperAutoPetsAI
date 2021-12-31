package Pets;

import Base.Pet;
import Base.Utils;

public class Giraffe extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Giraffe");
    }

    public Giraffe() {
        super("Giraffe",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}