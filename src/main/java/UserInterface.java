import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Budget budget;
    Account currentAccount;
    Envelope currentEnvelope;
    Entry currentEntry;

    public UserInterface(Budget budget){
        this.budget = budget;
    }

    public boolean chooseAccount(){
        System.out.print(budget);
        
        System.out.print("\nWhat Account do you want to access? ");
        String response = scanner.nextLine();

        if(response.toLowerCase() != "back" && budget.findByName(response) != null){

            currentAccount = budget.findByName(response);
            System.out.println();
            return true;

        }

        return false;

    }

    public boolean chooseEnvelope(){
        System.out.print(currentAccount);
        
        System.out.print("\nWhat Envelope do you want to access? ");
        String response = scanner.nextLine();

        if(response.toLowerCase() != "back" && currentAccount.findByName(response) != null){
            currentEnvelope = currentAccount.findByName(response);
            System.out.println();
            return true;
        }

        return false;

    }

    public boolean chooseEntry(){
        System.out.print(currentEnvelope);
        
        System.out.print("\nWhat Entry do you want to access? ");
        String response = scanner.nextLine();

        if(response.toLowerCase() != "back" && currentEnvelope.findByName(response) != null){
            currentEntry = currentEnvelope.findByName(response);
            System.out.println();
            return true;
        }

        return false;
    }

    public void Draw(){

        if(currentAccount == null ){
            chooseAccount();
        }
        if(currentEnvelope == null){
            chooseEnvelope();
        }
        if(currentEntry == null){
            chooseEntry();
        }
    }

}
