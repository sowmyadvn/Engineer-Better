import java.io.*;
import java.util.*;

class Solution {

  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    // your code goes here
    int i = 0, j = 0;
    while(i < slotsA.length && j < slotsB.length) {
      int a1 = slotsA[i][0], a2 = slotsA[i][1];
      int b1 = slotsB[j][0], b2 = slotsB[j][1];
      int min = a1>b1?a1:b1; 
      int max = a2<b2?a2:b2;
      System.out.println(min+" before "+max);
      if( max > min && max-min >= dur) {
        
        System.out.println(min+" in "+max);
        return new int[]{min,min+dur};
      }
      else if(b2 > a2) {
        i++;
      }
      else 
        j++;
      
    }
    return new int[]{};
 }

  public static void main(String[] args) {
    int[][] a = new int[][]{{6,12}};//{{6,12}}
    int[][] b = new int[][]{{2,11}};
    int[] dur = meetingPlanner(a,b,5);
    assert dur[0] == 6 && dur[1] == 11 : "Failed"; 
  }

}
/*
[[10, 50], [60, 120], [140, 210]]
[[50,60],[60,70]]


[[0, 70], [70, 80]]
     j
O(m + n)
//[10, 50] [0, 70]
//[10, 20] [15, 40]

/*
6,12 
2,11

min = 6 max = 11
*/
