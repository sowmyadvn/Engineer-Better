public class HanoiTowers{

     public static void main(String []args){
        hanoi(5,'a','b','c');
     }
     
     public static void hanoi(int n,char from, char aux, char dest) {
         if(n == 1) 
            System.out.println(from+"->"+dest);
         else {
             hanoi(n-1,from,dest,aux);
             System.out.println(from+"->"+aux);
             hanoi(n-1,aux,from,dest);
         } 
     }
}