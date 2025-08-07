public class User {
    private String account;
    private String name;
    private String pin;
    private float  balance;

    public User(String account, String name, String pin, float balance) {
        this.account = account;
        this.name    = name;
        this.pin     = pin;
        this.balance = balance;
    }

    /* ---------- domain methods ---------- */

    public boolean authenticate(String pin)      { return this.pin.equals(pin); }

    public void deposit(float amt)               { balance += amt; }

    public boolean withdraw(float amt) {
        if (amt > balance) return false;
        balance -= amt;
        return true;
    }

    /* ---------- helpers for file I/O ---------- */

    public static User fromCsv(String line) {
        //  account,name,pin,balance
        String[] p = line.split(",", -1);
        float bal  = Float.parseFloat(p[3]);
        return new User(p[0], p[1], p[2], bal);
    }

    public String toCsv() {
        return account + ',' + name + ',' + pin + ',' + balance;
    }
    public String getAccountNumber() {
        return account;
    }
    /* ---------- simple getters ---------- */

    public String getAccount() { return account; }
    public String getName()    { return name;    }
    public float  getBalance() { return balance; }
}
