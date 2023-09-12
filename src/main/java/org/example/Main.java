package org.example;

import CreditCheck.CheckCredit;
import CreditCheck.CreditReturnStatus;
import org.joda.time.DateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting");
        DateTime dob = new DateTime(2005, 01, 04, 0, 0);
        CheckCredit person = new CheckCredit(dob, "Freddy May");
        try {
            System.out.println("Checking : " + person.getName() + ", Age: " + person.getAge());
            CreditReturnStatus result =  person.checkCredit(1000, 24);
            System.out.println(result.message);
            System.out.println(person.getResult().toString());
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}