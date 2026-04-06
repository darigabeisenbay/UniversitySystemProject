package lab_2.problem_3;

public class Account {
    private double balance; // The current balance
    private int accNumber; // The account number

    public Account(int a) {
        balance = 0.0;
        accNumber = a;
    }

    public void deposit(double sum) {
        balance += sum;
    }

    public void withdraw(double sum) {
        if (sum <= balance) {
            balance -= sum;
        } else {
            System.out.println("Could not withdraw");
        }
    }

    public double getBalance() {
        return balance;
    }

    public double getAccountNumber() {
        return accNumber;
    }

    public void transfer(double amount, Account other) {
        if (this.balance >= amount) {
            this.withdraw(amount);
            other.deposit(amount);
            System.out.println("Transferred " + amount + " to account " + other.getAccountNumber());
        }
    }
    @Override
    public String toString() {
        return "Account { balance= " + balance + " account number is " + accNumber;
    }

    public final void print() {
        System.out.println(toString());
    }
}
