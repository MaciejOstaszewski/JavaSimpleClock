package Interface;

import Logic.ReadResult;
import Logic.Stopwatch;
import Logic.Watch;
import Logic.WatchThread;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class MainPanel extends JPanel {
    Action action;
    
    private JButton setTimeButton;
    private JButton setDateButton;
    private JButton getSystemTimeButton;
    private JButton getSystemDateButton;
    
    private JLabel timeLabel;
    private JLabel dateJLabel;
    
    private JButton stopStartButton;
    private JButton resetButton;
    private JButton saveResultButton;
    private JLabel stopwatchLabel;
    private JTextArea resultArea;
    private JButton sortButton;
    private JButton deleteButton;
    
    private JSeparator separator;
    private JSeparator separator2;
    
    private WatchThread watchThread;
    private Watch newWatch;
    private Stopwatch stopwatch;
    private ReadResult readResult;
    private int tokensNumber;
    
    private Font labelsFont;
            
    public MainPanel() throws FileNotFoundException, IOException {
        setSize(650, 200);
        setLayout(null);
        
        setTimeButton = new JButton("Ustaw czas");
        setDateButton = new JButton("Ustaw date");
        getSystemTimeButton = new JButton("Pobierz czas z systemu");
        getSystemDateButton = new JButton("Pobierz date z systemu");
        timeLabel = new JLabel();
        dateJLabel = new JLabel();
        stopwatchLabel = new JLabel("00:00.00");
        stopStartButton = new JButton("Start");
        resetButton = new JButton("Reset");
        saveResultButton = new JButton("Zapisz wynik");
        sortButton = new JButton("Wyswietl wyniki rosnąco");
        deleteButton = new JButton("Usuń wyniki");
        resultArea = new JTextArea();
        separator = new JSeparator();
        separator2 = new JSeparator(JSeparator.VERTICAL);
        labelsFont = new Font("", 0, 22);
        
        add(setTimeButton);
        add(setDateButton);
        add(getSystemTimeButton);
        add(getSystemDateButton);
        add(timeLabel);
        add(dateJLabel);
        add(stopwatchLabel);
        add(stopStartButton);
        add(resetButton);
        add(saveResultButton);
        add(sortButton);
        add(deleteButton);
        add(resultArea);
        add(separator);
        add(separator2);
        
        getSystemTimeButton.setMargin(new Insets(0, 0, 0, 0));
        getSystemDateButton.setMargin(new Insets(0, 0, 0, 0));
        saveResultButton.setMargin(new Insets(0, 0, 0, 0));
        sortButton.setMargin(new Insets(0, 0, 0, 0));
        saveResultButton.setEnabled(false);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        dateJLabel.setHorizontalAlignment(JLabel.CENTER);
        stopwatchLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setFont(labelsFont);
        dateJLabel.setFont(labelsFont);
        stopwatchLabel.setFont(labelsFont);
        resultArea.setEditable(false);
        
        timeLabel.setBounds(0, 0, 300, 50);
        separator.setBounds(0, 50, 300, 5);
        dateJLabel.setBounds(0, 50, 300, 50);
        setTimeButton.setBounds(0, 100, 150, 50);
        setDateButton.setBounds(0, 150, 150, 50);
        getSystemTimeButton.setBounds(150, 100, 150, 50);
        getSystemDateButton.setBounds(150, 150, 150, 50);
        stopwatchLabel.setBounds(300, 0, 300, 50);
        stopStartButton.setBounds(300, 50, 100, 50);
        resetButton.setBounds(400, 50, 100, 50);
        saveResultButton.setBounds(500, 50, 100, 50);
        separator2.setBounds(300, 0, 5, 50);
        resultArea.setBounds(300, 100, 300, 80);
        sortButton.setBounds(300, 180, 150, 20);
        deleteButton.setBounds(450, 180, 150, 20);
        
        readResult = new ReadResult();
        
        readResult.read();
        resultArea.setText(readResult.getResults());
        tokensNumber = readResult.getTokensNumber();

        newWatch = new Watch();
        stopwatch = new Stopwatch(stopwatchLabel);
        stopwatch.initRead();
        watchThread = new WatchThread(newWatch, timeLabel, dateJLabel);
        watchThread.start();
        action = new Action(timeLabel, dateJLabel);
        MouseListener setTimeManuallyAction = action.setTimeManually(timeLabel, newWatch);
        setTimeButton.addMouseListener(setTimeManuallyAction);
        MouseListener setDateManaullyAction = action.setDateManually(dateJLabel, newWatch);
        setDateButton.addMouseListener(setDateManaullyAction);
        MouseListener setSystemTimeAction = action.setSystemTime(dateJLabel, newWatch);
        getSystemTimeButton.addMouseListener(setSystemTimeAction);
        MouseListener setSystemDateAction = action.setSystemDate(dateJLabel, newWatch);
        getSystemDateButton.addMouseListener(setSystemDateAction);
        MouseListener setStopwatchStartAction = action.startStopwatch(stopwatchLabel, stopwatch, stopStartButton, saveResultButton);
        stopStartButton.addMouseListener(setStopwatchStartAction);
        MouseListener setResetStopwatchAction = action.resetStopwatch(stopwatchLabel, stopwatch, stopStartButton, saveResultButton);
        resetButton.addMouseListener(setResetStopwatchAction);
        MouseListener setSaveResultAction = action.saveResult(stopwatch, resultArea, tokensNumber);
        saveResultButton.addMouseListener(setSaveResultAction);
        MouseListener setDeleteResultAction = action.deleteResult(stopwatch, resultArea, tokensNumber);
        deleteButton.addMouseListener(setDeleteResultAction);
        MouseListener setSortResultAction = action.sortResult(resultArea);
        sortButton.addMouseListener(setSortResultAction);
    }

}
