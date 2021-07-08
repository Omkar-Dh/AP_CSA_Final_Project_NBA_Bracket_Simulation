/**
 * The NBA Bracket Simulation program allows the user
 * to pick a team and see if they can survive the bracket and
 * win the NBA finals
 *
 * @author  Omkar DHekne
 * @version 1.0
 * @since   2021-06-16
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The main class that represents the Home Screen
 */
public class Main extends JFrame
{
    private JLabel lblNBA, lblMessage,lblTeam;
    private ImageIcon icoNBA;
    private JTextField txtTeam;
    private JButton btnSubmit,btnTeams;
    private ButtonListener listener;
    private FirstRoundGUI bracketApp;
    private NBATeams nbaTeams;

    /**
     * The starting GUI page for the application.
     * Asks for the Team which you wish to select.
     * Offers a button which opens a window which shows all of the NBA teams
     * Showcases the NBA logo
     * Once a team selection has been made, "Start!" is pressed to begin the simulation
     */
    public Main()
    {
        super("NBA Bracket Simulation");
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        lblMessage = new JLabel("     ");
        lblMessage.setFont(new Font("Comic Sans MS",Font.BOLD, 26));
        lblNBA = new JLabel();


        lblTeam = new JLabel("Enter NBA Team Name: ");
        lblMessage = new JLabel("     ");
        lblMessage.setFont(new Font("Comic Sans MS",Font.BOLD, 26));
        txtTeam = new JTextField(10);

        btnSubmit = new JButton("Start!");
        btnTeams = new JButton("All NBA Teams");
        listener = new ButtonListener();
        icoNBA = new ImageIcon("Images/nba-logo.jpg");
        lblNBA.setIcon(icoNBA);
        //GUI Components
        cp.add(lblTeam);
        cp.add(txtTeam);
        cp.add(btnTeams);
        cp.add(lblMessage);
        cp.add(btnSubmit);
        cp.add(lblNBA);

        btnSubmit.addActionListener(listener);
        btnTeams.addActionListener(listener);

        setSize(300,700);
        setVisible(true);
    }

    /**
     * Launches the starting page of the GUI application
     */
    public static void main(String[] args)
    {
        Main myApp = new Main();
    }
    /**
     * Launches the First Round Bracket GUI
     */
    public void startBracketGUI()
    {
        bracketApp = new FirstRoundGUI(txtTeam.getText());
    }

    /**
     * Launches the GUI frame that displays all of the
     * NBA teams in a list
     */
    public void startNBATeams()
    {
        nbaTeams = new NBATeams();
    }


    /**
     * Listens so when either the "Start!" or "All NBA Teams"
     * button is pushed, the proper frame is displayed
     */
    private class ButtonListener implements ActionListener
    {
        //Start Button listener
        /**
         * Starts the proper action when a button is pushed
         */
        public void actionPerformed(ActionEvent event)
        {
            Object source = new Object();
            source = event.getSource();
            if(source == btnSubmit)
            {
                dispose();
                startBracketGUI();
            }
            else if(source == btnTeams)
            {
                startNBATeams();
            }

        }
    }
}
