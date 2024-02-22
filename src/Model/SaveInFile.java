package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveInFile {

    public static void Save(Toy toy){
       try (FileWriter fw = new FileWriter("file.txt", true)) {
           String line = toy.getIdAndName();
           fw.write(line);
       } catch (IOException ex){
           System.out.println(ex.getMessage());
       }
    }
}
