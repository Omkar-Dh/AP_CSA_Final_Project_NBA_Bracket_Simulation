import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Represents the Third Round of the NBA Playoffs
 * For both the Eastern and Western Conference
 */
public class ThirdRoundGUI extends JFrame
{

    private JLabel lblEastTeam1, lblEastTeam2;
    private JLabel  lblWestTeam1, lblWestTeam2;
    private JLabel lblEastRecord1;
    private JLabel lblWestRecord1;
    private JLabel lblEastTeamImage1, lblEastTeamImage2;
    private ImageIcon icoEastTeamImage1, icoEastTeamImage2;
    private JLabel lblWestTeamImage1, lblWestTeamImage2;
    private ImageIcon icoWestTeamImage1, icoWestTeamImage2;
    private JLabel lblCol1,lblCol2, lblCol3;
    private JSeparator space,space2;
    private String[] eastBracket = new String[8];
    private String[] westBracket = new String[8];;

    /**
     * A visual representation of the Conference Finals / Third Round of the NBA Finals
     * The first row represent the Eastern Conference
     * The bottom row represent the Western Conference
     * The Labels between the teams represent the Record of Each Team
     * in a best of 7 series
     * Below the names of each team are the teams' logos
     * If the users team advances a JOptionPane will ask if you want to proceed or not
     * If the users team is eliminated a JOptionPane will tell them that they have been eliminated
     * @param team represents the team the user selected
     * @param es A representation of the Eastern Conference Series
     * @param ws A representation of the Western Conference Series
     * @param c  Represents the NBA Finals and the Calculations needed to determine who wins the finals
     * @param winner the winner of the NBA finals, and the champion of the league
     */
    public ThirdRoundGUI(String team, EasternConference es, WesternConference ws, Calculations c, String winner)
    {
        super("NBA Third Round");
        JFrame frame = new JFrame();

        Bracket easternBracket = es.getBracket();
        Bracket westernBracket = ws.getBracket();

        lblCol1 = new JLabel("Teams");
        lblCol2 = new JLabel("Series Record");
        lblCol3 = new JLabel("Teams");

        lblCol1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        lblCol2.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        lblCol3.setFont(new Font("Comic Sans MS", Font.BOLD, 26));

        space = new JSeparator();
        lblEastTeam1 = new JLabel(easternBracket.getThirdRoundEast()[0]);
        lblEastTeamImage1 = new JLabel();
        icoEastTeamImage1 = new ImageIcon("Images/EasternConference Logos/" + easternBracket.getThirdRoundEast()[0] + ".jpg");
        lblEastTeamImage1.setIcon(icoEastTeamImage1);
        lblEastRecord1 = new JLabel(Arrays.toString(es.getEastFinalsRecord()));
        lblEastTeam2 = new JLabel(easternBracket.getThirdRoundEast()[1]);
        lblEastTeamImage2 = new JLabel();
        icoEastTeamImage2 = new ImageIcon("Images/EasternConference Logos/" + easternBracket.getThirdRoundEast()[1] + ".jpg");
        lblEastTeamImage2.setIcon(icoEastTeamImage2);

        space2 = new JSeparator();
        lblWestTeam1 = new JLabel(westernBracket.getThirdRoundWest()[0]);
        lblWestTeamImage1 = new JLabel();
        icoWestTeamImage1 = new ImageIcon("Images/WesternConference Logos/" + westernBracket.getThirdRoundWest()[0] + ".jpg");
        lblWestTeamImage1.setIcon(icoWestTeamImage1);
        lblWestRecord1 = new JLabel(Arrays.toString(ws.getWestFinalsRecord()));
        lblWestTeam2 = new JLabel(westernBracket.getThirdRoundWest()[1]);
        lblWestTeamImage2 = new JLabel();
        icoWestTeamImage2 = new ImageIcon("Images/WesternConference Logos/" + westernBracket.getThirdRoundWest()[1] + ".jpg");
        lblWestTeamImage2.setIcon(icoWestTeamImage2);


        frame.add(lblCol1);
        frame.add(lblCol2);
        frame.add(lblCol3);

        frame.add(lblEastTeam1);
        frame.add(lblEastRecord1);
        frame.add(lblEastTeam2);

        frame.add(lblEastTeamImage1);
        frame.add(space);
        frame.add(lblEastTeamImage2);


        frame.add(lblWestTeam1);
        frame.add(lblWestRecord1);
        frame.add(lblWestTeam2);

        frame.add(lblWestTeamImage1);
        frame.add(space2);
        frame.add(lblWestTeamImage2);


        frame.setLayout(new GridLayout(6, 2));
        frame.getContentPane().setBackground(Color.decode("#fcfefc"));
        frame.setSize(600, 800);
        frame.setVisible(true);

        int reply = 0;
        if (advancement(team, c)) {
            reply = JOptionPane.showConfirmDialog(null, "Congrats your Team has advanced to the NBA Finals! Do you want to proceed?", "NBA Manager", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                frame.dispose();
                NBAFinalsGUI nbaF = new NBAFinalsGUI(team,es,ws,c, winner);
            } else {
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Sorry Your Team has been Eliminated :(");
        }

    }

    /**
     * Determines if the users team has advanced to the next round
     * @param team represents the team the user selected
     * @param c A representation NBA Finals and the Calculations needed to determine who wins the finals
     * @return Returns true or false if the users team has advanced or not, respectively
     */
    public boolean advancement(String team, Calculations c)
    {

        if(team.equals(c.getEastChamp()))
            return true;

        if(team.equals(c.getWestChamp()))
            return true;

        return false;
    }
}
