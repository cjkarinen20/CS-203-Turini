public class Quiz2 
{
   
   
   public static void main(String[] args)
   {
      int[] A = {2, 1, 4, 2};
      System.out.println(MysteryFunction(A));
   
   }
   public static int MysteryFunction(int[] A) 
   {
      if(( A == null ) || ( A.length == 0 )) //if the array is empty
      { 
         return 0; 
      }      
      
      else if( A.length == 1 )  //if the array is 1 
      { 
         return 1; 
      }
      
      else 
      {
         int tmp = A[ A.length-1 ]; //last value of the array A
         
         for( int i = 1; i < A.length-1; i++ ) // loops for A.length - 1
         {
            tmp = tmp * A[ A.length-1 ]; //multiplies temp by last value of array A
         }
         
      int[] A1 = new int[A.length-1]; //new array 1 index smaller than A
      
      for(int j = 0; j < A.length-1; j++) //loops for A.length - 1 
      {
         A1[j] = A[j]; //copying contents of A to A1
      }
      
      return tmp + MysteryFunction(A1); //return the temp + result of recursive call using A1
      
      }
   }
}