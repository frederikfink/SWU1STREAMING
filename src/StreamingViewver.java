import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class StreamingViewver {

    public StreamingViewver() {
        makeFrame();
    }

    public void makeFrame() {
        //Initialize frame
        JFrame frame = new JFrame("StreamingTjeneste");
        frame.setPreferredSize(new Dimension(800, 600));
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        //adds topmenubar
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        //adds "File" topmenubar item
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);

        //adds actionlistener to quit
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener((ActionEvent e) ->
                {
                    System.exit(1);
                }
        );
        fileMenu.add(quitItem);
        contentPane.add(new JLabel("hej"));

        //packs and shows frame
        frame.pack();
        frame.setVisible(true);
    }

    public void addMovieDisplay(JLabel title) {
    }
}

