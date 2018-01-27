package Interface;

import Logic.SortResult;
import Logic.Stopwatch;
import Logic.Watch;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ActionBody {

   // private Watch newWatch;
   // private Stopwatch stopwatch;
    private JLabel timeLabel;
    private JLabel dateLabel;
    private boolean start = false;
    public ActionBody(JLabel timeLabel, JLabel dateLabel) {
        this.timeLabel = timeLabel;
        this.dateLabel = dateLabel;

    }

    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }

    public void setDateLabel(JLabel dateLabel) {
        this.dateLabel = dateLabel;
    }

    public void setTimeButtonAction(JLabel timeLabel, Watch newWatch) {
        newWatch.setYear(newWatch.getYear());
        newWatch.setMonth(newWatch.getMonth());
        newWatch.setDay(newWatch.getDay());
        newWatch.setHour(Integer.parseInt(JOptionPane.showInputDialog("Podaj godzine")));
        newWatch.setMinute(Integer.parseInt(JOptionPane.showInputDialog("Podaj minute")));
        newWatch.setSecond(Integer.parseInt(JOptionPane.showInputDialog("Podaj sekunde")));
//        newWatch = new Watch(newWatch.getYear(),
//                newWatch.getMonth(),
//                newWatch.getDay(),
//                Integer.parseInt(JOptionPane.showInputDialog("Podaj godzine")),
//                Integer.parseInt(JOptionPane.showInputDialog("Podaj minute")),
//                Integer.parseInt(JOptionPane.showInputDialog("Podaj sekunde")));

    }

    public void setDateButtonAction(JLabel dateLabel, Watch newWatch) {
        newWatch.setYear(Integer.parseInt(JOptionPane.showInputDialog("Podaj rok")));
        newWatch.setMonth(Integer.parseInt(JOptionPane.showInputDialog("Podaj miesiąc")));
        newWatch.setDay(Integer.parseInt(JOptionPane.showInputDialog("Podaj dzień")));
        newWatch.setHour(newWatch.getHour());
        newWatch.setMinute(newWatch.getMinute());
        newWatch.setSecond(newWatch.getSecond());
        newWatch.subMonth();
    }

    public void setSystemTimeButtonAction(JLabel timeLabel, Watch newWatch) {
        int year = newWatch.getYear();
        int month = newWatch.getMonth();
        int day = newWatch.getDay();
        newWatch.getStystemTime();
        newWatch.setYear(year);
        newWatch.setMonth(month);
        newWatch.setDay(day);
    }

    public void setSystemDateButtonAction(JLabel dateLabel, Watch newWatch) {

        int hour = newWatch.getHour();
        int minute = newWatch.getMinute();
        int second = newWatch.getSecond();
        newWatch.getSystemDate();
        newWatch.setHour(hour);
        newWatch.setMinute(minute);
        newWatch.setSecond(second);
    }
    public void setStopwatchButtonAction(JLabel stopwatchLabel, Stopwatch stopwatch, JButton startStopButton, JButton saveResultButton){
        saveResultButton.setEnabled(true);
        if(start == false){
        stopwatch.getTimer().start();
        startStopButton.setText("Zatrzymaj");
        start = true;
        } else if(start == true){
            stopwatch.getTimer().stop();
            startStopButton.setText("Wznów");
            start = false;
        }
        
    }
    public void setResetStopwatchButtonAction(JLabel stopwatchLabel, Stopwatch stopwatch, JButton startStopButton, JButton saveResultButton){       
        saveResultButton.setEnabled(false);
        stopwatch.getTimer().stop();
        stopwatch.reset(stopwatchLabel);
        startStopButton.setText("Start");
        start = false;
    }
    public void setSaveResultStopwatchButtonAction(Stopwatch stopwatch, JTextArea resultArea, int tokensNumber) throws Exception{
        
        if(stopwatch.getTokensNumber()<5 ){
        stopwatch.saveResult(resultArea);
        stopwatch.readResult(resultArea);
            
        }else JOptionPane.showMessageDialog(null, "brak pamieci");
    }
    public void setDeleteResultStopwatchButtonAction(Stopwatch stopwatch, JTextArea resultArea, int tokensNumber) throws IOException, Exception{
        stopwatch.deleteResult();
        tokensNumber = 0;
        stopwatch.readResult(resultArea);
        
    }
    public void setSortResultButtonAction(JTextArea resultArea) throws FileNotFoundException{
        SortResult sortResult = new SortResult();
        resultArea.setText(sortResult.getResult());
    }
}
