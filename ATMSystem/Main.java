public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        if (bank.find("001122") == null && bank.find("004400") == null) {
            bank.addUser(new User("001122", "Hiba Asad", "1234", 3000));
            bank.addUser(new User("004400", "Ali Raza",  "0000", 5000));
            System.out.println("Demo users created.");
        }

        new ATM(bank).run();
    }
}

