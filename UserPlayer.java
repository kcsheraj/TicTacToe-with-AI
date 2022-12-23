import java.util.Scanner;
import java.util.concurrent.TimeUnit;
 /** 
 * @author Sheraj KC
 * Represents a human player
 */
public class UserPlayer extends Player{

   private String name;
   private Scanner input;
   
   /** Constructor
   * @param input a scannner object
   * @param name either "X" or "O"
   */
   public UserPlayer(Scanner input, String name){
      this.input = input;
      this.name = name;
   }
   
   /**
   * @param game the current TicTacToe game
   * @return returns the TicTacToe board chosen
   */
   public TicTacToe chooseMove(TicTacToe game){
      System.out.println("CURRENT BOARD:");
      System.out.println(game.toString());//print out current board
      
      TicTacToe[] thePossibleMoves = game.possibleMoves(this);
     // print out all possible moves for the player
      System.out.println("__________________________________");
      System.out.println("POSSIBLE MOVES:");
      for(int i=0; i<5; i++){
         try {
            TimeUnit.MILLISECONDS.sleep(100);
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         System.out.print(".");
      }
      System.out.println("");
      for(int i=0; i<thePossibleMoves.length; i++){
         System.out.println(i+".)\n"+thePossibleMoves[i].toString());
      }
      System.out.println("__________________________________");
      System.out.println("Enter number to pick a move:");
      int userResponse = -1;
      do{
         userResponse = input.nextInt();//ask user to pic board
         if(userResponse>=thePossibleMoves.length||userResponse<0){
            
            System.out.println("invalid move");
            System.out.println("Enter number listed to pick a move:");
         }
      } while(userResponse>=thePossibleMoves.length||userResponse<0);
      return thePossibleMoves[userResponse];//return board chosen2
   }
   /* 
   * @returns the name of the userPlayer
   */
   public String toString(){
      return name;
   }

}