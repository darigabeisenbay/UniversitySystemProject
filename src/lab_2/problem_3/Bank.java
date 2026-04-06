package lab_2.problem_3;

import java.util.Vector;

public class Bank {
    private Vector<Account> accounts;

    public Bank() {
        accounts = new Vector<>();
    }
    public void openAccount(Account a) {
        accounts.add(a);
        System.out.println("Opened: " + a.toString());
    }
    public void closeAccount(int accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                System.out.println("Closing account: " + accounts.get(i).getAccountNumber());
                accounts.remove(i);
                return;
            }
        }
        System.out.println("Account #" + accountNumber + " not found.");
    }
    public void update() {
        for (Account a : accounts) {
            if (a instanceof SavingsAccount) {
                ((SavingsAccount) a).addInterest();
            } else if (a instanceof CheckingAccount) {
                ((CheckingAccount) a).deductFee();
            }
        }
        System.out.println("Bank update complete (Interest added and fees deducted).");
    }
    public void displayAccounts() {
        System.out.println(" Current Bank Accounts ");
        for (Account a : accounts) {
            a.print();
        }
    }

    public static void main(String[] args) {
        Bank myBank = new Bank();
        SavingsAccount sa = new SavingsAccount(101, 5.0);
        CheckingAccount ca = new CheckingAccount(102);
        Account basic = new Account(103);

        myBank.openAccount(sa);
        myBank.openAccount(ca);
        myBank.openAccount(basic);

        sa.deposit(1000);

        ca.deposit(500);
        ca.withdraw(100);
        ca.withdraw(10);

        myBank.displayAccounts();

        myBank.update();

        myBank.displayAccounts();

        myBank.closeAccount(103);
        myBank.displayAccounts();

    }

}