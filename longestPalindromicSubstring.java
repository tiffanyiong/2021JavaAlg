/*
* Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
*  and there exists one unique longest palindromic substring.
*
* Example 1:

Input:"abcdzdcab"
Output:"cdzdc"
*
* Example 2:

Input:"aba"
Output:"aba"
*
* O(n2) time is acceptable. Can you do it in O(n) time.
* */

public class Solution {
    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        int start = 0, len = 0, longest = 0;
        for (int i = 0; i < s.length(); i++) {
            len = findLongestPalindromeFrom(s, i, i);
            if(len > longest) {
                longest = len;
                start = i - len / 2;
            }

            len = findLongestPalindromeFrom(s, i, i+1);
            if(len > longest) {
                longest = len;
                start = i - len / 2 + 1;
            }

        }

        return s.substring(start, start + longest);

    }

    private int findLongestPalindromeFrom(String s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length()){
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            len += left == right ? 1:2;
            left--;
            right++;
        }

        return len;
    }
}