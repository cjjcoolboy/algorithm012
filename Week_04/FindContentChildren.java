import java.util.Arrays;

/**
 * @Deseription 分发饼干
 *  * leetcode -- 455
 **/
public class FindContentChildren {

    /**
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLength = g.length;
        int sLength = s.length;
        if(gLength == 0 || sLength == 0){
            return 0;
        }
        int count = 0;
        for (int value : s) {
            if (count < gLength && value >= g[count]) {
                count++;
            }
        }
        return count;
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        int contentChildren = findContentChildren(g, s);
        System.out.println("result:"+contentChildren);
    }
}
