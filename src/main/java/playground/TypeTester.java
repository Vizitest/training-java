package playground;

import java.util.List;

public class TypeTester {

    // PRIMITIVE VALUES
    public static boolean testBoolean(boolean myBoolean) {
        return myBoolean == true;
    }

    public static boolean testInt(int myInt) {
        return (myInt % 2) == 0;
    }

    public static boolean testString(String myString) {
        return myString == "Test String";
    }

    public static boolean testDouble(double myDouble) {
        return myDouble == 10.0;
    }

    // ARRAY, LIST, ENUM
    public static boolean testArray(int[] myIntArray) {
        return myIntArray.length == 3;
    }

    public static List<Money> testList(List<Money> myList) {
        return myList;
    }

    public static boolean testEnum(Colors myEnum) {
        return myEnum == Colors.RED;
    }

    // COMPLEX VALUES
    // Refer to Money and Transaction in this package


}
