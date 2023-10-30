package org.example;

import B_B80_Generics.PrintItem;

public class Main {
    public static void main(String[] args) {

        PrintItem<String> itemString = new PrintItem<>("Fred");
        PrintItem<Double> itemDbl = new PrintItem<>(22.0);
        itemString.print();
        itemDbl.print();
    /*
        System.out.println("Starting");
        DateTime dob = new DateTime(2005, 01, 04, 0, 0);
        CheckCredit person = new CheckCredit(dob, "Freddy May");
        try {
            System.out.println("Checking : " + person.getName() + ", Age: " + person.getAge());
            CreditReturnStatus result =  person.checkCredit(1000, 25);
            System.out.println(result.message);
            System.out.println(person.getResult().toString());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    */
    }
}