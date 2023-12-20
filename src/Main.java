import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       File file=new File("surya","surya@gmail.com","09987654","USA");
       //work with Gson library
        Gson gson=new Gson();
        //convert to JSON
        String myJson=gson.toJson(file);
        System.out.println(myJson);
        //write to a file
        try( FileWriter writer=new FileWriter("file1.json");){
            gson.toJson(file,writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //read from a file
        try(FileReader fileReader=new FileReader("file1.json")){
            File file1=gson.fromJson(fileReader,File.class);
            System.out.println(file1);
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}