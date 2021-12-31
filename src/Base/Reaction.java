package Base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reaction {

    private Pet reactingPet;
    private Method effect;

    public Reaction(Pet reactingPet, Method effect) {
        this.reactingPet = reactingPet;
        this.effect = effect;
    }

    public Object invoke(Object ... args) throws IllegalAccessException, InvocationTargetException {
        return effect.invoke(reactingPet, args);
    }

    public Pet getReactingPet() {
        return reactingPet;
    }

    public Method getEffect() {
        return effect;
    }
}
