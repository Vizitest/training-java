package C_I70_SideEffects;

public class SideEffects {
    private double currentValue;

    SideEffects() {
        this.currentValue = 100;
    }

    public void multiplyBy(double multiplicand) {
        this.currentValue *= multiplicand;
    }
}
