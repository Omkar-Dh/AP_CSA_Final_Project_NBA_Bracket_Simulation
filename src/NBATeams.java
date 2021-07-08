import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A List of all of the NBA Teams from the
 * Eastern and Western Conferences, allows
 * the user to copy and paste the name of
 * their favorite team
 */
public class NBATeams extends JFrame {

    EasternConference ec = new EasternConference();
    WesternConference wc = new WesternConference();

    String[] easternConference = new String[15];
    String[] westernConference = new String[15];

    private JLabel lblExample, lblEast, lblWest;
    private JList east;
    private JList west;
    private JButton btnClose;
    private ButtonListener listener;
    public NBATeams()
    {
        super("NBA Teams");

        for(int i = 0; i < 15; i++)
        {
            easternConference[i] = ec.getStandings()[i][0];
            westernConference[i] = wc.getStandings()[i][0];
        }

        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        lblExample = new JLabel();
        lblEast = new JLabel("Eastern Conference");
        lblWest = new JLabel("Western Conference");
        east = new JList(easternConference);
        west = new JList(westernConference);
        listener = new ButtonListener();
        btnClose = new JButton("Close");
        //TODO: Change back to normal path for REPL


        cp.add(lblEast);
        cp.add(lblWest);
        cp.add(east);
        cp.add(west);
        cp.add(btnClose);
        btnClose.addActionListener(listener);
        setSize(300,500);
        setVisible(true);
    }

    /**
     * Listener for the Close button
     */
    private class ButtonListener implements ActionListener
    {
        //Start Button listener
        public void actionPerformed(ActionEvent event)
        {
                dispose();
        }
    }

}
