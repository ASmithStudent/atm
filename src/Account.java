/**
 * A Java class that allows a user to create an account that stores the type of account,
 * the name of the person that owns the account, and the balance of the account.
 * @author Adrian Smith
 * @version 1.0
 *
 */

public class Account {

   public static int idCount;

   private String type;
   private String name;
   private int balance;
   private String accountId;


    /**
     * Constructor method that takes in account type, name of account, and initial balance.
     * @param type Type of account
     * @param name Name of account
     * @param amount How much is in the account
     */
    public Account(String type, String name, int amount) {
        this.type = type;
        this.name = name;
        this.balance = amount;
        idCount++;
        this.accountId = "BankOfUSF" + idCount;
    }

    /**
     * Adds amount to account's balance
     * @param amount How much money to add to the account
     */
    void credit(int amount) {
        this.balance += amount;
    }

    /**
     * Subtracts amount from account balance, only if the account's new balance is not less than 0.
     * Returns true if new balance is greater than 0, false if new account balance is less than 0.
     * @param amount How much money to remove from the account
     * @return boolean True or false
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
     * @return integer of user balance
     */
    int getBalance() {
        return this.balance;
    }

    /**
     *
     * @return A string with account details
     */

    public String toString() {
        return this.name + " " + this.type + "[" + this.type + " id=" + this.accountId + "]";
    }

}
