/**
 * The main method that runs the atm.
 * @author Adrian Smith
 * @version 1.0
 *
 */

public class AtmMain {

    /**
     * Main method that runs the atm
     * @param args String(Not used)
     */

    public static void main(String[] args) {
        // Instantiate atm
        Atm atm = new Atm(100000);

        // Instantiate Accounts
        Account adrianAcc1 = new Account("checking", "Main Checking", 1000);
        Account adrianAcc2 = new Account("savings", "Main Savings", 60000);
        Account adrianAcc3 = new Account("investment", "Main Investment Account", 100000);
        Account[] adrianAccounts = {adrianAcc1, adrianAcc2, adrianAcc3};

        Account prateekAcc1 = new Account("checking", "Main Checking", 100);
        Account prateekAcc2 = new Account("savings", "Main Savings", 2000);
        Account[] prateekAccounts = {prateekAcc1, prateekAcc2};

        Account dougAcc1 = new Account("checking", "Main Checking", 100);
        Account[] dougAccounts = {dougAcc1};



        // Instantiate users
        BankUser adrian = new BankUser("Adrian", "123456", "1234", adrianAccounts );
        BankUser prateek = new BankUser("Prateek", "123", "456", prateekAccounts );
        BankUser doug = new BankUser("Doug", "5432", "456", dougAccounts );


        System.out.println("Welcome to the USF Atm Machine");
        System.out.println("Created user " + adrian.toString());
        System.out.println("Created user " + prateek.toString());
        System.out.println("Created user " + doug.toString());

        while(true){
            Boolean session = atm.startSession();
            if(session){
                System.out.println("Performing transaction");
                TransactionType transaction = atm.performTransaction();
                if(transaction == null){
                    break;
                }
            } else {
                atm.endSession();
                break;
            }
        }
    }
}