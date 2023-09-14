package CreditCheck;

import java.util.Objects;

public class CreditReturnStatus {
    public boolean approved;
    public String message;

    public String toString() {
        return "Approved: " + this.approved + " Msg:" + this.message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditReturnStatus that = (CreditReturnStatus) o;
        return approved == that.approved && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(approved, message);
    }
}

