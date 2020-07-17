package com.flying.leetcode.mypractise;

/**
 * 有效的字母异位词
 * leetcode -- 242
 **/
public class IsAnagram {

    /**
     * the worst solution, Exactly not recommend
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        //遍历字符串s，然后依次删除出现在字符串t中对应的字符，直到最后字符串t为空，即返回true，否则返回false
        int sLength = s.length();
        int tLength = t.length();
        if(sLength != tLength){
            return false;
        }
        if(sLength == 0){
            return true;
        }
        char[] chars = s.toCharArray();
        for(int i=0;i<=sLength/2 && i<=sLength-i-1;++i){
            String strFront = String.valueOf(chars[i]);
            String strLast = String.valueOf(chars[sLength-i-1]);
            t = t.replaceFirst(strFront,"");
            t = t.replaceFirst(strLast,"");
        }
        return t.length() == 0;
    }

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
     * run test
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }
}
