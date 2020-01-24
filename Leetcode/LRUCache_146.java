/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 // capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

*/
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true); // true if require ACCESS ORDER, else by default insertion order
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


import java.util.HashMap;
class Main {
  class DLNode {
    int key, value;
    DLNode pre,post;
  }

  private HashMap<Integer, DLNode> cache = new HashMap<Integer,DLNode>();
  private int capacity, count;
  private DLNode head,tail;

  public Main(int capacity) {
    this.capacity = capacity;
    this.count = 0;

    head = new DLNode();
    tail = new DLNode();

    head.pre = null;
    tail.post = null;

    head.post = tail;
    tail.pre = head;
  }

  public int get(int key) {
    DLNode node = cache.get(key);
    if(node == null) 
      return -1;
    this.moveToHead(node);
    return node.value;
  }

  private void moveToHead(DLNode node) {
    this.removeNode(node);
    this.addNode(node);
  }

  private void removeNode(DLNode node) {
    node.pre.post = node.post;
    node.post.pre = node.pre;
  }

  private void addNode(DLNode node) {
    node.post = head.post;
    head.post.pre = node;
    head.post = node;
    node.pre = head; 
  }

  public void put(int key, int value) {
    DLNode node = cache.get(key);
    if(node == null) {
      DLNode newNode = new DLNode();
      newNode.key = key;
      newNode.value = value;

      this.cache.put(key,newNode);
      this.addNode(newNode);
      ++count;

      if(count > capacity) {
        DLNode tail = this.removeTail();
        cache.remove(tail.key);
        count--;
      }
    }
    else {
      node.value = value;
      this.moveToHead(node);
    }
  }

    private DLNode removeTail() {
      DLNode res = tail.pre;
      this.removeNode(res);
      return res;
    }

  public static void main(String[] args) {
    Main lrucache = new Main(2);
    System.out.println(lrucache.get(1));
    lrucache.put(1,1);
    System.out.println(lrucache.get(1));
    lrucache.put(2,2);
    System.out.println(lrucache.get(2));
    lrucache.put(5,3);
    System.out.println(lrucache.get(2));
    System.out.println(lrucache.get(5));
  }


}