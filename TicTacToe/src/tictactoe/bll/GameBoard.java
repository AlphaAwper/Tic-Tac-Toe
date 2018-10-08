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
    String[][] game = new String[3][3];
    boolean isGameFinished = false;
    int counter=0;
    
    
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
        if(game[col][row] == null && !isGameFinished)
        {
            game[col][row] = currentPlayer == 1 ? "X" : "O";
            counter++;
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
            if(((game[i][0] == game[i][1] && game[i][1] == game[i][2]) && game[i][0] != null)
                   || ((game[0][i] == game[1][i] && game[1][i] == game[2][i]) && game[0][i] != null))
            {
                isGameFinished = true;
                return true; 
            }
            
        }
        if(((game[0][0] == game[1][1] && game[1][1] == game[2][2]) && game[0][0] != null)
                   || ((game[0][2] == game[1][1] && game[1][1] == game[2][0]) && game[0][2] != null))
        {
            isGameFinished = true;
            return true;
        }
        if(counter==9)
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
        if(currentPlayer ==1 && counter!=9)
            return 1;
        if(currentPlayer == 2 && counter!=9)
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
        counter=0;
        isGameFinished = false;
        for (int i = 0; i < 3; i++) 
            for(int j=0; j<3; j++)
                game[i][j] = null;
                   
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
    
