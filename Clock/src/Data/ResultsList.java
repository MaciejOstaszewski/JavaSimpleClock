package Data;

import Logic.ReadResult;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class ResultsList {

    private ArrayList<String> resultsList;
    private ReadResult readResult;
    private StringBuilder results;

    public ResultsList() {
        resultsList = new ArrayList<String>();
        results = new StringBuilder();
    }

    public void addElements(String element) {
        resultsList.add(element+"\r\n");

    }

    public ArrayList getElements() {
        return resultsList;
    }

    public void sort() {
        Collections.sort(resultsList);
    }

    public void print() {
        for (String s : resultsList) {
            System.out.println(s);
        }
    }

    public String getResult() {
        for (String s : resultsList) {
            results.append(s);
        }
        return results.toString();
    }
}
