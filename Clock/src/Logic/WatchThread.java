package Logic;

import Interface.Action;
import Interface.ActionBody;
import javax.swing.JLabel;

public class WatchThread implements Runnable {
    private ActionBody actionBody;
    private Watch newWatch;
    private JLabel timeLabel;
    private JLabel dateJLabel;
    private Thread newThread;
    private final int pause = 1000;
    
    public WatchThread(Watch newWatch, JLabel timeLabel, JLabel dateLabel) {
        this.timeLabel = timeLabel;
        this.dateJLabel = dateLabel;
        this.newWatch = newWatch;
        actionBody = new Action(timeLabel, dateLabel);

    }

    public void start() {
        if (this.newThread == null) {
            this.newThread = new Thread(this);
            this.newThread.start();
        }

    }

    @Override
    public void run() {
        while (this.newThread == Thread.currentThread()) {

            JLabel label = new JLabel();
            this.newWatch.addSecond();
            timeLabel.setText(this.newWatch.printTime());
            dateJLabel.setText(this.newWatch.printDate());
            actionBody.setTimeLabel(timeLabel);
            actionBody.setDateLabel(dateJLabel);
            try {
                this.newThread.sleep(pause);
            } catch (InterruptedException e) {
            }

        }
    }

    public void stop() {
        this.newThread = null;
    }

}
