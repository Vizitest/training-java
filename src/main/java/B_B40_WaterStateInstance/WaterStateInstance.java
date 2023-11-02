package B_B40_WaterStateInstance;

public class WaterStateInstance {

    private double temperature;
    private String state;

    WaterStateInstance(double temperature) {
        this.temperature = temperature;
        if(temperature < -273.15) {
            this.state = "invalid temperature";
        }
        else if(temperature <= 0) {
            this.state = "solid";
        }
        else if(temperature > 0 && temperature < 100) {
            this.state = "liquid";
        }
        else {
            this.state = "gas";
        }
    }

    public String getWaterState() {
        return this.state;
    }
}

