package top.javinjunfeng.leetcode;

/**
 * @Author: javinjunfeng
 * @Company: 杭州数政科技有限公司
 * @Date: 2021/3/1 3:31 PM
 * @Descriptoin:
 */
public class LeetCode_007 {
    public static int reverse(int x) {
        long n = 0;
        while (x != 0)
        {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return (int)n==n? (int)n:0;
    }

    public static void main(String[] args) {
        int reverse = reverse(123);
        System.out.println(reverse);
    }
}
