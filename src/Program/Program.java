package Program;

import Base.Battle;
import Base.Files;
import Base.Pet;
import Pets.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public final static boolean DEBUG = true;

    public static void main(String ... args){

        // Init the parameters of all entity classes
        setParameters();

        List<Pet> teamA = new ArrayList<>();
        teamA.add(new Cricket());
        teamA.add(new Ant());
        teamA.add(new Horse());

        List<Pet> teamB = new ArrayList<>();
        teamB.add(new Mosquito());

        Dodo dodo = new Dodo();
        dodo.giveTempDamage(10);
        teamB.add(dodo);
        teamB.add(new Ant());

        Battle battle = new Battle(teamA, teamB);
        Battle.RESULT result = battle.simulate();

        System.out.println("Done");




    }

    // TODO: There has to be a better way to do this
    public static void setParameters(){
        Ant.setParameters();
        Beaver.setParameters();
        Cricket.setParameters();
        Duck.setParameters();
        Fish.setParameters();
        Horse.setParameters();
        Mosquito.setParameters();
        Otter.setParameters();
        Pig.setParameters();
        Crab.setParameters();
        Dodo.setParameters();
        Elephant.setParameters();
        Flamingo.setParameters();
        Hedgehog.setParameters();
        Peacock.setParameters();
        Rat.setParameters();
        Shrimp.setParameters();
        Spider.setParameters();
        Swan.setParameters();
        Badger.setParameters();
        Blowfish.setParameters();
        Camel.setParameters();
        Dog.setParameters();
        Giraffe.setParameters();
        Kangaroo.setParameters();
        Ox.setParameters();
        Rabbit.setParameters();
        Sheep.setParameters();
        Snail.setParameters();
        Turtle.setParameters();
        Bison.setParameters();
        Deer.setParameters();
        Dolphin.setParameters();
        Hippo.setParameters();
        Parrot.setParameters();
        Penguin.setParameters();
        Rooster.setParameters();
        Skunk.setParameters();
        Squirrel.setParameters();
        Whale.setParameters();
        Worm.setParameters();
        Cow.setParameters();
        Crocodile.setParameters();
        Monkey.setParameters();
        Rhino.setParameters();
        Scorpion.setParameters();
        Seal.setParameters();
        Shark.setParameters();
        Turkey.setParameters();
        Boar.setParameters();
        Cat.setParameters();
        Dragon.setParameters();
        Fly.setParameters();
        Gorilla.setParameters();
        Leopard.setParameters();
        Mammoth.setParameters();
        Snake.setParameters();
        Tiger.setParameters();
    }

    public static void writeMyCode(){

        try {
            Scanner s = new Scanner(Files.PET_DATA);
            s.nextLine();

            while (s.hasNextLine()) {


                String line = s.nextLine();
                String[] entries = line.split(",");
                String name = entries[0];

                File file = new File("src/Pets/" + name + ".java");
                System.out.println(name + ".setParameters();");

                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter w = new FileWriter(file);
                w.write(String.format("package Pets;\n" +
                        "\n" +
                        "import Base.Pet;\n" +
                        "import Base.Utils;\n" +
                        "\n" +
                        "public class %s extends Pet {\n" +
                        "\n" +
                        "    private static float[] parameters;\n" +
                        "\n" +
                        "    public static void setParameters(){\n" +
                        "        parameters = Utils.getParameters(\"%s\");\n" +
                        "    }\n" +
                        "\n" +
                        "    public %s() {\n" +
                        "        super(\"%s\",  Math.round(parameters[1]), Math.round(parameters[2]), Math.round(parameters[3]));\n" +
                        "    }\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "}", name, name, name, name));
                w.close();


            }

            s.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
