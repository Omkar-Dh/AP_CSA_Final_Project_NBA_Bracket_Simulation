import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;

/**
 * Represents the First Round of the NBA Playoffs
 * For both the Eastern and Western Conference
 */
public class FirstRoundGUI extends JFrame
{
    private JLabel lblEastTeam1, lblEastTeam2,lblEastTeam3,lblEastTeam4,lblEastTeam5,lblEastTeam6,lblEastTeam7,lblEastTeam8;
    private JLabel  lblWestTeam1, lblWestTeam2,lblWestTeam3,lblWestTeam4,lblWestTeam5,lblWestTeam6,lblWestTeam7,lblWestTeam8;
    private JLabel lblEastRecord1, lblEastRecord2,lblEastRecord3,lblEastRecord4;
    private JLabel lblWestRecord1, lblWestRecord2,lblWestRecord3,lblWestRecord4;
    private JLabel lblEastTeamImage1, lblEastTeamImage2,lblEastTeamImage3,lblEastTeamImage4,lblEastTeamImage5,lblEastTeamImage6,lblEastTeamImage7,lblEastTeamImage8;
    private ImageIcon icoEastTeamImage1, icoEastTeamImage2,icoEastTeamImage3,icoEastTeamImage4,icoEastTeamImage5,icoEastTeamImage6,icoEastTeamImage7,icoEastTeamImage8;
    private JLabel lblWestTeamImage1, lblWestTeamImage2,lblWestTeamImage3,lblWestTeamImage4,lblWestTeamImage5,lblWestTeamImage6,lblWestTeamImage7,lblWestTeamImage8;
    private ImageIcon icoWestTeamImage1, icoWestTeamImage2,icoWestTeamImage3,icoWestTeamImage4,icoWestTeamImage5,icoWestTeamImage6;
    private JLabel lblCol1,lblCol2, lblCol3;
    private JSeparator space,space2,space3,space4,space5,space6,space7,space8;
    private String winner;
    private String[] eastBracket = new String[8];
    private String[] westBracket = new String[8];;

    /**
     * A visual representation of the First Round of the NBA Finals
     * The first four rows represent the Eastern Conference
     * The bottom four rows represent the Western Conference
     * The Labels between the teams represent the Record of Each Team
     * in a best of 7 series
     * Below the names of each team are the teams' logos
     * If the users team advances a JOptionPane will ask if you want to proceed or not
     * If the users team is eliminated a JOptionPane will tell them that they have been eliminated
     * @param team represents the team the user selected
     */
    public FirstRoundGUI(String team)
    {
        super("NBA First Round");
        JFrame frame = new JFrame();

        //Eastern Conference
        EasternConference es = new EasternConference();

        eastBracket = es.runRegularSeason();

        String t1 = (es.runPostSeason());


        //Western Conference
        WesternConference ws = new WesternConference();

        westBracket = ws.runRegularSeason();

        String t2 = ws.runPostSeason();


        Calculations c = new Calculations();

        c.setEastChamp(t1);
        c.setWestChamp(t2);

        winner = c.finalsWinner(t1,t2);
        c.setWinningTeam(winner);

        lblCol1 = new JLabel("Teams");
        lblCol2 = new JLabel("Series Record");
        lblCol3 = new JLabel("Teams");

        lblCol1.setFont(new Font("Comic Sans MS",Font.BOLD, 26));
        lblCol2.setFont(new Font("Comic Sans MS",Font.BOLD, 26));
        lblCol3.setFont(new Font("Comic Sans MS",Font.BOLD, 26));

        space = new JSeparator();
        lblEastTeam1 = new JLabel(eastBracket[0]);
        lblEastTeamImage1 = new JLabel();
        icoEastTeamImage1 = new ImageIcon("Images/EasternConference Logos/"+ eastBracket[0] +".jpg");
        lblEastTeamImage1.setIcon(icoEastTeamImage1);
        lblEastRecord1 = new JLabel(Arrays.toString(es.getFirstRoundRecords()[0]));
        lblEastTeam2 = new JLabel(eastBracket[7]);
        lblEastTeamImage2 = new JLabel();
        icoEastTeamImage2 = new ImageIcon("Images/EasternConference Logos/"+ eastBracket[7] +".jpg");
        lblEastTeamImage2.setIcon(icoEastTeamImage2);

        space2 = new JSeparator();
        lblEastTeam3 = new JLabel(eastBracket[1]);
        lblEastTeamImage3 = new JLabel();
        icoEastTeamImage3 = new ImageIcon("Images/EasternConference Logos/"+ eastBracket[1] +".jpg");
        lblEastTeamImage3.setIcon(icoEastTeamImage3);
        lblEastRecord2 = new JLabel(Arrays.toString(es.getFirstRoundRecords()[1]));
        lblEastTeam4 = new JLabel(eastBracket[6]);
        lblEastTeamImage4 = new JLabel();
        icoEastTeamImage4 = new ImageIcon("Images/EasternConference Logos/"+ eastBracket[6] +".jpg");
        lblEastTeamImage4.setIcon(icoEastTeamImage4);

        space3 = new JSeparator();
        lblEastTeam5 = new JLabel(eastBracket[2]);
        lblEastTeamImage5 = new JLabel();
        icoEastTeamImage5 = new ImageIcon("Images/EasternConference Logos/"+ eastBracket[2] +".jpg");
        lblEastTeamImage5.setIcon(icoEastTeamImage5);
        lblEastRecord3 = new JLabel(Arrays.toString(es.getFirstRoundRecords()[2]));
        lblEastTeam6 = new JLabel(eastBracket[5]);
        lblEastTeamImage6 = new JLabel();
        icoEastTeamImage6 = new ImageIcon("Images/EasternConference Logos/"+ eastBracket[5] +".jpg");
        lblEastTeamImage6.setIcon(icoEastTeamImage6);

        space4 = new JSeparator();
        lblEastTeam7 = new JLabel(eastBracket[3]);
        lblEastTeamImage7 = new JLabel();
        icoEastTeamImage7 = new ImageIcon("Images/EasternConference Logos/"+ eastBracket[3] +".jpg");
        lblEastTeamImage7.setIcon(icoEastTeamImage7);
        lblEastRecord4 = new JLabel(Arrays.toString(es.getFirstRoundRecords()[3]));
        lblEastTeam8 = new JLabel(eastBracket[4]);
        lblEastTeamImage8 = new JLabel();
        icoEastTeamImage8 = new ImageIcon("Images/EasternConference Logos/"+ eastBracket[4] +".jpg");
        lblEastTeamImage8.setIcon(icoEastTeamImage8);

        space5 = new JSeparator();
        lblWestTeam1 = new JLabel(westBracket[0]);
        lblWestTeamImage1 = new JLabel();
        icoWestTeamImage1 = new ImageIcon("Images/WesternConference Logos/"+ westBracket[0] +".jpg");
        lblWestTeamImage1.setIcon(icoWestTeamImage1);
        lblWestRecord1 = new JLabel(Arrays.toString(es.getFirstRoundRecords()[0]));
        lblWestTeam2 = new JLabel(westBracket[7]);
        lblWestTeamImage2 = new JLabel();
        icoWestTeamImage2 = new ImageIcon("Images/WesternConference Logos/"+ westBracket[7] +".jpg");
        lblWestTeamImage2.setIcon(icoWestTeamImage2);

        space6 = new JSeparator();
        lblWestTeam3 = new JLabel(westBracket[1]);
        lblWestTeamImage3 = new JLabel();
        icoWestTeamImage3 = new ImageIcon("Images/WesternConference Logos/"+ westBracket[1] +".jpg");
        lblWestTeamImage3.setIcon(icoWestTeamImage3);
        lblWestRecord2 = new JLabel(Arrays.toString(es.getFirstRoundRecords()[1]));
        lblWestTeam4 = new JLabel(westBracket[6]);
        lblWestTeamImage4 = new JLabel();
        icoWestTeamImage4 = new ImageIcon("Images/WesternConference Logos/"+ westBracket[6] +".jpg");
        lblWestTeamImage4.setIcon(icoWestTeamImage4);

        space7 = new JSeparator();
        lblWestTeam5 = new JLabel(westBracket[2]);
        lblWestTeamImage5 = new JLabel();
        icoWestTeamImage5 = new ImageIcon("Images/WesternConference Logos/"+ westBracket[2] +".jpg");
        lblWestTeamImage5.setIcon(icoWestTeamImage5);
        lblWestRecord3 = new JLabel(Arrays.toString(es.getFirstRoundRecords()[2]));
        lblWestTeam6 = new JLabel(westBracket[5]);
        lblWestTeamImage6 = new JLabel();
        icoWestTeamImage6 = new ImageIcon("Images/WesternConference Logos/"+ westBracket[5] +".jpg");
        lblWestTeamImage6.setIcon(icoWestTeamImage6);

        space8 = new JSeparator();
        lblWestTeam7 = new JLabel(westBracket[3]);
        lblWestTeamImage7 = new JLabel();
        icoEastTeamImage7 = new ImageIcon("Images/WesternConference Logos/"+ westBracket[3] +".jpg");
        lblWestTeamImage7.setIcon(icoEastTeamImage7);
        lblWestRecord4 = new JLabel(Arrays.toString(es.getFirstRoundRecords()[3]));
        lblWestTeam8 = new JLabel(westBracket[4]);
        lblWestTeamImage8 = new JLabel();
        icoEastTeamImage8 = new ImageIcon("Images/WesternConference Logos/"+ westBracket[4] +".jpg");
        lblWestTeamImage8.setIcon(icoEastTeamImage8);


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


        frame.add(lblEastTeam5);
        frame.add(lblEastRecord3);
        frame.add(lblEastTeam6);

        frame.add(lblEastTeamImage5);
        frame.add(space3);
        frame.add(lblEastTeamImage6);


        frame.add(lblEastTeam7);
        frame.add(lblEastRecord4);
        frame.add(lblEastTeam8);

        frame.add(lblEastTeamImage7);
        frame.add(space4);
        frame.add(lblEastTeamImage8);


        frame.add(lblWestTeam1);
        frame.add(lblWestRecord1);
        frame.add(lblWestTeam2);

        frame.add(lblWestTeamImage1);
        frame.add(space5);
        frame.add(lblWestTeamImage2);

        frame.add(lblWestTeam3);
        frame.add(lblWestRecord2);
        frame.add(lblWestTeam4);

        frame.add(lblWestTeamImage3);
        frame.add(space6);
        frame.add(lblWestTeamImage4);

        frame.add(lblWestTeam5);
        frame.add(lblWestRecord3);
        frame.add(lblWestTeam6);

        frame.add(lblWestTeamImage5);
        frame.add(space7);
        frame.add(lblWestTeamImage6);

        frame.add(lblWestTeam7);
        frame.add(lblWestRecord4);
        frame.add(lblWestTeam8);

        frame.add(lblWestTeamImage7);
        frame.add(space8);
        frame.add(lblWestTeamImage8);

        frame.setLayout(new GridLayout(24,3));
        frame.getContentPane().setBackground(Color.decode("#fcfefc"));
        frame.setSize(600,800);
        frame.setVisible(true);

        int reply = 0;
        if(advancement(team,es,ws))
        {
            reply = JOptionPane.showConfirmDialog(null, "Congrats your Team has advanced to the Second round! Do you want to proceed?", "NBA Manager", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                frame.dispose();
                SecondRoundGUI srg = new SecondRoundGUI(team, es, ws,c, winner);
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

        for(String[] i : easternBracket.getSecondRoundEast())
        {
            for(String j : i)
            {
                if(team.equals(j))
                    return true;
            }
        }

        for(String[] i : westernBracket.getSecondRoundEast())
        {
            for(String j : i)
            {
                if(team.equals(j))
                    return true;
            }
        }
        return false;
    }

}