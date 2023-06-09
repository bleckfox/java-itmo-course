package homeWorks.homeWork19.task2;

public class Transaction {
    private String uuid;
    private long sum;
    private Account account;

    public Transaction(String uuid, long sum, Account account) {
        setUuid(uuid);
        setSum(sum);
        setAccount(account);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
