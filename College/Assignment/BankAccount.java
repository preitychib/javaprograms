abstract public class BankAccount {
    //? Attributes:
    String accountNumber;
    double balance;

    //? Constructor
    BankAccount(String accountNo,double bal){
        accountNumber = accountNo;
        balance = bal;
    }
    //? Methods
    void deposit(double amount) {
        if (amount > 0)
            balance += amount;
        else
            System.out.println("Enter an amount greater than zero.");
    }

    void withdraw(double amount) {
        if (balance - amount >= 0)
            balance -= amount;
        else
            System.out.println("Insufficient balance, Try any other amount.");
    }

    String getAccountNumber() {
        return accountNumber;
    }

    double getBalance() {
        return balance;
    }

    abstract double calculateInterest();
}

class SavingAccount extends BankAccount {
    double interestRate;
    SavingAccount(String accountNumber,double balance,double interest) {
        super(accountNumber, balance);
        interestRate = interest;
    }
    double calculateInterest() {
        return (balance * interestRate) / 100;
    }

    void addInterest() {
        deposit(calculateInterest());
    }

}

class CheckingAccount extends BankAccount {
    double transactionFee;
    double interestRate;
    CheckingAccount(String accountNumber,double balance,double fee,double interest) {
        super(accountNumber, balance);
        transactionFee = fee;
        interestRate = interest;
    }
    double calculateInterest() {
        return (balance*interestRate)/100;
    }

    void deposit(double amount) {
        super.withdraw(transactionFee);
        super.deposit(amount);
    }
    void withdraw(double amount) {
        super.withdraw(transactionFee);
        super.withdraw(amount);

    }

    void addInterest() {
        deposit(calculateInterest());
    }
}
