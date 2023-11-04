package B_B50_Money;

public class Money {
    public String currencyCode;
    public double amount;

    Money(String currencyCode, double amount) {
        this.currencyCode = currencyCode;
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }
    public String getCurrencyCode() {
        return this.currencyCode;
    }
    public Money getMoney() {return this;}

}
