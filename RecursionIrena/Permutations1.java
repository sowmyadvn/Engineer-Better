import java.util.List;
import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    List<String> finalList = permute(3);
    for(String s: finalList) {
      System.out.println(s);
    }
  }

  public static List<String> permute(int n) {
    List<String> result, oldResult;
    String current;
    result = new ArrayList<String>();
    if(n == 0 || n == 1) {
       result.add(""+n);
       return result;
    }
    else {
      oldResult = permute(n-1);
      for(String oldCurrent: oldResult) {
        result.add(n+oldCurrent);
        for(int j = 0; j < n-1; j++) {
          current = oldCurrent.substring(0,j+1)+n+oldCurrent.substring(j+1,n-1);
          result.add(current);
        }
      }
      return result;
    }
  }
}