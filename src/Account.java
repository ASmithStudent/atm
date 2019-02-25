/**
 * A Java class that allows a user to create an account that stores the type of account,
 * the name of the person that owns the account, and the balance of the account.
 * @author Adrian Smith
 * @version 1.0
 *
 */

public class Account {

    int balance;
    String name;
    String type;

    /**
     * Constructor method that takes in account type, name of account, and initial balance.
     * @param type
     * @param name
     * @param amount
     */
    public Account(String type, String name, int amount) {
        this.type = type;
        this.name = name;
        this.balance = amount;
    }

    /**
     * Adds amount to account's balance
     * @param amount
     */
    void credit(int amount) {
        this.balance += amount;
    }

    /**
     * Subtracts amount from account balance, only if the account's new balance is not less than 0.
     * Returns true if new balance is greater than 0, false if new account balance is less than 0.
     * @param amount
     * @return boolean
     */
    boolean debit(int amount) {
        int new_balance = this.balance - amount;

        if (new_balance <= 0) {
            return false;
        } else {
            this.balance = new_balance;
            return true;
        }
    }

    /**
     * Returns account balance
     * @return integer
     */
    int getBalance() {
        return this.balance;
    }

    /**
     *
     * @param name
     * @param type
     * @param balance
     * @return String
     */

    public String toString(String name, String type, int balance) {
        return "Name: " + name + " Type: " + type + " Balance: " + balance;
    }


    public static void main(String[] args) {

        Account account1 = new Account("checking", "Adrian", 1000);

        account1.credit(500);
        String account1Info = account1.toString(account1.name, account1.type, account1.balance);

        System.out.print(account1Info);


//        account1.credit(10);
//        System.out.println("Account type: " + account1.type + " Account name: " + account1.name + " Account balance: " + account1.balance);
//
//        account1.debit(9);
//        System.out.println("Account type: " + account1.type + " Account name: " + account1.name + " Account balance: " + account1.balance);
//
//        account1.getBalance();
//        System.out.println("Account type: " + account1.type + " Account name: " + account1.name + " Account balance: " + account1.balance);
//
//        Account account2 = new Account("savings", "Jack", 5000);
//
//        account2.credit(100);
//        System.out.println("Account type: " + account2.type + " Account name: " + account2.name + " Account balance: " + account2.balance);
//
//        account2.debit(1000);
//        System.out.println("Account type: " + account2.type + " Account name: " + account2.name + " Account balance: " + account2.balance);
//
//        account2.getBalance();
//        System.out.println("Account type: " + account2.type + " Account name: " + account2.name + " Account balance: " + account2.balance);


    }

}
