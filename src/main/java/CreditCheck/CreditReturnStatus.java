package CreditCheck;

public class CreditReturnStatus {
    public boolean approved;
    public String message;

    public String toString() {
        return "Approved: " + this.approved + " Msg:" + this.message;
    }
}

