import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class FileSaver {



    static public void saveBudget(Container<Account> budget) throws JsonIOException, IOException{
        Gson gSon = new Gson();


        String fileString = gSon.toJson(budget);
        System.out.print("Successfully Saved!!");
        FileWriter fileWriter = new FileWriter("Budget.json");
        fileWriter.write(fileString);
        

        fileWriter.flush(); 
        fileWriter.close();

        
    }

    static public Budget loadBudget() throws IOException{
        Gson gSon = new Gson();

        Path filePath = Path.of("Budget.json");
       
        String content = Files.readString(filePath);
        
        Budget budget = gSon.fromJson(content, Budget.class);


        return budget;
        

    }



}
