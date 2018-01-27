
package Logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;
import javax.swing.JTextArea;

public class SaveResult {
    private FileWriter writer;
    private BufferedWriter bufferedWriter;

    private StreamTokenizer tokenizer;
    public SaveResult() throws Exception{ 
    }
    
    public void save(String result) throws IOException{
        writer = new FileWriter("result.txt",true);
        bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(result+"\r\n");
        bufferedWriter.close();
    }
    public void delete() throws IOException{
        writer = new FileWriter("result.txt");
        bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("");
        bufferedWriter.close();
    }
    
}
