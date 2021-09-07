import java.util.*;


public class IterativeRepair
{
  
   public static void main(String[] args)
   {  
   
      int n = 4;  //the size of the board/number of queens
      int[] solution = SolveNQueens(n);   //calls the method to initialize and solve the N Queens problem
   
      if (n > 3)  //prevents from printing when null
      {
         printBoard(solution);   //print the board
      }
      
   }
   
   public static int[] SolveNQueens(int n)
   {
   
      if (n <= 3)    //if n <= 3, the problem cannot be solved 
      {
         System.out.println("Solution does not exist");  //print error message
         return null;   //empty return
      }
            
      boolean solutionFound = false;   //if the problem has been solved
      
   
      while(!solutionFound)   //while a solution has not been found
      {
         
         int board[] = new int[n];  //initializes the board based on n
         placeQueens(board);  //calls method to place queens on the board
         int numCollisions = totalCollisions(board, n); //The number of intial collisions between pieces
          
         if (numCollisions == 0)    //checks if already a solution
         {
            return board;  //returns the solution
         }
         
         boolean swapped = false;   //queens have not been swapped
         
         do {
         
            swapped = false;  //re-initialize swapped
               
            for(int qA = 0; qA < n - 1; qA++)   //iterate all queen pairs.
            {
               for(int qB = qA + 1; qB < n; qB++)
               {
                  int[] swapBrd = board.clone();   //clone the board
                  swapBrd[qA] = board[qB];   //swap the position of qA to qB
                  swapBrd[qB] = board[qA];   //swap the position of qB to qA
                  int newNumCollisions = totalCollisions(swapBrd, n);   //calculate collisions for the swapped board
                  if (newNumCollisions < numCollisions)  //if there are less collisions
                  {
                     swapped = true;   //swapped is true
                     board = swapBrd;  //board equals the swapped board
                     numCollisions = newNumCollisions;   //num collisions = collisions for swapped board
                     if (newNumCollisions == 0)    //if there are no collisions
                     {
                        solutionFound = true;   //the solution has been found 
                        return board;  //returns solution
                     }
                  }
               }
               
            }
         } while(swapped);    //while swapped is true
      }
      return null;   //default return
      
   }
   
   static int getNum(ArrayList<Integer> numList)
   {
   
      int size = numList.size();    //uses size instead of passing n
      int index = (int)(Math.random() * size);  //make sure the number is within range
     
        
      if (numList.get(index) != null)  //get random number from numList
      {
      
         int num = numList.get(index);    //retrieve the number
            
         //remove the number from numList
         numList.set(index, numList.get(size - 1));
         numList.remove(size - 1);
      
         
         return num;    //return the removed number
      } 
      
      return 0;    //default return, is never reached
      
   }
   
   public static void placeQueens(int[] board)  //places one queen in each row
   {
   
      ArrayList<Integer> numList = new ArrayList<>(board.length); //creates an arraylist of size n
     
      
      for (int i = 0; i < board.length; i++)
      {
         numList.add(i);   //fill the list with the values
      }
      
      for (int count = 0; count < board.length; count++)
      { 
         board[count] = getNum(numList);  //places row value in the board array
      }
      
      printBoard(board);   //print the initial board
   }
   
   public static void printBoard(int[] board)
   {
   
      for (int index = 0; index < board.length; index++) 
      {
         System.out.print(board[index] + " ");  //prints each index of the array
      }
      
      System.out.println(""); //creates new line in console
      
   }
   
   public static int totalCollisions(int[] board, int n)
   {
   
      int numCollisions = 0;  //intialize collisions as zero
      
      int[] D1 = new int[((2 * n) - 1)];  //positive diagonals
      int[] D2 = new int[((2 * n) - 1)];  //negative diagonals
      
      for (int index = 0; index < board.length; index++) 
      {
         int posDiagonal = QueenRowPositiveDiagonal(board[index], index, n); //translates queen position into a positive diagonal
         D1[posDiagonal]++; //marks a collision on that diagonal
         int negDiagonal = QueenRowNegativeDiagonal(board[index], index, n); //translates queen position into a negative diagonal
         D2[negDiagonal]++; //marks a collision on that diagonal
      }
      
      for (int index = 0; index < D1.length; index++)
      {
         if (D1[index] - 1 > 0)  //prevents a negative value
         {
            numCollisions += D1[index] - 1;  //adds D1[index] - 1 to sum to find number of collisions
         }
      }
      
      for (int index = 0; index < D2.length; index++) //prevents a negative value
      {
         if (D2[index] - 1 > 0)
         {
            numCollisions += D2[index] - 1;  //adds D2[index] - 1 to sum to find number of collisions
         }
      }
         
      return numCollisions;   //returns the sum of collisions in D1 and D2
      
   }
   
   private static int QueenRowPositiveDiagonal(int row, int col, int n)
   {
   
      return n - row - 1 + col;  //returns a value corresponding a positive diagonal that intersects the board
   
   }
   
   private static int QueenRowNegativeDiagonal(int row, int col, int n)
   {
   
      return ((2 * n) - 2) - row - col;   //returns a value corresponding a negative diagonal that intersects the board
      
   }
}