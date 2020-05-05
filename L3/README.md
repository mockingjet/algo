If array is full, create a new array of twice the size, and copy items.
Array accesses to insert first N = 2i items. N + (2 + 4 + 8 + … + N) ~ 3N.

## memory usage

* WeightedQuickUnionUF
```java
public class WeightedQuickUnionUF { 
  // 16 bytes (object overhead)
  private int[] id = new int[N]; 
  // 8 + (4N + 24) bytes ( ref + int[] + array overhead)
  private int[] sz = new int[N]; 
  // 8 + (4N + 24) bytes ( ref + int[] + array overhead)
  private int count; 
  // 4 bytes (int) + 4 bytes (padding)

  // 8N + 88 bytes
}
```

* ResizingArrayStackOfStrings
> Proposition. Uses between ~ 8 N and ~ 32 N bytes to represent a stack with N items.
```java
public class ArrayResizing
{
  private int N = 0;
  
  /** if use array stack */
  private String[] s;
  // 8N bytes ~ 32bytes
  
  /** else use linked list */
  // 8 bytes (inner class extra overhead)
  private class Node {
    // 16 bytes (object overhead)
    String item;
    // 8 bytes (ref to String)
    Node next;
    // 8 bytes (ref to Node)

    // 40bytes
  }
}
```