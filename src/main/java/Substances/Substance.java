package Substances;

public class Substance {
    public final Double freezePoint;
    public final Double evaporationPoint;
    public Double temperature;
    public String name;

    public WaterState state;

    Substance(String name, Double freezePoint, Double evaporationPoint) {
        this.name = name;
        this.freezePoint = freezePoint;
        this.evaporationPoint = evaporationPoint;
    }

    public void setTemperature(Double temp) {
        this.temperature = temp;
        if(temp <= freezePoint) state = WaterState.SOLID;
        else if(temp < evaporationPoint) state = WaterState.LIQUID;
        else state = WaterState.GAS;
    }

    public WaterState getState() {
        return state;
    }

}
