/*
Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

Note:

All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.

*/

/*
Time complexity: O(N/K) where N is number of possible keys and K is number of buckets declared (9973 in this case)
Space complexity: O(K+M) where K is pre-defined buckets(9973) and M is number of unique key,value pairs inserted 
*/
class MyHashMap {

    final ListNode[] map = new ListNode[9973];
    
    /** value will always be non-negative. */
    public void put(int key, int value) {

       // Calculate Hash 
       int i = this.calcHash(key);
       // If null, create dummy head
       if(map[i] == null) 
           map[i] = new ListNode(-1, -1);
       // Get link to the node whose next is either null or matches current key
        ListNode prev = find(map[i], key);

        //If null, insert next
        if(prev.next == null)
            prev.next = new ListNode(key,value);
        // If not null, replace val with the value
        else
            prev.next.val = value;       
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int i = calcHash(key);

        //Key not found
        if(map[i] == null)
            return -1;

        // Get link to the node
        ListNode node = find(map[i],key);

        //If null, return -1, else return val
        return node.next == null?-1: node.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
         int i = calcHash(key);
         if(map[i] == null)
            return;

         // Get link to node, remove link between curr and next
         ListNode prev = find(map[i],key);
         if(prev.next != null) 
             prev.next = prev.next.next;
    }
    
    int calcHash(int key) {
        // Returns uncomplicated primitive integer value% array length
        return Integer.hashCode(key)%map.length;
    }
    
    ListNode find(ListNode node,int key) {
        ListNode prev = null;

        /*
        Loop until key is found or node is null 
        Return node which has next to be "required node"
        */
        while(node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
    
    static class ListNode {
        ListNode next;
        int key, val;
    
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */


 //======================================================= METHOD-2====================================================
class MyHashMap {

    /** Initialize your data structure here. */
    int[] map;
    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map,-1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;
    }
}

//======================================================= METHOD-3====================================================

class Pair<U, V> {
  public U first;
  public V second;

  public Pair(U first, V second) {
    this.first = first;
    this.second = second;
  }
}


class Bucket {
  private List<Pair<Integer, Integer>> bucket;

  public Bucket() {
    this.bucket = new LinkedList<Pair<Integer, Integer>>();
  }

  public Integer get(Integer key) {
    for (Pair<Integer, Integer> pair : this.bucket) {
      if (pair.first.equals(key))
        return pair.second;
    }
    return -1;
  }

  public void update(Integer key, Integer value) {
    boolean found = false;
    for (Pair<Integer, Integer> pair : this.bucket) {
      if (pair.first.equals(key)) {
        pair.second = value;
        found = true;
      }
    }
    if (!found)
      this.bucket.add(new Pair<Integer, Integer>(key, value));
  }

  public void remove(Integer key) {
    for (Pair<Integer, Integer> pair : this.bucket) {
      if (pair.first.equals(key)) {
        this.bucket.remove(pair);
        break;
      }
    }
  }
}

class MyHashMap {
  private int key_space;
  private List<Bucket> hash_table;

  /** Initialize your data structure here. */
  public MyHashMap() {
    this.key_space = 2069;
    this.hash_table = new ArrayList<Bucket>();
    for (int i = 0; i < this.key_space; ++i) {
      this.hash_table.add(new Bucket());
    }
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    int hash_key = key % this.key_space;
    this.hash_table.get(hash_key).update(key, value);
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(int key) {
    int hash_key = key % this.key_space;
    return this.hash_table.get(hash_key).get(key);
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    int hash_key = key % this.key_space;
    this.hash_table.get(hash_key).remove(key);
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */