package Substances;

public class Water extends Substance {
    private boolean isDrinkable;

    Water(boolean isDrinkable) {
        super("water", 0.0, 100.0);
        this.isDrinkable = isDrinkable;
    }
}
