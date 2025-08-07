import java.util.ArrayList;
import java.util.List;
public class Bank {

    private List<User> users = new ArrayList<>();

    public Bank() {
        load();         // read users.txt at start‑up
    }

    /* ---------- public API ---------- */

    public User find(String account) {
        for (User u : users)
            if (u.getAccount().equals(account))
                return u;
        return null;
    }

    public void addUser(User u) {
        users.add(u);
        save();
    }

    public void deposit(User u, float amt) {
        u.deposit(amt);
        save();
        Transaction.log(u.getAccount(), "deposit", amt, u.getBalance());
    }

    public boolean withdraw(User u, float amt) {
        boolean ok = u.withdraw(amt);
        if (ok) {
            save();
            Transaction.log(u.getAccount(), "withdraw", amt, u.getBalance());
        }
        return ok;
    }

    /* ---------- file persistence ---------- */

    private void load() {
        List<String> lines = FileUtil.readAll("users.txt");
        for (String l : lines) users.add(User.fromCsv(l));
    }

    private void save() {
        List<String> lines = new ArrayList<>();
        for (User u : users) lines.add(u.toCsv());
        FileUtil.writeAll("users.txt", lines);
    }
}

