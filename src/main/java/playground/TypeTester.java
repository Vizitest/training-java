package playground;

import java.util.List;

public class TypeTester {

    // PRIMITIVES
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

    public static boolean testList(List<Money> myList) {
        return myList.size() == 3;
    }

    public static boolean testEnum(Enum<Colors> myEnum) {
        return myEnum.name() == "RED";
    }

    // COMPLEX


}

class Money {
    public String currencyCode;
    public double amount;

    Money(String currencyCode, double amount) {
        this.currencyCode = currencyCode;
        this.amount = amount;
    }
}

class Transaction {
    public String transactionId;
    public Money money;

    Transaction(String transactionId, Money money) {
        this.transactionId = transactionId;
        this.money = money;
    }
}

enum Colors {
    RED,
    GREEN,
    BLUE
}