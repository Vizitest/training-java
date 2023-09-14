package B_B70_ArrayListEnum;

import java.util.List;

public class ArrayListEnum {
    public static String setValues(int[] intArray, List<String> stringList, WaterState waterState) throws Exception {
        if(intArray.length < 3 || stringList == null || stringList.isEmpty() || waterState == null)
            throw new Exception("Invalid input parameter somewhere");
        if(waterState == WaterState.SOLID)
            return intArray[0] + " " + stringList.get(0) + " " + waterState.name();
        else if(waterState == WaterState.LIQUID)
            return intArray[1] + " " + stringList.get(1) + " " + waterState.name();
        else
            return intArray[2] + " " + stringList.get(2) + " " + waterState.name();
    }
}
