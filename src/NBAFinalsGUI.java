import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Represents the NBA Finals of the NBA Playoffs
 * One team from both the Eastern and Western Conference
 */
public class NBAFinalsGUI extends JFrame
{
    private JLabel lblEastTeam1;
    private JLabel  lblWestTeam1;
    private JLabel lblEastRecord1;
    private JLabel lblEastTeamImage1;
    private ImageIcon icoEastTeamImage1;
    private JLabel lblWestTeamImage1;
    private ImageIcon icoWestTeamImage1;
    private JLabel lblCol1,lblCol2, lblCol3;
    private JSeparator space;
    private String[] eastBracket = new String[8];
    private String[] westBracket = new String[8];;


    /**
     * A visual representation of the NBA Finals
     * The first row represent the Eastern Conference Champion Team
     * The bottom row represent the Western Conference Champion Team
     * The Labels between the teams represent the Record of Each Team
     * in a best of 7 series
     * Below the names of each team are the teams' logos
     * If the users team wins the finals a JOptionPane will congratulate you on picking the team that won the finals
     * If the users team is eliminated a JOptionPane will tell them that they have been eliminated
     * @param team represents the team the user selected
     * @param es A representation of the Eastern Conference Series
     * @param ws A representation of the Western Conference Series
     * @param c  Represents the NBA Finals and the Calculations needed to determine who wins the finals
     * @param winner the winner of the NBA finals, and the champion of the league
     */
    public NBAFinalsGUI(String team, EasternConference es, WesternConference ws, Calculations c, String winner)
    {
        super("NBA Finals");
        JFrame frame = new JFrame();

        lblCol1 = new JLabel("Teams");
        lblCol2 = new JLabel("Series Record");
        lblCol3 = new JLabel("Teams");

        lblCol1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        lblCol2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        lblCol3.setFont(new Font("Comic Sans MS", Font.BOLD, 26));

        space = new JSeparator();
        lblEastTeam1 = new JLabel(c.getEastChamp());
        lblEastTeamImage1 = new JLabel();
        icoEastTeamImage1 = new ImageIcon("Images/EasternConference Logos/" + c.getEastChamp() + ".jpg");
        lblEastTeamImage1.setIcon(icoEastTeamImage1);
        lblEastRecord1 = new JLabel(Arrays.toString(c.getFinalsRecord()));


        lblWestTeam1 = new JLabel(c.getWestChamp());
        lblWestTeamImage1 = new JLabel();
        icoWestTeamImage1 = new ImageIcon("Images/WesternConference Logos/" + c.getWestChamp() + ".jpg");
        lblWestTeamImage1.setIcon(icoWestTeamImage1);

        frame.add(lblCol1);
        frame.add(lblCol2);
        frame.add(lblCol3);

        frame.add(lblEastTeam1);
        frame.add(lblEastRecord1);
        frame.add(lblWestTeam1);
        frame.add(lblEastTeamImage1);
        frame.add(space);
        frame.add(lblWestTeamImage1);


        frame.setLayout(new GridLayout(3, 3));
        frame.getContentPane().setBackground(Color.decode("#fcfefc"));
        frame.setSize(600, 800);
        frame.setVisible(true);

        if (advancement(team, winner)) {
            JOptionPane.showMessageDialog(frame, "Congratulations! You won the NBA Finals!");
        } else {
            JOptionPane.showMessageDialog(frame, "Sorry Your Team has been Eliminated :(");
        }
    }

    /**
     * Determines if the users team wins the NBA Finals
     * @param team represents the team the user selected
     * @param winner A representation of the winner of the NBA Finals
     * @return Returns true or false if the users team won or lost the NBA Finals, respectively
     */
    public boolean advancement(String team, String winner)
    {
        return team.equals(winner);
    }
}
