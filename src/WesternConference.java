import java.util.Random;

/**
 * Represents the Entire Western Conference
 * including the Pre-Season and Post-Season
 */
public class WesternConference {
    private String[][] standings = new String[][]{{"Utah Jazz","true"}, {"Phoenix Suns","true"}, {"Denver Nuggets","false"},{"Los Angeles Clippers","false"},{"Dallas Mavericks","true"},{"Portland Trailblazers","true"},{"Los Angeles Lakers","true"}, {"Memphis Grizzlies","false"},{"Golden State Warriors","false"},{"San Antonio Spurs","true"},{"New Orleans Pelicans","false"},{"Sacramento Kings","false"},{"Minnesota Timberwolves","false"},{"Oklahoma City Thunder","true"},{"Houston Rockets","true"}};

    private String[] playoffs = new String[8];

    private int [][] firstRoundRecords = new int[4][2];
    private int [][] secondRoundRecords = new int[2][2];
    private int[] westFinalsRecord = new int[2];

    private Bracket b = new Bracket();
    /**
     * A 2d array with the standings of the Teams in the Western Conference as well
     * as if the teams overall winning percentage for all
     * time is above 0.500
     *
     * @return a 2d array with standings of the teams
     */
    public String[][] getStandings()
    {
        return standings;
    }

    /**
     * The Second round Record of the Western Conference
     * in a best of 7 series between all teams
     *
     * @return a 2d array of the Second round of the Western Conference
     */
    public int[][] getSecondRoundRecords() {
        return secondRoundRecords;
    }

    /**
     * The Western Conference finals record
     * in a best of 7 series between two teams
     *
     * @return an array of the Conference finals of the Western Conference
     */
    public int[] getWestFinalsRecord() {
        return westFinalsRecord;
    }

    /**
     * Returns the entire Western Conference bracket
     *
     * @return The Western Conference bracket in the form of a class
     */
    public Bracket getBracket() {
        return b;
    }

    /**
     * Based on r, a random number between 0 and 1
     * as well as the team with the higher winning percentage
     *
     * The match up between two teams is determined based on those
     * two factors, so even if a team is better the underdog still
     * has an opportunity to win
     *
     * @param team1 The First team in the game
     * @param team2 The second team in the game
     * @return returns the team that wins the game
     */
    public String winningTeam(String team1, String team2)
    {
        int r = new Random().nextInt(3 + 1);

        int team1Standing = -10;
        int team2Standing = -10;
        for (int i = 0 ; i < playoffs.length; i++)
        {
            if (playoffs[i].equals(team1))
            {
                team1Standing = i;
                break;
            }
        }

        for (int i = 0 ; i < playoffs.length; i++)
        {
            if (playoffs[i].equals(team2))
            {
                team2Standing = i;
                break;
            }
        }

        if(team1Standing < team2Standing && r == 1)
            return team1;
        else if (team1Standing > team2Standing && r == 1)
            return team2;

        else
        {
            r = new Random().nextInt(1 + 1);
            if(r == 0)
                return team1;
            else
                return team2;
        }

    }


    /**
     * The Regular Season of the NBA is based on the standings of the 20-21 season
     * Based on a random number from 0-1 and if the team has a higher winning percentage
     * certain teams could be swapped in rankings, to add a little competitions to season
     * The first eight teams in the regular season represent those who have made the playoffs
     *
     * @return returns an array of Strings which represent which teams have made the playoffs
     */
    public String[] runRegularSeason()
    {
        int r = new Random().nextInt(1 + 1);
        String[] temp;

        int starting = new Random().nextInt(14 + 1);
        int ending = new Random().nextInt(14 + 1);

        for(int i = 0; i < standings.length; i++)
        {
            temp = standings[ending];

            if(standings[ending][1].compareTo(standings[starting][1]) > 0 && r == 1)
            {
                standings[ending] = standings[starting];
                standings[starting] = temp;
            }

            starting = new Random().nextInt(14 + 1);
            ending = new Random().nextInt(14 + 1);
            r = new Random().nextInt(1 + 1);
        }

        //Set playoff Array
        for(int i = 0; i < playoffs.length; i++)
        {
            playoffs[i] = standings[i][0];
        }

        return playoffs;
    }

    /**
     * The Post Season is based on a bracket system and each match up is a best of 7 series
     * Each round consists of half of the teams in the previous round, and this method takes
     * into account the overall winning percentages of the teams to determine who advances
     * There are a total of 4 rounds including the NBA Finals.
     *
     * @return returns an array of Strings which represent which teams have made the playoffs
     */
    public String runPostSeason()
    {
        String westernChamp = "";

        int r = new Random().nextInt(1 + 1);



        //First Round

        for(int i = 0; i < 4; i++)
        {
            b.setFirstRoundWest(i,0,playoffs[i]);
            b.setFirstRoundWest(i,1,playoffs[7 - i]);
        }


        //Second Round
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 8; j++) {
                if (winningTeam(b.getFirstRoundWest()[i][0], b.getFirstRoundWest()[i][1]).equals(b.getFirstRoundWest()[i][0]))
                {
                    firstRoundRecords[i][0] += 1;
                }
                else
                {
                    firstRoundRecords[i][1] += 1;
                }

                if (firstRoundRecords[i][0] >= 4)
                {
                    b.setSecondRoundWest(0, i, b.getFirstRoundWest()[i][0]);
                    break;
                }
                else if (firstRoundRecords[i][1] >= 4)
                {
                    b.setSecondRoundWest(0, i, b.getFirstRoundWest()[i][1]);
                    break;
                }
            }

            for(int j = 0; j < 8; j++) {
                if (winningTeam(b.getFirstRoundWest()[i+2][0], b.getFirstRoundWest()[i+2][1]).equals(b.getFirstRoundWest()[i+2][0]))
                {
                    firstRoundRecords[i+2][0] += 1;
                }
                else
                {
                    firstRoundRecords[i+2][1] += 1;
                }

                if (firstRoundRecords[i+2][0] >= 4)
                {
                    b.setSecondRoundWest(1, i, b.getFirstRoundWest()[i+2][0]);
                    break;
                }
                else if (firstRoundRecords[i+2][1] >= 4)
                {
                    b.setSecondRoundWest(1, i, b.getFirstRoundWest()[i+2][1]);
                    break;
                }
            }
        }

        //Third Round
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if (winningTeam(b.getSecondRoundWest()[i][0], b.getSecondRoundWest()[i][1]).equals(b.getSecondRoundWest()[i][0]))
                {
                    secondRoundRecords[i][0] += 1;
                }
                else
                {
                    secondRoundRecords[i][1] += 1;
                }


                if (secondRoundRecords[i][0] >= 4)
                {
                    b.setThirdRoundWest(i, b.getSecondRoundWest()[i][0]);
                    break;
                }
                else if (secondRoundRecords[i][1] >= 4)
                {
                    b.setThirdRoundWest(i, b.getSecondRoundWest()[i][1]);
                    break;
                }
            }

        }

        //Finals Western Team
        for(int i = 0; i < 8; i++)
        {
            if (winningTeam(b.getThirdRoundWest()[0],b.getThirdRoundWest()[1]).equals(b.getThirdRoundWest()[0]))
            {
                westFinalsRecord[0] += 1;
            }
            else
            {
                westFinalsRecord[1] += 1;
            }


            if (westFinalsRecord[0] >= 4)
            {
                westernChamp = b.getThirdRoundWest()[0];
                break;
            }
            else if (westFinalsRecord[1] >= 4)
            {
                westernChamp = b.getThirdRoundWest()[1];
                break;
            }

        }

        return westernChamp;
    }

}
