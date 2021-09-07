public class Quiz1
{  

   static int[] A = {1};

   public static void main(String[] args)
   {
      System.out.print("A: ");
      for( int i = 0; i < A.length; i++ )
      {
         System.out.print(A[i] + " ");
      }
      System.out.println("");
      int[] B = (MysteryAlgorithm(A));
      System.out.print("\nB: ");
      for( int i = 0; i < B.length; i++ )
      {
         System.out.print(B[i] + " ");
      }
   }
   public static int[] MysteryAlgorithm(int[] A) 
   {
      int[] C = new int[A.length];
      int[] B = new int[A.length];
      for( int i = 0; i < A.length; i++ ) 
      { 
         C[i] = 0; 
      }
      for( int i = 0; i < A.length - 1; i++ ) 
      {
         for( int j = i + 1; j < A.length; j++ ) 
         {
            if( A[i] < A[j] ) 
            { 
               C[j] = C[j] + 1; 
            }
            else 
            { 
               C[i] = C[i] + 1; 
            }
         }
      }
      System.out.print("C: ");
      for( int i = 0; i < C.length; i++ )
      {
         System.out.print(C[i] + " ");
      }
      for( int i = 0; i < A.length; i++ ) 
      { 
         B[C[i]] = A[i]; 
      }
      return B;
   }
}

