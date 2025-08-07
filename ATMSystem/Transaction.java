import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    private final LocalDateTime dateTime;
    private final String type;
    private final float amount;
    private final float balanceAfter;

    public Transaction(String type, float amount, float balanceAfter) {
        this.dateTime     = LocalDateTime.now();
        this.type         = type;
        this.amount       = amount;
        this.balanceAfter = balanceAfter;
    }

    public LocalDateTime getDateTime()    { return dateTime;      }
    public String        getType()        { return type;          }
    public float         getAmount()      { return amount;        }
    public float         getBalanceAfter(){ return balanceAfter;  }

    @Override
    public String toString() {
        return String.format("%s | %-8s | %8.2f | bal: %8.2f",
                dateTime, type.toUpperCase(), amount, balanceAfter);
    }

    /* ------------------------------------------------------------------
       NEW PART → lets the Bank write a one‑line record to transactions.txt
       ------------------------------------------------------------------ */
    public static void log(String account, String type, float amount, float balanceAfter) {
        String csv = LocalDateTime.now() + ","    // date/time
                + account + ","               // whose account
                + type + ","                  // deposit / withdraw
                + amount + ","                // amount
                + balanceAfter;               // balance after action
        FileUtil.append("transactions.txt", csv);
    }
}
