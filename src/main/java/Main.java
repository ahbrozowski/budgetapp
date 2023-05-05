public class Main {
    UserInterface userInterface;
    
    public Main(){
        Budget budget = new Budget("Andrews budget");
        Account ally = new Account("Ally");
        Account costal = new Account("Costal");
        costal.addNew(new Envelope("savings", ally.getID()));
        costal.addNew(new Envelope("Spending", ally.getID()));
        ally.addNew(new Envelope("house fund", costal.getID()));

        budget.addNew(costal);
        budget.addNew(ally);



        userInterface = new UserInterface(budget);
    }

   
    public static void main(String args[]){
        
        Main main = new Main();
        System.out.println("\n \n \n \n \n \n \n \n");
        main.userInterface.Draw();
    }


}
