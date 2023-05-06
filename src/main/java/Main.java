import java.io.IOException;

public class Main {
    UserInterface userInterface;
    
    public Main(){
        Budget budget = new Budget("Budget");

        try {
            budget = FileSaver.loadBudget();
            userInterface = new UserInterface(budget);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

   
    public static void main(String args[]){
        
        Main main = new Main();
        System.out.println("\n \n \n \n \n \n \n \n");

        main.userInterface.Draw();
    }


}
