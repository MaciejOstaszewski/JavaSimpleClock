package Logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ReadResult {

    private FileReader reader;
    private BufferedReader bufferedReader;
    private StringBuilder results;
    private StringTokenizer tokenizer;

    public ReadResult() throws FileNotFoundException {
        reader = new FileReader("result.txt");
        bufferedReader = new BufferedReader(reader);
        results = new StringBuilder();
    }

    public void read() throws IOException {
        try {

            int buffer;
            while ((buffer = bufferedReader.read()) != -1) {
                results.append((char) buffer);
            }

        } catch (Exception e) {
        } finally {
            bufferedReader.close();
        }
    }

    public int getTokensNumber() throws FileNotFoundException {
        tokenizer = new StringTokenizer(getResults());
        return tokenizer.countTokens();
    }

    public String getResults() {
        return results.toString();
    }

}
