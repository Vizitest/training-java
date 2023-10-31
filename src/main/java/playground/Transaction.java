package playground;

import playground.Money;

public class Transaction {
    public String transactionId;
    public Money money;

    Transaction(String transactionId, Money money) {
        this.transactionId = transactionId;
        this.money = money;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Money getMoney() {
        return money;
    }

    public Transaction getTransaction() {
        return this;
    }
}
