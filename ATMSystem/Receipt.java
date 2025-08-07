public class Receipt {
    private final Transaction t;
    private final User        u;

    public Receipt(Transaction transaction, User user) {
        this.t = transaction;
        this.u = user;
    }

    public String generateReceipt() {
        return  "\n===== ATM RECEIPT =====\n"
                + "Name           : " + u.getName()           + "\n"
                + "Account No.    : " + u.getAccountNumber()  + "\n"
                + "Transaction    : " + t.getType()           + "\n"
                + "Amount         : " + String.format("%.2f", t.getAmount()) + "\n"
                + "Balance After  : " + String.format("%.2f", t.getBalanceAfter()) + "\n"
                + "Date & Time    : " + t.getDateTime()       + "\n"
                + "========================\n";
    }
}
