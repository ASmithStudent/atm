/**
 * Handles the main functionality of the ATM.
 * @author Adrian Smith
 * @version 1.0
 *
 */
public class Atm {

    static int sessionNumber = 0;

    private BankUser currentUser;
    private int moneySupply;
    private ConsoleAtmInterface ui = new ConsoleAtmInterface();

    /**
     * Atm constructor
     * @param moneySupply How much money the atm has
     */
    public Atm(int moneySupply) {
        this.moneySupply = moneySupply;
        System.out.println("Session number: " + sessionNumber++);
    }

    /**
     * Reads the user Atm card gets the id and the pin and then if there is a matching user sets the current Atm user to
     * the matching user on success otherwise the Atm reports an error and continues to ask the user for id and pin
     * Note: IF there is already a current user when this is called, then handle as a continuation of the currentSession
     * @return true if session starts; false if user wants to exit
     */
    public boolean startSession() {
        while(true){
            try{
                if (currentUser != null){
                    return true;
                }

                String id = ui.readCard();
                String pin = ui.readPin();
                if(BankUser.getUser(id, pin) != null) {
                    currentUser = BankUser.getUser(id, pin);
                    ui.displayMessage("Hello " + currentUser.getName());
                    return true;
                } else {
                    ui.displayError("User id or pin not found. Try again");
                }
            } catch (Exception e){
                ui.displayError("Somethinng went wrong. Please try again.");
            }

        }

    }


    /**
     * Explicitly shuts off the Atm Setting currentUser to null
     */
    public void endSession(){
        currentUser = null;
        ui.returnCard();
    }


    /**
     * Requests the user to perform one of the following transactions
     * Check Balance, Withdraw Money, Deposit OR Exit and then performs the transaction
     * @return Transaction Type
     */
    public TransactionType performTransaction() {
        while(true){
            try{
                TransactionType transactionType = ui.chooseTransactionType();

                switch (transactionType){
                    case CHECK_BALANCE:
                        this.doCheckBalance();
                        return transactionType;
                    case DEPOSIT:
                        this.doDeposit();
                        return transactionType;

                    case WITHDRAWAL:
                        this.doWithdrawal();
                        return transactionType;
                    default:
                        return null;
                }

            }catch (Exception e){
                ui.displayError("Please enter a valid transaction type.");
            }

        }


    }

    /**
     * Performs a deposit of money into an Account 1. Asks user in which Account the deposit
     * is to be made 2. Get the Deposit Envelope 3. Make the Deposit
     */
    private void doDeposit() {
        while (true){
            try{
                Account userAccount = ui.readAccount(currentUser.getAccounts());
                int amountDeposited = ui.takeDepositEnvelope();
                userAccount.credit(amountDeposited);
                ui.deliverMoney(amountDeposited);
                ui.displayNewBalance(userAccount);
                break;

            } catch (Exception e){
                ui.displayError("Please enter a valid number.");
            }
        }


    }

    /**
     * Reports to user how much money is in an Account 1. Asks user which Account to check Balance 2. Display the Balance
     */
    private void doCheckBalance() {
        while (true){
            try{
                Account userAccount = ui.readAccount(currentUser.getAccounts());
                ui.displayMessage("Balance: " + userAccount.getBalance());
                break;
            } catch (Exception e){
                ui.displayError("Please enter a valid number.");
            }
        }

    }

    /**
     * Performs a withdrawal of money from an Account 1. Asks user from which Account withdrawal is to be made 2. Ask
     * user amount to withdraw 3. If account does not have enough money for withdrawal, report (via ui) error; otherwise
     * perform withdrawal and give user money
     */
    private void doWithdrawal() {
        while(true){
            try{
                Account userAccount = ui.readAccount(currentUser.getAccounts());
                int amountWithdrawn = ui.readWithdrawalAmount();

                if(userAccount.debit(amountWithdrawn)){
                    ui.displayNewBalance(userAccount);
                    break;

                } else {
                    ui.displayError("You do not have enough money in this account to withdraw " + amountWithdrawn);
                }
            }catch(Exception e){
                ui.displayError("Please enter a valid number.");
            }
        }

    }

}
