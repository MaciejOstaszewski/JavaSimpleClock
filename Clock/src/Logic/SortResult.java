
package Logic;

import Data.ResultsList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

public class SortResult {
    private ResultsList resultsList;
    private ReadResult readResult;
    private StringTokenizer tokenizer;
    
    public SortResult() throws FileNotFoundException, IOException{
        readResult = new ReadResult();
        readResult.read();
        resultsList = new ResultsList();
        tokenizer = new StringTokenizer(readResult.getResults());
        addTokens();
        sort();
        resultsList.print();
    }
    public void addTokens(){
        while (tokenizer.hasMoreTokens()) {


            resultsList.addElements(tokenizer.nextToken());
            
        }
        
    }
    public void sort(){
        resultsList.sort();
    }
    public String getResult(){
        return resultsList.getResult();
    }
}
    
