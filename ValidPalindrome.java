
       /*验证回文字符串 Ⅱ
        给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

        示例 1:

        输入: "aba"
        输出: True
        示例 2:

        输入: "abca"
        输出: True
        解释: 你可以删除c字符。
        注意:

        字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。*/

public class Solution {
    /**
     * @param s: a string
     * @return boolean: whether you can make s a palindrome by deleting at most one character
     */
    public boolean validPalindrome(String s) {

        if(s == null){
            return false;
        }

        Pair pair = findDifference(s, 0, s.length()-1);
        if(pair.left >= pair.right){
            return true;
        }
        return isPalindrome(s, pair.left +1, pair.right)
                || isPalindrome(s, pair.left, pair.right - 1);


    }

    private Pair findDifference(String s, int left, int right){
        while(left < right && s.charAt(left) == s.charAt(right)){
            left++;
            right--;
        }
        return new Pair(left, right);
    }

    private boolean isPalindrome(String s, int left, int right){
        Pair pair = findDifference(s, left, right);
        return pair.left >= pair.right;
    }
}


class Pair{
    int left, right;
    public Pair(int left, int right){
        this.left = left;
        this.right = right;
    }
}