import java.util.ArrayList;

/**
 * A Java class that defines a user at a Bank, tracking the user's id and pin
 * that they use at an ATM machine and the accounts the user owns.
 * @author Adrian Smith
 * @version 1.0
 *
 */


public class BankUser {

    private static ArrayList<BankUser> bankUsers = new ArrayList<>();


    Account[] accounts;
    String id;
    String name;
    String pin;



    /**
     * BankUser constructor method
     * @param name User's name
     * @param id User's id
     * @param pin User's pin number
     * @param accounts User accounts
     */

    public BankUser(String name, String id, String pin, Account[] accounts) {



        bankUsers.add(this);

        this.id = id;
        this.name = name;
        this.pin = pin;
        this.accounts = accounts;

    }

    /**
     * Gets BankUser's accounts
     * @return Account[]
     */

    public Account[] getAccounts() {
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
     * Get's bank user of specified id and pin
     * @param id Id of user
     * @param pin Pin of user
     * @return User or null
     */

    public static BankUser getUser(String id, String pin) {

        for (BankUser user : bankUsers) {
            if (pin.equals(user.pin) && id.equals(user.id))  {
                return user;
            }
        }
        return null;
    }

    /**
     * Converts BankUser info to string
     * @return String that displays bank user
     */

    @Override
    public String toString() {
        return this.name + "[" + "id: " + this.id + ":" +  "pin: " + this.pin + "]";
    }



}
