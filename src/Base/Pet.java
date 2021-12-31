package Base;

import java.lang.reflect.Method;

public class Pet extends Entity {

    static protected float[] parameters;

    protected int baseDamage, bonusDamage, tempDamage;
    protected int baseHealth, bonusHealth, tempHealth;
    protected int numStacks = 1;

    public Pet(String name, int tier, int baseDamage, int baseHealth) {
        super(name, tier);
        this.baseDamage = baseDamage;
        this.baseHealth = baseHealth;
    }

    public Reaction onBattleStart(){
        return null;
    }

    public Reaction onFaint(Pet faintedPet, boolean onMyTeam){
        return null;
    }

    public Reaction onHurt(Pet hurtPet, boolean onMyTeam){
        return null;
    }

    public Reaction onSummon(Pet summonedPet, boolean onMyTeam){
        return null;
    }

    public Reaction onKnockOut(){
        return null;
    }



    public Reaction onAttacking(){
        return null;
    }

    public Reaction onAttacked(){
        return null;
    }

    public Reaction wnDamage(){
        return null;
    }

    public int getLevel() {
        if (numStacks >= 6) return 3;
        if (numStacks >= 3) return 2;
        return 1;
    }

    public boolean takeDamage(int damage){
        //TODO: Check for armor
        this.tempHealth -= damage;
        return true;
    }


    public void giveTempDamage(int tempDamage){
        this.tempDamage += tempDamage;
    }

    public void giveTempHealth(int tempHealth){
        this.tempHealth += tempHealth;
    }

    public int getDamage(){
        // TODO: Check for steak and meat
        return baseDamage + bonusDamage + tempDamage;
    }

    public int getHealth(){
        return baseHealth + bonusHealth + tempHealth;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d) %s", getDamage(), getHealth(), this.name);
    }
}
