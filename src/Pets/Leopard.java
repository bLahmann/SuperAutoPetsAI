package Pets;

import Base.Pet;
import Base.Utils;

public class Leopard extends Pet {

    private static float[] parameters;

    public static void setParameters(){
        parameters = Utils.getParameters("Leopard");
    }

    public Leopard() {
        super("Leopard",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));
    }



}