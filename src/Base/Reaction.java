package Base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reaction {

    private Pet reactingPet, affectedPet;
    private Method effect;

    public Reaction(Pet reactingPet, Pet affectedPet, Method effect) {
        this.reactingPet = reactingPet;
        this.affectedPet = affectedPet;
        this.effect = effect;
    }

    public Object invoke(Battle battle) throws IllegalAccessException, InvocationTargetException {
        return effect.invoke(reactingPet, affectedPet, battle);
    }

    public Pet getReactingPet() {
        return reactingPet;
    }

    public Method getEffect() {
        return effect;
    }
}
