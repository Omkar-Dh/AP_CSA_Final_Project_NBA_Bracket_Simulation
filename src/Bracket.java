/**
 * Hold the entire Teams in the Brackets for
 * the NBA playoffs
 */
public class Bracket
{
    //First Round
    private final String[][] firstRoundEast = new String[4][2];
    private final String[][] firstRoundWest = new String[4][2];

    //Second Round
    private final String[][] secondRoundEast = new String[2][2];
    private final String[][] secondRoundWest = new String[2][2];

    //Third Round
    private final String[] thirdRoundEast = new String[2];
    private final String[] thirdRoundWest = new String[2];

    //Setters
    /**
     * Sets the variable firstRoundEast to a specific
     * value, based on an order pair
     * @param value Is set to firstRoundEast
     * @param row the row in the 2d array
     * @param col the column in the 2d array
     */
    public void setFirstRoundEast(int row, int col, String value){
        firstRoundEast[row][col] = value;
    }

    /**
     * Sets the variable setFirstRoundWest to a specific
     * value, based on an order pair
     * @param value Is set to firstRoundEast
     * @param row the row in the 2d array
     * @param col the column in the 2d array
     */
    public void setFirstRoundWest(int row, int col, String value){
        firstRoundWest[row][col] = value;
    }

    /**
     * Sets the variable setSecondRoundEast to a specific
     * value, based on an order pair
     * @param value Is set to firstRoundEast
     * @param row the row in the 2d array
     * @param col the column in the 2d array
     */
    public void setSecondRoundEast(int row, int col, String value){
        secondRoundEast[row][col] = value;
    }

    /**
     * Sets the variable setSecondRoundWest to a specific
     * value, based on an order pair
     * @param value Is set to firstRoundEast
     * @param row the row in the 2d array
     * @param col the column in the 2d array
     */
    public void setSecondRoundWest(int row, int col, String value){
        secondRoundWest[row][col] = value;
    }

    /**
     * Sets the variable setThirdRoundEast to a specific
     * value, based on a key
     * @param value Is set to firstRoundEast
     * @param key the index in the array
     */
    public void setThirdRoundEast(int key, String value){
        thirdRoundEast[key] = value;
    }

    /**
     * Sets the variable setThirdRoundWest to a specific
     * value, based on a key
     * @param value Is set to firstRoundEast
     * @param key the index in the array
     */
    public void setThirdRoundWest(int key, String value){
        thirdRoundWest[key] = value;
    }


    //Getters
    /**
     * Returns the 2d array firstRoundEast
     * @return The Eastern Conference First Round
     */
    public String[][] getFirstRoundEast(){
        return firstRoundEast;
    }

    /**
     * Returns the 2d array firstRoundWest
     * @return The Western Conference First Round
     */
    public String[][] getFirstRoundWest(){
        return firstRoundWest;
    }

    /**
     * Returns the 2d array secondRoundEast
     * @return The Eastern Conference Second Round
     */
    public String[][] getSecondRoundEast(){
        return secondRoundEast;
    }

    /**
     * Returns the 2d array secondRoundWest
     * @return The Western Conference Second Round
     */
    public String[][] getSecondRoundWest(){
        return secondRoundWest;
    }

    /**
     * Returns the array thirdRoundEast
     * @return The Eastern Conference Third Round
     */
    public String[] getThirdRoundEast(){
        return thirdRoundEast;
    }

    /**
     * Returns the array thirdRoundWest
     * @return The Western Conference Third Round
     */
    public String[] getThirdRoundWest(){
        return thirdRoundWest;
    }

}
