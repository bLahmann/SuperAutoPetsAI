package Base;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Pet extends Entity {

    static protected float[] parameters;

    protected int baseDamage, bonusDamage, tempDamage;
    protected int baseHealth, bonusHealth, tempHealth;

    public Pet(String name, int tier, int baseDamage, int baseHealth) {
        super(name, tier);
        this.baseDamage = baseDamage;
        this.baseHealth = baseHealth;
    }

}
