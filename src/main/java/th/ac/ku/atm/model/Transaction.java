package th.ac.ku.atm.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private int id;
    private int bankId;
    private String Transactiontype;
    private double amount;

    public int getId() {
        return id;
    }

    public int getBankId() {
        return bankId;
    }

    public String getTransactiontype() {
        return Transactiontype;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public void setTransactiontype(String transactiontype) {
        Transactiontype = transactiontype;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", bankId=" + bankId +
                ", Transactiontype='" + Transactiontype + '\'' +
                ", amount=" + amount +
                '}';
    }
}
