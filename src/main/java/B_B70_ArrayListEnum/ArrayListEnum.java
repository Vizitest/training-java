package B_B70_ArrayListEnum;

import java.util.List;

public class ArrayListEnum {
    public static String setListTypeValues(int[] intArray, List<String> stringList, String waterState) throws Exception {
        if(intArray.length < 3 || stringList == null || stringList.size() < 3 || waterState == null)
            throw new Exception("Invalid input parameter somewhere");
        if(waterState.equals("solid") )
            return intArray[0] + " " + stringList.get(0) + " " + waterState;
        else if(waterState.equals("liquid"))
            return intArray[1] + " " + stringList.get(1) + " " + waterState;
        else
            return intArray[2] + " " + stringList.get(2) + " " + waterState;
    }
}

/*
public class ArrayListEnum {
    public static String setValues(int[] intArray, List<String> stringList, WaterStateEnum waterState) throws Exception {
        if(intArray.length < 3 || stringList == null || stringList.isEmpty() || waterState == null)
            throw new Exception("Invalid input parameter somewhere");
        if(waterState == WaterStateEnum.SOLID)
            return intArray[0] + " " + stringList.get(0) + " " + waterState.name();
        else if(waterState == WaterStateEnum.LIQUID)
            return intArray[1] + " " + stringList.get(1) + " " + waterState.name();
        else
            return intArray[2] + " " + stringList.get(2) + " " + waterState.name();
    }
}
*/

