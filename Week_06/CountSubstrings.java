/**
 * 回文子串
 * leetcode--647
 **/
public class CountSubstrings {

    /**
     *
     * @param S
     * @return
     */
    public static int countSubstrings(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        String str = "abc";
        int result = countSubstrings(str);
        System.out.println("result:"+result);
    }
}
