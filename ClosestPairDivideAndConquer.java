/* CJ Karinen          */
/* CS-203 Assignment 2 */
/* Turini              */



import java.util.*;
import java.awt.Point;

public class ClosestPairDivideAndConquer
{
   
   Point[] P; //x coordinate points sorted in non-decreasing order
   Point[] Q; //y coordinate points sorted in non-decreasing order
   
   
   public static void main(String[] args)
   {
   
   
   }
   
   public static int EfficientClosestPair(Point[] P, Point[] Q)
   {
      if (P.length <= 3)
      {
        // return minimal distance found by the brute-force algorithm  
         if (P.length <= 2)
         {
            double dist = Math.hypot(P[0].getX() - Q[0].getX(), P[0].getY() - Q[0].getY());
            return (int)dist;
         }
         else
         {
            double d1 = Math.hypot(P[0].getX() - Q[0].getX(), P[0].getY() - Q[0].getY());
            double d2 = Math.hypot(P[1].getX() - Q[1].getX(), P[1].getY() - Q[1].getY());
            double d3 = Math.hypot(P[2].getX() - Q[2].getX(), P[2].getY() - Q[2].getY());
            
            int min1 = (int)Math.min(d1, d2);
            int min2 = (int)Math.min(d2, d3);
            
            return Math.min(min1, min2);
         }
        
      }
      else 
      {
      
         int min;
         Point temp;
         
         int lMost = 0;
         int rMost = P.length - 1;
         int splitSize = ((lMost + rMost)/2) + 1;
      
      
         Point[] Pl = new Point[splitSize];
      
         for (int i = 0; i < Pl.length; i++)
         {
            Pl[i] = P[i];
         }
         
         Point[] Ql = new Point[Pl.length];
         
         for (int i = 0; i < Pl.length; i++)
         {
            Ql[i] = Pl[i];
         }
         
         for(int i = 0; i < Ql.length; i++)
         {
            min = i;
            for(int j = i + 1; j < Ql.length; j++)
            {
               int y1 = (int)Ql[j].getY();
               int y2 = (int)Ql[min].getY();
               
               if (y1 < y2)
               {
                  min = j;
               }
            }
            temp = Ql[i];
            Ql[i] = Ql[min];
            Ql[min] = temp;
         }
         
         Point[] Pr = new Point[splitSize];
         
         for (int i = 0, j = splitSize; i < Pr.length; i++, j++)
         {
            Pr[i] = P[j];
         }
         
         Point[] Qr = new Point[Pr.length];
         
         for (int i = 0; i < Pr.length; i++)
         {
            Qr[i] = Pl[i];
         }
         
         for(int i = 0; i < Qr.length; i++)
         {
            min = i;
            for(int j = i + 1; j < Qr.length; j++)
            {
               int y1 = (int)Qr[j].getY();
               int y2 = (int)Qr[min].getY();
               
               if (y1 < y2)
               {
                  min = j;
               }
            }
            temp = Qr[i];
            Qr[i] = Qr[min];
            Qr[min] = temp;
         }
         
         
         
         int dl = EfficientClosestPair(Pl, Ql);
         int dr = EfficientClosestPair(Pr, Qr);
         
         int d = Math.min(dl, dr);
         int m = (int)P[Pl.length - 1].x;
         
         
        /*
         copy first [n/2] points of P to Pl
         copy same [n/2] points from Q to array Ql
         copy remaining [n/2] points of P to array Pr
         copy same [n/2] points from Q to array Qr
      
         d = min[d1, dr]
         m = P[[n/2] - 1].x
         copy all points of Q for which [x-m] < d into array 
         S[0..num - 1]
         dminsq = d^2
         
         for (int i = 0; i < n - 2; i++)
         {
            k = i + 1
            while k < num - 1 and (S[k].y - S[i].y)^2 < dminsq
               dminsq = min((S[k].x - S[i].x)^2 + (S[k].y - S[i].y)^2, dminsq)
               k = k + 1
      }
      return sqrt(dminsq)
      */
      }
   }
}