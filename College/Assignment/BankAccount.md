### Java Assignment 6

Suppose you are developing a simple banking application that supports different types of bank accounts
such as savings accounts and checking accounts. All accounts have a common set of features and behaviors,
but each type of account also has some unique characteristics.
Design and implement a Java program that consists of the following classes:
An abstract class called `BankAccount` that represents a generic bank account. It should have the following
attributes and methods:
 - Attributes:
 - `accountNumber` (String): The account number of the bank account.
- `balance` (double): The current balance of the bank account.
 - Methods:
 - `deposit(amount: double)`: Adds the specified amount to the account balance.
- `withdraw(amount: double)`: Subtracts the specified amount from the account balance.
 - `getAccountNumber(): String`: Returns the account number of the bank account.
 - `getBalance(): double`: Returns the current balance of the bank account.
 - `abstract calculateInterest()`: A method that should be implemented by subclasses to
 calculate the interest specific to each account type.
#
A subclass called `SavingsAccount` that extends the `BankAccount` class. It should have an additional
attribute called `interestRate` (double), which represents the annual interest rate for the savings account.
Implement the `calculateInterest()` method to calculate the interest based on the account's balance and
interest rate.
A subclass called `CheckingAccount` that extends the `BankAccount` class. It should have an additional
attribute called `transactionFee (double)’, which represents the fee charged for each transaction made on
the checking account. Implement the `calculateInterest()` method to calculate the interest based on the
account's balance, interest rate, and transaction fee.
In the `Main` class, create objects of both `SavingsAccount` and `CheckingAccount` classes, perform
various operations such as deposits, withdrawals, and interest calculations, and display the results.
Note: You can assume appropriate constructors and any additional methods as required.
Your task is to implement the `BankAccount`, `SavingsAccount`, and `CheckingAccount` classes according
to the given requirements and demonstrate their functionality in the `Main` class. Provide the complete Java
code solution for the above problem.
Remember to write clean code, handle necessary exceptions, and provide appropriate comments for clarity.