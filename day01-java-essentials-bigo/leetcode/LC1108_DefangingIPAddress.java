/*
 * LeetCode 1108 · Defanging an IP Address · Easy             Status: Hint-assisted
 * https://leetcode.com/problems/defanging-an-ip-address/
 *
 * Question: Replace every "." with "[.]".
 * Examples: "1.1.1.1" -> "1[.]1[.]1[.]1"; "255.100.50.0" -> "255[.]100[.]50[.]0"
 *
 * Approach: build a new string with StringBuilder; append "[.]" for '.', else the char.
 * Time O(n) (each append is O(1); s = s + x in a loop would be O(n^2)), Space O(n)
 *
 * My mistake (fixed): wrote c = "[.]"
 *   - a char holds one character, a String cannot be assigned to it (compile error)
 *   - c is only a copy; changing it changes neither the input nor the result
 *   -> append the replacement to the StringBuilder instead.
 */
public class LC1108_DefangingIPAddress {

    static class Solution {
        public String defangIPaddr(String address) {
            StringBuilder sb = new StringBuilder();
            for (char c : address.toCharArray()) {
                if (c == '.') {
                    sb.append("[.]");
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.defangIPaddr("1.1.1.1"));        // 1[.]1[.]1[.]1
        System.out.println(s.defangIPaddr("255.100.50.0"));   // 255[.]100[.]50[.]0
    }
}
