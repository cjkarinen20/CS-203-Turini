public class Quiz3

{

   public static void main(String[] args)
   
   {
      int[] a = {9, 2, 4, 3, 1, 3, 7, 2};
      System.out.println(RiddleDivideAndConquer(a, 0, 7));
   }
   static float RiddleDivideAndConquer(int[] A, int L, int R) 
   {
      if( L > R ) 
      { 
         return 0.0F; 
      }
      else if( L == R ) 
      { 
         return A[L]; 
      }
         
      else 
      {
         int S = ( L + R ) / 2;
         System.out.println("S: " + S);
         float res1 = RiddleDivideAndConquer(A, L, S);
         System.out.println("res1: " + res1);
         float res2 = RiddleDivideAndConquer(A, S+1, R);
         System.out.println("res2: " + res2);
         float res3 = res1 * ( S - L + 1);
         System.out.println("res3: " + res3);
         float res4 = res2 * ( R - S );
         System.out.println("res4: " + res4);
         return ( res3 + res4 ) / ( R - L + 1 );
      }
   }
}