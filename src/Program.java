import Pets.Ant;
import Pets.Beaver;

public class Program {

    public static void main(String ... args){

        // Init the parameters of all entity classes
        setParameters();

        Ant ant = new Ant();
        Beaver beaver = new Beaver();

        beaver.toString();






    }

    // TODO: There has to be a better way to do this
    public static void setParameters(){
        Ant.setParameters();
        Beaver.setParameters();
    }
}
