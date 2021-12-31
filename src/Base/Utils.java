package Base;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Utils {

    public static float[] getParameters(String name) {

        File petData = Files.PET_DATA;

        try {
            Scanner s = new Scanner(petData);
            while (s.hasNextLine()){

                String line = s.nextLine();
                String[] strings = line.split(",");

                if (strings[0].equalsIgnoreCase(name)){

                    float[] parameters = new float[strings.length - 1];
                    for (int i = 1; i < strings.length; i++){
                        parameters[i-1] = Float.parseFloat(strings[i]);
                    }
                    s.close();
                    return parameters;
                }
            }
            s.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return null;

    }

}
