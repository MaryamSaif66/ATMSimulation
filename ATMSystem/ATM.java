import java.util.Scanner;
public class ATM {

    private Bank bank;
    private User current;
    private Scanner sc = new Scanner(System.in);

    public ATM(Bank bank) { this.bank = bank; }

    public void run() {
        System.out.println("=== Welcome to Simple ATM ===");

        while (true) {
            if (current == null) { insertCard(); continue; }
            showMenu();
        }
    }

    private void insertCard() {
        System.out.print("\nEnter account number (0 = quit): ");
        String acc = sc.nextLine().trim();
        if ("0".equals(acc)) {
            System.out.println("Bye!");
            System.exit(0);
        }
        User u = bank.find(acc);
        if (u == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter PIN: ");
        if (u.authenticate(sc.nextLine().trim())) {
            current = u;
            System.out.println("Hello " + u.getName() + "!");
        } else {
            System.out.println("Wrong PIN.");
        }
    }

    private void showMenu() {
        System.out.println("""
                \nChoose:
                1‑Balance
                2‑Deposit
                3‑Withdraw
                4‑Logout""");

        switch (sc.nextLine().trim()) {
            case "1" -> System.out.printf("Balance: %.2f%n", current.getBalance());

            case "2" -> {
                System.out.print("Amount to deposit: ");
                float amt = Float.parseFloat(sc.nextLine());
                bank.deposit(current, amt);
                System.out.println("Deposited.");
            }

            case "3" -> {
                System.out.print("Amount to withdraw: ");
                float amt = Float.parseFloat(sc.nextLine());
                if (bank.withdraw(current, amt))
                    System.out.println("Please collect your cash.");
                else
                    System.out.println("Insufficient funds.");
            }

            case "4" -> {
                current = null;
                System.out.println("Logged out.");
            }

            default -> System.out.println("Bad option.");
        }
    }
}

