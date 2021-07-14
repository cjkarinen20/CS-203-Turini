import java.util.*;


public class IterativeRepair
{
   final int N = 4;
   
   static int board[][] = {{0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0}};
                    
                    
                    
                    
   public static void main(String[] args)
   {  
      Random randomNum = new Random();
      
      printBoard();
      System.out.println("");
      
      PlaceQueen(board, randomNum);
   }
   
   public int RandomIndex(Random random)
   {
      int limit = 7;
      int randIndex = random.nextInt(limit);
      return randIndex;
   }
   public static void PlaceQueen(int[][] board, Random random)
   {
      int queen = 1;
      
      for (int col = 0; col < board.length; col++)
      {  
         int limit = 7;
         int randRow = random.nextInt(limit);
         board[randRow][col] = queen;  
      }
      
      printBoard();
   }
   public static void printBoard()
   {
      for (int row = 0; row < board[0].length; row++)
      {
         for (int col = 0; col < board.length; col++)
         {  
            System.out.print(board[row][col]);
            System.out.print(" ");
         }
         System.out.println("");
      }
   }
}