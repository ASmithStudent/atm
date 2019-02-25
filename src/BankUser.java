/**
 * A Java class that defines a user at a Bank, tracking the user's id and pin
 * that they use at an ATM machine and the accounts the user owns.
 * @author Adrian Smith
 * @version 1.0
 *
 */


public class BankUser {

    Account[] accounts;
    String name;
    String id;
    String pin;


    /**
     * BankUser constructor method
     * @param name
     * @param id
     * @param pin
     * @param accounts
     */

    public BankUser(String name, String id, String pin, Account[] accounts) {
        this.name = name;
        this.id = id;
        this.pin = pin;
        this.accounts = accounts;
    }

    /**
     * Gets BankUser's accounts
     * @return Account[]
     */

    Account[] getAccounts() {

        return this.accounts;
    }

    /**
     * Gets BankUser's name
     * @return String
     */

    String getName() {
        return this.name;
    }

    /**
     * Converts BankUser info to string
     * @return String
     */

    @Override
    public String toString() {
        return this.name + "[" + this.id + ":" + this.pin + "]";
    }

    /**
     * Main method: Creates two users - one with 3 accounts and one with two accounts and then calls methods for each user
     * @param args
     * @return void
     *
     */

    public static void main(String[] args) {

        // First User
        Account user1Account1 = new Account("Checking", "Main", 200);
        Account user1Account2 = new Account("Savings", "Main Savings", 1000);
        Account user1Account3 = new Account("Investment", "Main Investment", 5000);
        Account[] user1Accounts = {user1Account1, user1Account2, user1Account3};

        BankUser user1 = new BankUser("Adrian", "usf", "123456", user1Accounts );
        Account[] userAccounts = user1.getAccounts();
        for (Account account : userAccounts) {
            System.out.println(account.toString(account.name, account.type, account.balance));
        }

        String user1Name = user1.getName();
        System.out.println("User 1's name: " + user1Name);

        String userInfo = user1.toString();
        System.out.println("User 1's info: " + userInfo);


        // Second User
        Account user2Account1 = new Account("Savings", "Main", 10000);
        Account user2Account2 = new Account("401k", "Main", 109000);


        Account[] user2Accounts = {user2Account1, user2Account2};
        BankUser user2 = new BankUser("Doug", "usf", "654321", user2Accounts);

        Account[] user2Accs = user2.getAccounts();
        for (Account account : user2Accs) {
            System.out.println(account.toString(account.name, account.type, account.balance));
        }

        String user2Name = user2.getName();
        System.out.println("User 2's name: " + user2Name);

        String user2Info = user2.toString();
        System.out.println("User 2's info: " + user2Info);

    }



}
