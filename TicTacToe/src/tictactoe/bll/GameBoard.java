/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{
    
    int currentPlayer = 1;
    String[][] gameboard = new String[3][3];
    boolean isGameFinished = false;
    int roundCounter=0;
    
    
    /**
     * Returns 1 for player 1, 2 for player 2.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
        return currentPlayer;
    }
    

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        if(gameboard[col][row] == null && !isGameFinished)
        {
            gameboard[col][row] = currentPlayer == 1 ? "X" : "O";
            roundCounter++;
            return true;
        }
        else
            return false;
    }
    
    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will retun false.
     */

    public boolean isGameOver()
    {
        for (int i = 0; i < 3; i++) 
        {
            if(((gameboard[i][0] == gameboard[i][1] && gameboard[i][1] == gameboard[i][2]) && gameboard[i][0] != null)
                   || ((gameboard[0][i] == gameboard[1][i] && gameboard[1][i] == gameboard[2][i]) && gameboard[0][i] != null))
            {
                isGameFinished = true;
                return true; 
            }
            
        }
        if(((gameboard[0][0] == gameboard[1][1] && gameboard[1][1] == gameboard[2][2]) && gameboard[0][0] != null)
                   || ((gameboard[0][2] == gameboard[1][1] && gameboard[1][1] == gameboard[2][0]) && gameboard[0][2] != null))
        {
            isGameFinished = true;
            return true;
        }
        if(roundCounter==9)
        {
            isGameFinished = true;
            return true;
        }
        
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    
    public int getWinner()
    {
        if(currentPlayer ==1 && roundCounter!=9)
            return 1;
        if(currentPlayer == 2 && roundCounter!=9)
            return 2;
        else
            return -1;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        currentPlayer = 1;
        roundCounter=0;
        isGameFinished = false;
        for (int i = 0; i < 3; i++) 
            for(int j=0; j<3; j++)
                gameboard[i][j] = null;
                   
    }

    /**
     * Switches the next player.
     */
    
    public void switchPlayer()
    {
         if(currentPlayer == 1)
            currentPlayer=2;
        else            
            currentPlayer=1;
    }
}
    
