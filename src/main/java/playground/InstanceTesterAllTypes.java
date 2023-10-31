package playground;

import java.util.List;

public class InstanceTesterAllTypes {
    private int inInt;
    private String inString;
    private double inDouble;
    private int[] inIntArray;
    private List<Integer> inIntList;
    private Colors inEnumColors;
    private Money inMoney;
    private Transaction inTransaction;


    public InstanceTesterAllTypes(int inInt, String inString, double inDouble, int[] inIntArray, List<Integer> inIntList, Colors inEnumColors, Money inMoney, Transaction inTransaction) {
        this.inInt = inInt;
        this.inString = inString;
        this.inDouble = inDouble;
        this.inIntArray = inIntArray;
        this.inIntList = inIntList;
        this.inEnumColors = inEnumColors;
        this.inMoney = inMoney;
        this.inTransaction = inTransaction;
    }
}
