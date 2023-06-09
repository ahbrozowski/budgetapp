import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;



public class UserInterface {
    
    Scanner scanner = new Scanner(System.in);
   Budget budget;
    Account currentAccount;
    Container<Entry> currentEnvelope;
    Entry currentEntry;
    boolean run = true;

    UserInterface(Budget budget){
        this.budget = budget;
    }

    private void SelectControls(String sentCommand){

        String command = sentCommand.toLowerCase();
        switch(command){
            case "!change":
                changeHandler();
                break;
            case "!create": 
                createHandler();
                printHander();
                break;
            case "!delete": 
                deleteHandler();
                printHander();
                break;
            case "!quit":
                saveAndClose();
                break;
            case "!print":
                printHander();
                break;
            case "!help":
                printControls();
                break;
        }
    }

    private void createHandler() {
        System.out.print("\nWhat would you like to Create? an Account, Envelope or Transaction?");
        String response = getQuery();
        if(response == null){return;}

        switch(response.toLowerCase()){
            case "account":
                currentEntry = null;
                currentEnvelope = null;
                createAccount();
                break;
            case "envelope":
                currentEntry = null;
                if(currentAccount == null){
                    if(budget.getAll().size() == 1){
                        currentAccount = budget.getAll().get(0);
                    }
                    chooseAccount();
                }
                createEnvelope();
                break;
            case "transaction":
                if(currentAccount == null){
                    chooseAccount();
                }
                createTransaction();
                break;
        }           
    }

    private void deleteHandler() {
        System.out.print("\nWhat would you like to delete? an Account, Envelope or Transaction?");
        String response = getQuery();
        if(response == null){return;}

        switch(response.toLowerCase()){
            case "account":
                currentEntry = null;
                currentEnvelope = null;
                deleteAccount();
                break;
            case "envelope":
                currentEntry = null;
                if(currentAccount == null){
                    if(budget.getAll().size() == 1){
                        currentAccount = budget.getAll().get(0);
                    }
                    chooseAccount();
                }
                deleteEnvelope();
                break;
            case "transaction":
                if(currentAccount == null){
                    chooseAccount();
                }
                deleteTransaction();
                break;
        }          
    }

    private void changeHandler() {

        System.out.print("What would you like to change? Your Account, Envelope, or Entry?");
        String response = getQuery();
        if(response == null){
            return;
        }
        switch(response.toLowerCase()){
            case "account":
                chooseAccount();
                break;
            case "envelope":
                if(currentAccount == null){
                    if(budget.getAll().size() == 1){
                        currentAccount = budget.getAll().get(0);
                    }
                    chooseAccount();
                }
                chooseEnvelope();
                break;
            case "entry":
                if(currentAccount == null){
                    chooseAccount();
                }
                if(currentEnvelope == null){
                    chooseEnvelope();
                }
                chooseEntry();
                break;
        }           
    }

    private void chooseAccount(){
        currentEnvelope = null;
        currentEntry = null;
        System.out.print("Pick the Account\n");
        System.out.print(budget);
        
        boolean exists = false;
        while(!exists){
            String response = getQuery();
            if(response == null){
                return;
            }

            if(budget.findByName(response) != null){

                currentAccount = budget.findByName(response);
                System.out.println();
                exists = true;
        
            } else{
                System.out.print("\nthat account doesn't exist");
            }

        }

    }


    private void chooseEnvelope(){
        currentEntry = null;
        System.out.print("Pick the envelope\n");
        System.out.print(currentAccount);
        
        boolean exists = false;
        while(!exists){
            String response = getQuery();
            if(response == null){
                return;
            }

            if(currentAccount.findByName(response) != null){
                currentEnvelope = currentAccount.findByName(response);
                System.out.println();
                exists = true;
            } else{
                System.out.print("\nthat envelope doesn't exist");
            }

        }

    }

    private void chooseEntry(){
        System.out.print("Pick the Entry \n");
        System.out.print(currentEnvelope);
        boolean exists = false;
        while(!exists){
            String response = getQuery();
            if(response == null){
                return;
            }
            if(currentEnvelope.findByName(response) != null){
                currentEntry = currentEnvelope.findByName(response);
                System.out.println();
                exists = true;
            } else{
                System.out.print("\n" +"that extry doesn't exist");
            }
        }
    }

    public void Draw(){

        System.out.print("Hello! Welcome to my budgeting app!");
        System.out.print("\nUse !help to get a list of possible commands");

        while(run){
            getQuery();
        }
    }




    private void deleteAccount() {
        System.out.print("\nWhat account do you want to delete");
        String name = getQuery();
        if(name == null){return;}

        budget.removeByName(name);
        
    }

    private void deleteEnvelope() {
        System.out.print("\nWhat account do you want to delete");
        String name = getQuery();
        if(name == null){return;}

        currentAccount.removeByName(name);
    }

    private void deleteTransaction() {
        System.out.print("\nWhat transaction do you want to delete");
        System.out.print(currentAccount.printTransactions());
        String name = getQuery();
        if(name == null){return;}

        currentAccount.removeTransactionByName(name);
    }

    private void printControls() {
        System.out.println("The avalible controls are \n" + 
        "  !change, lets you choose what Account, envelope or entry you are currently on\n"+
        "  !create, allows you to create an account, envelope, or transaction\n"+
        "  !delete, allows you to delete an account, envelope, or transaction\n"+
        "  !print, prints the whole budget\n"+
        "  !quit, saves and quits the application\n"+
        "  !help, displays the avalible commands");

        
        
    }

    private void printHander() {
        System.out.println("");
        for (Account account : budget.getAll()) {  
            System.out.print(account.getName()  + " $" + account.getValue() + "\n");
            for (Container<Entry> envelope : account.getAll()) {
                System.out.print("\t" + envelope.getName() + " $" +envelope.getValue()+ "\n");
                for (Entry entry : envelope.getAll()) {
                    System.out.print("\t \t" + entry.toString()+"\n");
                }

            }
            
        }

    }

    



    private void saveAndClose() {
        try {
            FileSaver.saveBudget(budget);
            run = false;
        } catch (Exception e) {
           System.out.println("\nUh oh!! saving didn't work! maybe try again\n");
           e.printStackTrace();
        
        }

        
    }

    private void createTransaction() {
        System.out.print("\nWhat do you want to name the transaction");
        String name = getQuery();
        if(name == null){return;}
        System.out.print("\n How much is the transaction");
        double value = getDoubleQuery();

        System.out.println("\nWhen was this transaction?");
        LocalDate date = getDateQuery();
        Transaction transaction = new Transaction(date.toString(), value, name);
        UUID transactionID = currentAccount.addTransaction(transaction);

        breakInEntries(transactionID, transaction);
    }

    private void createAccount(){
        System.out.print("\nWhat do you want to name the Account");
        String name = getQuery();
        if(name == null){return;}

        Account account = new Account(name);
        currentAccount = account;
        budget.addNew(account);
    }

    private void createEnvelope(){
        System.out.print("\nWhat do you want to name the Envelope");
        String name = getQuery();
        if(name == null){return;}

        Container<Entry> envelope = new Container<Entry>(name);
        currentAccount.addNew(envelope);
        currentEnvelope = envelope;
        currentEnvelope = envelope;
    }

    private void breakInEntries(UUID transactionID, Transaction transaction) {
        
        System.out.println("\nHow many entries do you want to make?");
        int num = getIntQuery();    
        double[] values = new double[num];
        ArrayList<Container<Entry>> envelopes= new ArrayList<Container<Entry>>();
        for(int i = 0; i < num; i++){
            chooseEnvelope();
            envelopes.add(currentEnvelope);
            System.out.println("How much do you want this entry to be?");
            values[i] = getDoubleQuery();
            
        }
        boolean numbersAddUp = false;
            while(!numbersAddUp){
            try{
                transaction.createEntries(envelopes, values);
                numbersAddUp = true;
            } catch(Exception e){
                System.out.println("Those don't add up to the value of the transaction!! Pick some new values");
                for(int i = 0; i < num; i++){
                    System.out.println("How much do you want this entry to be for" + envelopes.get(i).getName());
                    values[i] = getDoubleQuery();
                }
            }
        }

        
    }

    private String getQuery(){
        System.out.print(": ");
        String response = scanner.nextLine();
        if(!response.isEmpty() && response.charAt(0) == '!'){
            SelectControls(response);
            return null;
        }
        return response;
    }

    private Double getDoubleQuery(){
        boolean isDouble = false;
        double value = 0;
        while(!isDouble) {
            String valueString = getQuery();
            if(valueString == null){return null;}
            try{
                value = Double.parseDouble(valueString);
                isDouble = true;
            } catch(Exception e){
                System.out.print("\nthats not a number. Please try again");
            }
        }
        return value;
    }

    private Integer getIntQuery(){
        boolean isInt = false;
        Integer value = 0;
        while(!isInt) {
            String valueString = getQuery();
            if(valueString == null){return null;}
            try{
                value = Integer.parseInt(valueString);
                isInt = true;
            } catch(Exception e){
                System.out.print("\nthats not a integer. Please try again");
            }
        }
        return value;
    }

    private LocalDate getDateQuery(){
        boolean isDate = false;
        LocalDate date = LocalDate.now();
        System.out.print("\nPlease enter a date in the formate YEAR-MM-DD");
        while(!isDate) {
            String dateString = getQuery();
            if(dateString == null){return null;}
            try{
                date = LocalDate.parse(dateString);
                isDate = true;
            } catch(Exception e){
                System.out.print("\nthats not a the right format. Please try again");
            }
        }
        return date;
    }
    

}


