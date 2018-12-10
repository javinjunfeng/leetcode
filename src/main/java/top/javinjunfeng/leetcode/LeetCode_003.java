package top.javinjunfeng.leetcode;

import java.util.HashMap;

/**
 * @Author: javinjunfeng
 * @Date: 2018/12/10 10:44 AM
 * @Version 1.0
 */
public class LeetCode_003 {
    private static int lengthOfLongestSubstring(String s) {
        int lenth = 0;
        int lastLenth = 0;
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (hashMap.containsKey(c)){
                if (lastLenth < lenth){
                    lastLenth = lenth;
                }
                i = hashMap.get(c);
                if (lastLenth > s.length() - i){
                    break;
                }
                hashMap.clear();
                continue;
            }
            hashMap.put(c,i);
            lenth = hashMap.size();
        }
        return lenth > lastLenth ? lenth : lastLenth;
    }

    public static void main(String[] args) {
        String string = "dvdf";
        int i = lengthOfLongestSubstring(string);
        System.out.println(i);
    }
}
