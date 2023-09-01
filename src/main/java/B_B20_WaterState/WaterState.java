package B_B20_WaterState;

public class WaterState {
    public static String getWaterState(double temperature) throws Exception {
        if(temperature <= -273.15) {
            // There's a deliberate mismatch here between the requirements
            // It should be < -273.15, not <=
            // We'll use this to show a failed test
            throw new Exception("Temperature is below absolute zero");
        }
        if(temperature <= 0) {
            return "solid";
        }
        else if(temperature > 0 && temperature < 100) {
            return "liquid";
        }
        else
            return "gas";
    }
}

