package homeWorks.homeWork19.task2;

public class Account {
    private String number;
    private long balance;

    public Account(String number, long balance) {
        setNumber(number);
        setBalance(balance);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
