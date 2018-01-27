
package Interface;

import Logic.Watch;
import Logic.WatchThread;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JFrame;

public class MainWindow extends JFrame{


    MainPanel mainPanel;
    public MainWindow() throws IOException{

        setTitle("");
        setSize(606, 229);
        mainPanel = new MainPanel();
        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
    }
    public static void main(String[] args) throws IOException {
        MainWindow mainWindow = new MainWindow();
        
    }
    
}
