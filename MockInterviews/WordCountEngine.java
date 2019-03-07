import java.io.*;
import java.util.*;

class Solution {

  static String[][] wordCountEngine(String document) {
    int lastSpaceAt = -1;
    Map<String,Integer> docuMap = new LinkedHashMap<String,Integer>();
    document = document.trim().replaceAll("\\s{2,}","");
    document = document.toLowerCase();
    document = document.replaceAll("[^a-z0-9 ]","");
    
    //Now, string to lower case
    
    System.out.println(document);
    for(int i=0; i < document.length();i++) {
      if(document.charAt(i) == ' ') {
          insertIntoMap(document.substring(lastSpaceAt+1,i),docuMap);
          lastSpaceAt = i;
       }
      else if(i == document.length()-1) {
        insertIntoMap(document.substring(lastSpaceAt+1,i+1),docuMap);
      }
    }
    String[][] stringMap = new String[docuMap.size()][2];
    Object[] keys = docuMap.keySet().toArray();
    Object[] values = docuMap.values().toArray();
    for(int i = 0; i < stringMap.length; i++) {
      stringMap[i][0] = keys[i].toString();
      stringMap[i][1] = values[i].toString();
    }
    return stringMap;
  }
  
  static void insertIntoMap(String word, Map<String,Integer> docuMap) {
    if(docuMap.get(word) != null) {
      int val = docuMap.get(word);
      docuMap.put(word, ++val);
    }
    else {
      docuMap.put(word,1);
    }
  }
  public static void main(String[] args) {
    String document = "Practice makes perfect. you'll only get Perfect by practice. just practice";
    String[][] result = wordCountEngine(document);
    for(int i = 0;i < result.length; i++) {
    	System.out.println(result[i][0]+" "+result[i][1]);
    }
    
  }
}