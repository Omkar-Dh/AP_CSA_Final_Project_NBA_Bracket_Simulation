import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Represents the Second Round of the NBA Playoffs
 * For both the Eastern and Western Conference
 */
public class SecondRoundGUI extends JFrame
{
    private JLabel lblEastTeam1, lblEastTeam2,lblEastTeam3,lblEastTeam4;
    private JLabel  lblWestTeam1, lblWestTeam2,lblWestTeam3,lblWestTeam4;
    private JLabel lblEastRecord1, lblEastRecord2;
    private JLabel lblWestRecord1, lblWestRecord2;
    private JLabel lblEastTeamImage1, lblEastTeamImage2,lblEastTeamImage3,lblEastTeamImage4;
    private ImageIcon icoEastTeamImage1, icoEastTeamImage2,icoEastTeamImage3,icoEastTeamImage4;
    private JLabel lblWestTeamImage1, lblWestTeamImage2,lblWestTeamImage3,lblWestTeamImage4;
    private ImageIcon icoWestTeamImage1, icoWestTeamImage2,icoWestTeamImage3,icoWestTeamImage4;
    private JLabel lblCol1,lblCol2, lblCol3;
    private JSeparator space,space2,space3,space4;
    private String[] eastBracket = new String[8];
    private String[] westBracket = new String[8];;

    /**
     * A visual representation of the Second Round of the NBA Finals
     * The first two rows represent the Eastern Conference
     * The bottom two rows represent the Western Conference
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
    public SecondRoundGUI(String team, EasternConference es, WesternConference ws, Calculations c, String winner)
    {
        super("NBA Second Round");
        JFrame frame = new JFrame();

        Bracket easternBracket = es.getBracket();
        Bracket westernBracket = ws.getBracket();

        lblCol1 = new JLabel("Teams");
        lblCol2 = new JLabel("Series Record");
        lblCol3 = new JLabel("Teams");

        lblCol1.setFont(new Font("Comic Sans MS",Font.BOLD, 26));
        lblCol2.setFont(new Font("Comic Sans MS",Font.BOLD, 26));
        lblCol3.setFont(new Font("Comic Sans MS",Font.BOLD, 26));

        space = new JSeparator();
        lblEastTeam1 = new JLabel(easternBracket.getSecondRoundEast()[0][0]);
        lblEastTeamImage1 = new JLabel();
        icoEastTeamImage1 = new ImageIcon("Images/EasternConference Logos/"+ easternBracket.getSecondRoundEast()[0][0] +".jpg");
        lblEastTeamImage1.setIcon(icoEastTeamImage1);
        lblEastRecord1 = new JLabel(Arrays.toString(es.getSecondRoundRecords()[0]));
        lblEastTeam2 = new JLabel(easternBracket.getSecondRoundEast()[0][1]);
        lblEastTeamImage2 = new JLabel();
        icoEastTeamImage2 = new ImageIcon("Images/EasternConference Logos/"+ easternBracket.getSecondRoundEast()[0][1] +".jpg");
        lblEastTeamImage2.setIcon(icoEastTeamImage2);

        space2 = new JSeparator();
        lblEastTeam3 = new JLabel(easternBracket.getSecondRoundEast()[1][0]);
        lblEastTeamImage3 = new JLabel();
        icoEastTeamImage3 = new ImageIcon("Images/EasternConference Logos/"+ easternBracket.getSecondRoundEast()[1][0] +".jpg");
        lblEastTeamImage3.setIcon(icoEastTeamImage3);
        lblEastRecord2 = new JLabel(Arrays.toString(es.getSecondRoundRecords()[1]));
        lblEastTeam4 = new JLabel(easternBracket.getSecondRoundEast()[1][1]);
        lblEastTeamImage4 = new JLabel();
        icoEastTeamImage4 = new ImageIcon("Images/EasternConference Logos/"+ easternBracket.getSecondRoundEast()[1][1] +".jpg");
        lblEastTeamImage4.setIcon(icoEastTeamImage4);

        space3 = new JSeparator();
        lblWestTeam1 = new JLabel(westernBracket.getSecondRoundWest()[0][0]);
        lblWestTeamImage1 = new JLabel();
        icoWestTeamImage1 = new ImageIcon("Images/WesternConference Logos/"+ westernBracket.getSecondRoundWest()[0][0] +".jpg");
        lblWestTeamImage1.setIcon(icoWestTeamImage1);
        lblWestRecord1 = new JLabel(Arrays.toString(ws.getSecondRoundRecords()[0]));
        lblWestTeam2 = new JLabel(westernBracket.getSecondRoundWest()[0][1]);
        lblWestTeamImage2 = new JLabel();
        icoWestTeamImage2 = new ImageIcon("Images/WesternConference Logos/"+ westernBracket.getSecondRoundWest()[0][1] +".jpg");
        lblWestTeamImage2.setIcon(icoWestTeamImage2);

        space4 = new JSeparator();
        lblWestTeam3 = new JLabel(westernBracket.getSecondRoundWest()[1][0]);
        lblWestTeamImage3 = new JLabel();
        icoWestTeamImage3 = new ImageIcon("Images/WesternConference Logos/"+ westernBracket.getSecondRoundWest()[1][0] +".jpg");
        lblWestTeamImage3.setIcon(icoWestTeamImage3);
        lblWestRecord2 = new JLabel(Arrays.toString(ws.getSecondRoundRecords()[1]));
        lblWestTeam4 = new JLabel(westernBracket.getSecondRoundWest()[1][1]);
        lblWestTeamImage4 = new JLabel();
        icoWestTeamImage4 = new ImageIcon("Images/WesternConference Logos/"+ westernBracket.getSecondRoundWest()[1][1] +".jpg");
        lblWestTeamImage4.setIcon(icoWestTeamImage4);

        frame.add(lblCol1);
        frame.add(lblCol2);
        frame.add(lblCol3);

        frame.add(lblEastTeam1);
        frame.add(lblEastRecord1);
        frame.add(lblEastTeam2);

        frame.add(lblEastTeamImage1);
        frame.add(space);
        frame.add(lblEastTeamImage2);

        frame.add(lblEastTeam3);
        frame.add(lblEastRecord2);
        frame.add(lblEastTeam4);

        frame.add(lblEastTeamImage3);
        frame.add(space2);
        frame.add(lblEastTeamImage4);




        frame.add(lblWestTeam1);
        frame.add(lblWestRecord1);
        frame.add(lblWestTeam2);

        frame.add(lblWestTeamImage1);
        frame.add(space3);
        frame.add(lblWestTeamImage2);

        frame.add(lblWestTeam3);
        frame.add(lblWestRecord2);
        frame.add(lblWestTeam4);

        frame.add(lblWestTeamImage3);
        frame.add(space4);
        frame.add(lblWestTeamImage4);


        frame.setLayout(new GridLayout(12,2));
        frame.getContentPane().setBackground(Color.decode("#fcfefc"));
        frame.setSize(600,800);
        frame.setVisible(true);

        int reply = 0;
        if(advancement(team,es,ws))
        {
            reply = JOptionPane.showConfirmDialog(null, "Congrats your Team has advanced to the Third round! Do you want to proceed?", "NBA Manager", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                frame.dispose();
                ThirdRoundGUI thg = new ThirdRoundGUI(team,es,ws,c, winner);
            }
            else
            {
                System.exit(0);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Sorry Your Team has been Eliminated :(");
        }

    }

    /**
     * Determines if the users team has advanced to the next round
     * @param team represents the team the user selected
     * @param es A representation of the Eastern Conference Series
     * @param ws A representation of the Western Conference Series
     * @return Returns true or false if the users team has advanced or not, respectively
     */
    public boolean advancement(String team, EasternConference es, WesternConference ws)
    {
        Bracket easternBracket = es.getBracket();
        Bracket westernBracket = ws.getBracket();

        for(String i : easternBracket.getThirdRoundEast())
        {
            if(team.equals(i))
                return true;

        }

        for(String i : westernBracket.getThirdRoundWest())
        {
            if(team.equals(i))
                return true;
        }

        return false;
    }

}
