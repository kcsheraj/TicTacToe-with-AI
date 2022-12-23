import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner mainScan = new Scanner(System.in);
        int chosen = 0;
        
         System.out.println("\n      WELCOME TO TicTacToe!");
         System.out.println("__________________________________");
        do{
            System.out.println("     Would you like to play:\n     Player vs Player (enter 1)\n     Player vs AI     (enter 2)");
            chosen = mainScan.nextInt();
            if(chosen!=1&&chosen!=2) System.out.println("invalid input");
         } while(chosen!=1&&chosen!=2);

        if(chosen==1){
            System.out.println("       Player vs Player!");
            System.out.println("__________________________________");
            Scanner s = new Scanner(System.in);
            Player p1 = new UserPlayer(s,"X");
            Player p2 = new UserPlayer(s,"O");
            TicTacToe board = new TicTacToe(p1,p2);
   
            while(!board.checkWin(p1) && !board.checkWin(p2) && !board.checkDraw()){
                board = p1.chooseMove(board);//current p1 goes
                Player tmp = p1;//swap who goes next
                p1 = p2;
                p2 = tmp;
            }
            if(board.checkWin(p1)){
                System.out.println("     Player ["+p1+"] wins!");
            } else if(board.checkWin(p2)){
                System.out.println("     Player ["+p2+"] wins!");
            } else if(board.checkDraw()){
                System.out.println("     Draw");
            }
                System.out.println("     Final game board:");
            System.out.println(board);	
        }
        else{
            System.out.println("         Player vs AI!");
            System.out.println("           You are X");
            System.out.println("__________________________________");
            Scanner s = new Scanner(System.in);
            Player p1 = new UserPlayer(s,"X");
            Player p2 = new AIPlayer("O",p1);
            TicTacToe board = new TicTacToe(p1,p2);
        
            while(!board.checkWin(p1) && !board.checkWin(p2) && !board.checkDraw()){
                board = p1.chooseMove(board);
                Player tmp = p1;
                p1 = p2;
                p2 = tmp;
            }
            if(board.checkWin(p1)){
                System.out.println("__________________________________");
                System.out.println("     Player ["+p1+"] wins!");
             } else if(board.checkWin(p2)){
                System.out.println("     Player ["+p2+"] wins!");
             } else if(board.checkDraw()){
                System.out.println("     Draw");
             }
                System.out.println("     Final game board:");
             System.out.println(board);			
        }
        mainScan.close();
    }
}
