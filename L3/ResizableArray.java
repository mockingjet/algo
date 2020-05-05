package L3;

import java.util.Arrays;

public class ResizableArray {

  String[] s;
  int n = 0;

  ResizableArray() {
    s = new String[1];
  }

  void push(String item) {
    if (n == s.length)
      resize(2 * n);
    s[n++] = item;
  }

  void resize(int len) {
    String[] copy = new String[len];
    for (int i = 0; i < n; i++) {
      copy[i] = s[i];
    }
    s = copy;
  }

  String pop() {
    String item = s[--n];
    s[n] = null;
    if (n > 0 && n == s.length / 4)
      resize(s.length / 2);
    return item;
  }

  public static void main(String[] args) {
    ResizableArray test = new ResizableArray();
    test.push("a");
    test.push("a");
    test.push("a");
    test.push("a");
    test.push("a");
    System.out.println(Arrays.toString(test.s));
    System.out.println("pop: " + test.pop());
    System.out.println("pop: " + test.pop());
    System.out.println("pop: " + test.pop());
    System.out.println(Arrays.toString(test.s));
  }
}