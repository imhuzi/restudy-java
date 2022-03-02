package com.uyibai.algorithm;

/**
 * 判断 一个字符串是否是回文字符串
 */
public class PalindromeString {

    public static void main(String[] args) {
        String str1 = "12321";
        String str2 = "123321";
        String str3 = "121321";
        System.out.println(isPalindrome(str1));
        System.out.println(isPalindrome2(str1));
        System.out.println(isPalindrome3(str1, 0, str1.length() -1));
    }

    /**
     * 循环方式的头尾比较,
     *
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        int N = str.length();
        for (int i = 0; i < N / 2; i++) {
            if (str.charAt(i) != str.charAt(N - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * String 反转 直接 在与原串比较
     *
     * @param str
     * @return
     */
    public static boolean isPalindrome2(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return str.equals(sb.toString());
    }

    /**
     * 头尾指针递归 判断 回文
     *
     * @param str
     * @param lo  头
     * @param hi  尾
     * @return
     */
    public static boolean isPalindrome3(String str, int lo, int hi) {
        if (hi == 0 || hi == 1) {
            return true;
        } else {
            char c1 = str.charAt(lo), c2 = str.charAt(hi);
            if (c1 == c2) {
                return isPalindrome3(str, lo + 1, hi - 1);
            } else {
                return false;
            }
        }
    }
}
