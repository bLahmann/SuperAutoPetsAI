package Base;

public class Entity {

    protected String name;
    protected int tier;
    protected boolean frozen;

    public Entity() {
    }

    public Entity(String name, int tier){
        this.name = name;
        this.tier = tier;
    }


}
