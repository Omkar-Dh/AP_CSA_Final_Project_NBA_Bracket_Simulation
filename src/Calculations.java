import java.util.Random;

/**
 * Responsible for doing the calculation for the NBA Finals winner
 * Represents the Finals
 */
public class Calculations {

    private String eastChamp = "";
    private String westChamp = "";
    private String winningTeam = "";
    int[] finalsRecord = new int[2];

    /**
     * Returns the Eastern Conference Champion
     * @return the Eastern Conference Champion
     */
    public String getEastChamp()
    {
        return eastChamp;
    }

    /**
     * Returns the Western Conference Champion
     * @return the Western Conference Champion
     */
    public String getWestChamp()
    {
        return westChamp;
    }

    /**
     * Sets the Eastern Conference Champion
     * @param ec takes in the Eastern Conference Champion
     */
    public void setEastChamp(String ec)
    {
        eastChamp = ec;
    }

    /**
     * Sets the Western Conference Champion
     * @param wc takes in the Western Conference Champion
     */
    public void setWestChamp(String wc)
    {
         westChamp = wc;
    }

    /**
     * Returns the Finals Record between the Two teams
     * in a best of 7 series
     * @return returns an array with the finals record
     */
    public int[] getFinalsRecord()
    {
        return finalsRecord;
    }

    /**
     * Sets the winning team of the NBA finals
     * @param input Takes in the winning team of the NBA finals
     */
    public void setWinningTeam(String input)
    {
        winningTeam = input;
    }

    /**
     * A random number is created as well as a random number for
     * each of the teams
     * If the initial random number matches the teams random number
     * it's as if they win a game, and they play in a best of 7 series
     *
     * The reason for the random generation is because both teams are equally
     * good since they have reached the finals
     * and there is no other fair way to determine who will win it all
     *
     * @param team1 The Eastern Conference Champion in the NBA finals
     * @param team2 The Western Conference Champion in the NBA finals
     */
    public String finalsWinner(String team1, String team2)
    {
        int randomNumber = new Random().nextInt(2 + 1);
        int team1Number = new Random().nextInt(2 + 1);
        int team2Number = new Random().nextInt(2 + 1);

        String[] finals = new String[]{team1,team2};

        while(true)
        {

            if(randomNumber == team1Number)
                finalsRecord[0] += 1;
            else if(randomNumber == team2Number)
                finalsRecord[1] += 1;

            if(finalsRecord[0] >= 4)
                return finals[0];
            else if(finalsRecord[1] >= 4)
                return finals[1];

            randomNumber = new Random().nextInt(2 + 1);
            team1Number = new Random().nextInt(2 + 1);
            team2Number = new Random().nextInt(2 + 1);
        }

    }
}
