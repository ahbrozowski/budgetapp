import java.io.IOException;

public class Main {

    UserInterface userInterface;
    public Main(){
        Budget budget;


        try {
            budget = FileSaver.loadBudget();
        } catch (IOException e) {
            budget = new Budget("Budget");
        }

        userInterface = new UserInterface(budget);



    }

   
    public static void main(String args[]){
        
        Main main = new Main();
        System.out.println("\n \n \n \n \n \n \n \n");

        main.userInterface.Draw();
    }


}
