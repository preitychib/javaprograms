public class TestBankAccount {
    public static void main(String[] args) {
        SavingAccount sAccount = new SavingAccount("SBI345611",4500,5);
        CheckingAccount cAccount = new CheckingAccount("SBI227849", 5000, 0.12,1);
        System.out.println("The balance in Savings Account with account number " + sAccount.getAccountNumber() + " is: "+ sAccount.getBalance() + " rupees");
        //? Deposit
        sAccount.deposit(1000);
        System.out.println("After deposit of 1000 rupees");
        System.out.println("The balance in Savings Account with account number " + sAccount.getAccountNumber() + " is: " + sAccount.getBalance() + " rupees");
        //? Withdraw
        sAccount.withdraw(200);
        System.out.println("After withdrawal of 200 rupees");
        System.out.println("The balance in Savings Account with account number " + sAccount.getAccountNumber() + " is: "+ sAccount.getBalance() + " rupees");
        //? Adding Interest
        sAccount.addInterest();
        System.out.println("After adding interest at a given period of time");
        System.out.println("The balance in Savings Account with account number " + sAccount.getAccountNumber() + " is: "+ sAccount.getBalance() + " rupees");
        
        System.out.println("The balance in Checking Account with account number " + cAccount.getAccountNumber()+ " is: " + cAccount.getBalance() + " rupees");
        //? Deposit
        cAccount.deposit(1000);
        System.out.println("After deposit of 1000 rupees");
        System.out.println("The balance in Checking Account with account number " + cAccount.getAccountNumber()+ " is: " + cAccount.getBalance() + " rupees");
        //? Withdraw
        cAccount.withdraw(200);
        System.out.println("After withdrawal of 200 rupees");
        System.out.println("The balance in Checking Account with account number " + cAccount.getAccountNumber()+ " is: " + cAccount.getBalance() + " rupees");
    }
}
