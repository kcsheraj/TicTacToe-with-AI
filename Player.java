 /** 
 * @author Sheraj KC
 * Represents a TicTacToe board game
 */
public abstract class Player{

   
   /**
   * @return takes a single TicTacToe argument and returns one of the possibleMoves. 
   * How this move is chosen will depend on the kind of player, so this must be an abstract method which subclasses must override.
   * @param game takes a TicTacToe current game
   */
   public abstract TicTacToe chooseMove(TicTacToe game);
 
   /**
   * @return returns a double value representing how good the given board is for this player.
   * The default implementation for this method should be to return 1.0 if this player has won this board,
   * -1.0 if this player has lost this board, and 0.0 otherwise
   * @param game takes a TicTacToe current game
   */
   public double boardValue(TicTacToe game){
      if(game.checkWin(this)) 
         return 1.0;
      if(game.checkLose(this)) 
         return -1.0;
   
      return 0.0;
   }


}