package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Stopwatch {

    private Timer timer;
    private static final int duration = 10;
    private DecimalFormat twoPlaces;
    private int elapsedMillis = 0;
    private int tenths;
    private int seconds;
    private int mins;
    private StringBuilder result;

    private String results;
    private ReadResult readResult;
    private SaveResult saveResult;
    
    public Stopwatch(JLabel stopwatchLabel) {
       
        twoPlaces = new DecimalFormat("00");
        timer = new Timer(duration, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedMillis++;
                tenths = (elapsedMillis / 1) % 100;
                seconds = (elapsedMillis / 100) % 60;
                mins = (elapsedMillis / 6000) % 60;
                if (mins == 60) elapsedMillis = 0;
                stopwatchLabel.setText(twoPlaces.format(mins) + ":" + twoPlaces.format(seconds) + "." + twoPlaces.format(tenths));
            }
        });

    }
    public void initRead() throws FileNotFoundException, IOException{
        readResult = new ReadResult();
        readResult.read();
    }
    public void reset(JLabel stopwatchLabel){
        elapsedMillis = 0;
        stopwatchLabel.setText("00:00.00");
        
    }
    public void saveResult(JTextArea resultArea) throws Exception{
        result = new StringBuilder();
        result.append(twoPlaces.format(mins) + ":" + twoPlaces.format(seconds) + "." + twoPlaces.format(tenths));
        saveResult = new SaveResult();
        saveResult.save(result.toString());

        
    }
    public void deleteResult() throws IOException, Exception{
        saveResult = new SaveResult();
        saveResult.delete();
    }
    public void readResult(JTextArea resultArea) throws FileNotFoundException, IOException{
        initRead();       
        resultArea.setText(readResult.getResults());

    }
    public int getTokensNumber() throws FileNotFoundException, IOException{
        initRead();
        return readResult.getTokensNumber();
    }
    public Timer getTimer() {
        return this.timer;
    }
}
