package C_I40_MultipleMethods;

public class MultipleMethods {

    private double currentValue;

    public MultipleMethods(double currentValue) {
        this.currentValue = currentValue;
    }

    public double multiplyBy(double multiplicand) {
        this.currentValue *= multiplicand;
        return this.currentValue;
    }

    public double divideBy(double divisor) {
        this.currentValue /= divisor;
        return this.currentValue;
    }

}
