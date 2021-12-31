package Base;

import java.lang.reflect.Method;

public class Event {

    public enum TYPE {FAINTED_PET, HURT_PET, SUMMONED_PET}

    TYPE type;
    Pet affectedPet;

    public Event(TYPE type, Pet affectedPet) {
        this.type = type;
        this.affectedPet = affectedPet;
    }
}
