package C_I80_CustomAssertions;

public class CustomAssertion {

    private double currentValue;

    CustomAssertion() {
        this.currentValue = 100;
    }

    public static void multiplyByStaticVoid(double multiplicand) {
        // Does nothing
        // Rarely used case
    }

    public static double multiplyByStaticDouble(double value, double multiplicand) {
        return value * multiplicand;
    }

    public void multiplyByVoid(double multiplicand) {
        this.currentValue *= multiplicand;
    }

    public double multiplyByDouble(double value, double multiplicand) {
        this.currentValue *= multiplicand;
        return this.currentValue;
    }

    public double getCurrentValue() {
        return this.currentValue;
    }
}
