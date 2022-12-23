 /** 
 * @author Sheraj KC
 * Represents a AI player
 */
public class AIPlayer extends Player{

   private String name;
   private Player opponent;
   
   /**
   * @param name either 'X' or 'O'
   * @param opponent the other opponent
   */
   public AIPlayer(String name, Player opponent){
      this.name = name;
      this.opponent = opponent;
   }
   
   /*
   * @param game the current TicTacToe game
   * @return return the chosen optimal move(TicTacToe)
   */
   public TicTacToe chooseMove(TicTacToe game){
      TicTacToe[] possibleMovesAI = game.possibleMoves(this);//get all possible moves for AI
      double max = this.minValue(possibleMovesAI[0]);
      int indexYouWant = 0;
      for(int i=0; i<possibleMovesAI.length; i++){//return the max of calls to minValue
         double possBetter = this.minValue(possibleMovesAI[i]);
         if(possBetter > max){
            indexYouWant = i;
            max = possBetter;
         }
      }
    
      return possibleMovesAI[indexYouWant];
   }
  
  //Recursive methods
  /**
  * @param game the current TicTacToe game
  * @return returns the lowest option of the opponents maxValue
  */
   public double minValue(TicTacToe game){//Return move//AIplayer turn
   //BASE CASE
      if(game.checkWin(this)) 
         return 1.0;
      else if(game.checkDraw()) 
         return 0.0;
      else  if(game.checkLose(this)) 
         return -1.0;
   
    
    
    //If no one has won and the game is not a draw,
    //the return value of the board must be computed recursively.
   
      TicTacToe[] thePossibleMoves = game.possibleMoves(this.getOpponent());//get all possible moves for opponet
      double min = this.maxValue(thePossibleMoves[0]);
      
      
      for(int i=0; i<thePossibleMoves.length; i++){//find max value of all options called on minValue
         double possSmaller = this.maxValue(thePossibleMoves[i]);
         if(possSmaller < min){
            min = possSmaller;
         }
      } 
      
      return min;
      
   } 
   
   //used to determine what value THIS AI could get by choosing optimally
   //among the options provided by possibleMoves for the current game board. 
  /**
  * @param game the current TicTacToe game
  * @return returns the higest value of the minValue of this player
  */
   public double maxValue(TicTacToe game){//CHOSE move that will help AI win(maximaxse)//OPPONENT turn
   //BASE CASE
      if(game.checkWin(this)) 
         return 1.0;
      else if(game.checkDraw()) 
         return 0.0;
      else if(game.checkLose(this)) 
         return -1.0;
   
         
    //If no one has won and the game is not a draw,
    //the return value of the board must be computed recursively. 
      TicTacToe[] thePossibleMoves = game.possibleMoves(this);//get all possible moves for AI
      double max = this.minValue(thePossibleMoves[0]);
      
      
      for(int i=0; i<thePossibleMoves.length; i++){//find max value of all options called on minValue
         double possLarger = this.minValue(thePossibleMoves[i]);
         if(possLarger > max){
            max = possLarger;
         }
      } 
      
      
      return max;
   } 
   
 
  /**
  * @param game the current TicTacToe game
  * @return return maxValue of given board
  */
   public double boardValue(TicTacToe game){
   
      return maxValue(game);
   }

   /**
   * @return the name of the AI
   */
   public String toString(){
      return name+" (AI)";
   }
   
   /**
   * @return the the opponent
   */
   public Player getOpponent(){
      return this.opponent;
   }
   
   /**
   * @param opponent the opponent
   */
   public void setOpponent(Player opponent){
      this.opponent = opponent;
   }
   
}