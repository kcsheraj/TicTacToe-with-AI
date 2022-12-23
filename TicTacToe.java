 /** 
 * @author Sheraj KC
 * Represents a TicTacToe board game
 */
public class TicTacToe{

   private char[][] board;
   private Player x;
   private Player o;
 /**
 * Constructor
 * @param x player which has x as token
 * @param o player which has o as token
 */
   public TicTacToe(Player x, Player o){
      this.x = x;
      this.o = o;
      board = new char[3][3];
      //initalize board to _
      for(int r=0; r<board.length; r++){
         for(int c=0; c<board[0].length; c++){
            board[r][c] = '_';
         }
      }
   }
  /**
  * @return returns the num '_' on board
  */
   public int countBlanks(){
      int numBlanks = 0;
      for(int r=0; r<board.length; r++){
         for(int c=0; c<board[0].length; c++){
            if(board[r][c] == '_') numBlanks++;
         }
      }
      return numBlanks;
   }

  /**
  * @return returns the marker the player uses
  * @param thePlayer Player which has o as token
  */
   public char markerForPlayer(Player thePlayer){//FINISH ME
      if(thePlayer.equals(x))
         return 'X';
      else
         return 'O';
   }
 
  /**
  * @return returns true if the given player is the winner of this board
  * (has three of their marks in a row horizontally, vertically, or diagonally)
  * @param thePlayer Player which has o as token
  */
   public boolean checkWin(Player thePlayer){
      char marker = this.markerForPlayer(thePlayer);
   //horizontally
      for(int c=0; c<board[0].length; c++){
         int sum = 0;
         for(int r=0; r<board.length; r++){
            if(board[r][c] == marker)
               sum++;
            if(sum==3) 
               return true; 
         }
      }
   //vertically
      for(int r=0; r<board.length; r++){
         int sum = 0;
         for(int c=0; c<board[0].length; c++){
            if(board[r][c] == marker)
               sum++;
            if(sum==3) 
               return true; 
         }
      }
   //diagonally topLeft to bottom right
      int sum = 0;
      if(board[0][0]==marker) sum++;
      if(board[1][1]==marker) sum++;
      if(board[2][2]==marker) sum++;
      if(sum==3) 
         return true;
   //diagonally topRight to bottom left
      sum = 0;
      if(board[0][2]==marker) sum++;
      if(board[1][1]==marker) sum++;
      if(board[2][0]==marker) sum++;
      if(sum==3) 
         return true;
      
      return false;
   }
   
  /**
  * @return return true if the other player is the winner of this board and false otherwise. 
  * @param thePlayer the player you want to check
  */
   public boolean checkLose(Player thePlayer){
      Player otherPlayer;
      if(this.markerForPlayer(thePlayer)=='X'){
         otherPlayer = this.getO();
      }
      else{
         otherPlayer = this.getX();
      }
      if(checkWin(otherPlayer)) //if this player won
         return true;
         
      else if(checkDraw())// and if not draw
         return false;
      else if(countBlanks() != 0) 
         return false;
         
      return true;//other player won
   }
 
  /**
  * @return true if the current board is a draw (no blank spaces and no winner), and false otherwise
  */
   public boolean checkDraw(){
      if(checkWin(this.getX())) 
         return false;
      if(checkWin(this.getO())) 
         return false;
      if(countBlanks()!=0) 
         return false;
         
      return true;
   }
 
  
  /**
  * @return represents the current board as a single String suitable for printing.
  */
   public String toString(){
      String ans = "        ";
      for(int r=0; r<board.length; r++){
         for(int c=0; c<board[0].length; c++){
            ans+= board[r][c];
         }
         ans+="\n        ";
      }
      
      return ans;
   }
  
  /**
  * @return returns a new array of TicTacToe boards representing the possible next moves for the given player.May mark where blank 
  * @param thePlayer you want to find the possible moves for
  */
   public TicTacToe[] possibleMoves(Player thePlayer){
      TicTacToe[] boards = new TicTacToe[countBlanks()];
      int boardsIndex = 0;
   
      for(int r=0; r<board.length; r++){
         for(int c=0; c<board[0].length; c++){//traverse board
            if(board[r][c] == '_'){//add new board if blank found
               TicTacToe aPossibleMove = new TicTacToe(x,o);
               //deep copy board
               for(int k=0; k<board.length; k++){
                  for(int j=0; j<board[0].length; j++){
                     aPossibleMove.getBoard()[k][j] = board[k][j];
                  }
               }
               
               aPossibleMove.getBoard()[r][c] = markerForPlayer(thePlayer);
               
               boards[boardsIndex] = aPossibleMove;
               boardsIndex++;
               
            }
            
         }
      }
   
      return boards;
   }  
   
  /**
  * @return the TicTacToe board of chars
  */
   public char[][] getBoard(){
      return this.board;
   }
  /**
  * @return the Player assinged to 'x' char
  */
   public Player getX(){
      return this.x;
   }
  /**
  * @return the Player assinged to 'x' char
  */
   public Player getO(){
      return this.o;
   }
   

}