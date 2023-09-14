package CreditCheck;

import org.joda.time.DateTime;
import org.joda.time.Period;

/*
This is a contrived class designed to play around with many of the Vizitest
features.

Requirements
------------
We offer credit to people aged 18 years and older.
  - If between 18 and 25 inclusive, we
      a) offer a maximum credit of 1000 and
      b) maximum repayment period of 24 months or less
  - If 26 or older
      a) offer a maximum credit of 10000 and
      b) maximum repayment period of 48 months or less

Implementation Summary
----------------------
- If under 18 then throw custom exception AgeException
- If length of name <=2 then throw a General Exception
- Return approval results in a CreditReturnStatus object

*/

public class CheckCredit {
    private final String name;
    private final int age;
    private CreditReturnStatus result;

    public CheckCredit(DateTime dob, String name) {
        DateTime now = new DateTime();
        Period period = new Period(dob, now);
        this.age = period.getYears();
        this.name = name;
        this.result = null;
    }

    private void validatePerson() throws Exception {
        if(name.length() < 2) {
            throw new Exception("Name too short");
        }
        else if(age <= 0) {
            throw new AgeException("Invalid age");
        }
        else if(this.age < 18) {
            throw new AgeException("Too young");
        }
    }

    public CreditReturnStatus checkCredit(int creditSought, int duration) throws Exception {
        // Validation
        validatePerson();

        // Prepare return object
        CreditReturnStatus response = new CreditReturnStatus();
        response.approved = false;

        if (age < 26) {
            if(creditSought > 1000) {
                response.message = "We only offer up to 1000 of credit for 18 to 25 year olds";
            }
            else if(duration > 24) {
                response.message = "We offer max 24 months of credit for 18 to 25 year olds";
            }
            else {
                response.approved = true;
                response.message = this.name + " : your credit has been approved";
            }
        }
        else {
            if(creditSought > 10000) {
                response.message = "We only offer up to 10000 of credit if you're 26 or older";
            }
            else if(duration > 48) {
                response.message = "We offer max 48 months of credit if you're 26 or older";
            }
            else {
                response.approved = true;
                response.message = this.name + " : your credit has been approved";
            }
        }

        // We'll also set the result property, so we can demonstrate Side Effects
        this.result = response;

        return response;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public CreditReturnStatus getResult() {
        return result;
    }
}

/*

The following code can be used in your generated Test Code to handle
a Custom Assertion instead of inspecting the return values.

// Custom Assertion #1 : use parameters
private static void assertMyCustomAssertion1(CheckCredit instance, CreditReturnStatus result, CustomMatcherIsApprovedTestData data) {
    // TODO implement Custom Assertion
    // please implement your own custom assertion here
    // you can find the parameters defined for your custom matcher under data.<name>CustomMatcher
    // assertEquals(data.<name>CustomMatcher, result);
    throw new UnsupportedOperationException();
}

// Custom Assertion #2 : use the Instance
private static void assertMyCustomAssertion2(CheckCredit instance, CreditReturnStatus result, CustomMatcherIsApprovedTestData data) {
    // TODO implement Custom Assertion
    // please implement your own custom assertion here
    // you can find the parameters defined for your custom matcher under data.<name>CustomMatcher
    // assertEquals(data.<name>CustomMatcher, result);
    throw new UnsupportedOperationException();
}


*/
