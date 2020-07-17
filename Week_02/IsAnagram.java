package com.flying.leetcode.mypractise;

/**
 * 有效的字母异位词
 * leetcode -- 242
 **/
public class IsAnagram {

    /**
     * better solution
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if(sLength != tLength){
            return false;
        }
        if(sLength == 0){
            return true;
        }
        int[] buckets = new int[26];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for(int i=0;i<sLength;++i){
            buckets[chars[i] - 'a']++;
        }
        for(int i=0;i<tLength;++i){
            buckets[chart[i] - 'a']--;
        }
        for(int bucket : buckets){
            if(bucket != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * better solution
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram3(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if(sLength != tLength){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        s = String.valueOf(chars);
        t = String.valueOf(chart);
        return s.equals(t);
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }
}
