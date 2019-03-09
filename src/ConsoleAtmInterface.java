import java.util.Scanner;

/**
 * A Java class that controls how the atm takes commands from the user
 * @author Adrian Smith
 * @version 1.0
 *
 */

public class ConsoleAtmInterface {

    private static final String QUIT_STRING = "q";
    private Scanner inDevice;


    /**
     * ConsoleAtmInterface Contstructor: initializes inDevice as scanner
     */
    public ConsoleAtmInterface() {
        inDevice = new Scanner(System.in);
    }

    /**
     * Reads a string
     * @return next line, if no line to read, returns null
     *
     */
    private String readString() {
        while (true){
            try {
                String line = inDevice.nextLine();
                return line;
            } catch (Exception e) {
                this.displayMessage("No line to read, try again.");
            }
        }

    }

    /**
     * Reads a number
     * @return value of nextline as an integer. If not an integer, returns 0
     */
    private int readNumber() {
        while(true) {
            try {
                String line = inDevice.nextLine();
                if (line.equals(QUIT_STRING)) {
                    return 0;
                }
                int value = Integer.parseInt(line);
                return value;
            } catch (NumberFormatException e) {
                this.displayMessage("Input not formatted properly! " + e.getMessage());
                this.displayMessage("Please try again.");
            }
        }
    }


    /**
     * Asks user for card
     * @return the card id or null if user wants to quit
     */
    String readCard() {
        while(true){
            try{
                this.displayMessage("Please enter your card id: ");
                String id = this.readString();

                if (id.equals(QUIT_STRING)) {
                    return null;
                } else {
                    return id;
                }

            } catch (Exception e){
                this.displayMessage("Something went wrong. Try again.");
            }
        }

    }

    /**
     * Asks user for their pin number
     * @return their pin or null if they want to quit
     */
    String readPin() {
        while(true) {
            try{
                this.displayMessage("Enter " + QUIT_STRING + " to exit at any point.");
                this.displayMessage("Please enter your pin: ");
                String pin = this.readString();

                if (pin.equals(QUIT_STRING)) {
                    return null;
                } else {
                    return pin;
                }
            } catch (Exception e){
                this.displayError("Something went wrong. Try again.");
            }

        }

    }

    /**
     * Determines the kind of transaction user would like to make
     * @return TransactionType of desired action
     */
    TransactionType chooseTransactionType() {


        while (true){
            try{
                TransactionType[] transactionTypes = TransactionType.values();
                for (int i=0; i < transactionTypes.length; i++) {
                    this.displayMessage(i+1 + ". " + transactionTypes[i]);
                }
                String userIn = this.readString();
                switch (userIn){
                    case "1":
                        this.displayMessage("Check balance selected");
                        return TransactionType.CHECK_BALANCE;
                    case "2":
                        this.displayMessage("Deposit selected");
                        return TransactionType.DEPOSIT;
                    case "3":
                        return TransactionType.WITHDRAWAL;
                    case QUIT_STRING:
                        break;
                }

            } catch (Exception e){
                this.displayMessage("Please enter a valid option");
            }
        }

    }

    /**
     * Returns users card
     */
    void returnCard() {
        this.displayMessage("Here's your card back.");
    }

    /**
     * Reads user's accounts
     * @param accounts Current user's accounts
     * @return The account the user would like to select
     */
    Account readAccount(Account[] accounts) {
        while(true) {

            try {
                for (int i = 0; i < accounts.length; i++) {
                    this.displayMessage(i + 1 + ". " + accounts[i].toString());
                }
                this.displayMessage(accounts.length+1 + ". Exit");
                this.displayMessage("Please enter an account: ");

                int accountNum = this.readNumber();

                return accounts[accountNum - 1];
            } catch (Exception e){
                this.displayError("Please enter a correct account number");
            }

        }

    }


    /**
     * Asks user how much $ is in the envelope
     * @return Amount deposited
     */
    int takeDepositEnvelope() {
       this.displayMessage("How much are you depositing? ");
       return this.getAmount();
    }

    /**
     * Delivers user money
     * @param amount How much money the atm gives to the user.
     */
    void deliverMoney(int amount) {
        this.displayMessage("Here is $" + amount);
    }

    /**
     * Asks how much money the user wants to withdraw
     * @return Amount withdrawn
     */
    int readWithdrawalAmount(){
        this.displayMessage("Enter amount to withdraw: ");
        return this.getAmount();
    }

    /**
     * Asks user for integer amount
     * @return Amount
     */
    private int getAmount(){
        while (true){
            try {
                int response = this.readNumber();
                return response;
            } catch (Exception e){
                this.displayMessage("Something went wrong");
            }

        }

    }

    /**
     * Prints a message to the user
     * @param message The message you want to show the user.
     */
    void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints a error message to the user
     * @param errorMessage The error message you want to show the user.
     */
    void displayError(String errorMessage) {
        this.displayMessage(errorMessage);
    }

    /**
     * Displays new account balance after transaction
     * @param account The account of the current user that you want to display the balance of.
     */
    void displayNewBalance(Account account) {
        this.displayMessage("Your new balance is: " + account.getBalance());
    }

}
