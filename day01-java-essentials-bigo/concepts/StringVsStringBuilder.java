/*
 * Day 1 · Concept: String is immutable, StringBuilder is changeable
 *
 * Rules learned:
 *   - String methods NEVER change the original; they return a new String (store it, or it is lost)
 *   - StringBuilder methods change THE SAME object, so changes accumulate step by step
 *   - building a String with s = s + x in a loop is O(n^2); StringBuilder.append is O(n) total
 *   - compare Strings with equals(), chars and ints with ==
 *
 * My mistakes (fixed):
 *   - thought each StringBuilder call works on the original string (it works on the latest result)
 *   - forgot that setCharAt REPLACES one char (length stays the same)
 */
public class StringVsStringBuilder {
    public static void main(String[] args) {
        String s = "abc";
        s.concat("d");                       // result thrown away
        System.out.println(s);               // abc

        StringBuilder sb = new StringBuilder("abc");
        sb.append("d");                      // changes sb itself
        System.out.println(sb);              // abcd

        StringBuilder t = new StringBuilder("java");
        t.append('!');                       // java!
        t.setCharAt(0, 'J');                 // Java!
        t.reverse();                         // !avaJ
        t.deleteCharAt(0);                   // avaJ
        System.out.println(t + " " + t.length());   // avaJ 4

        String x = new String("X++");
        System.out.println(x == "X++");      // false: different objects
        System.out.println(x.equals("X++")); // true:  same characters
    }
}
