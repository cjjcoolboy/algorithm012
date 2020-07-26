import java.util.LinkedList;
import java.util.List;

/**
 * @Deseription 组合
 * leetcode -- 77
 **/
public class Combine {

    static List<List<Integer>> result = new LinkedList<>();
    static int count = 0;

    /**
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            return result;
        }
        count = k;
        LinkedList<Integer> temp = new LinkedList<>();
        backstrack(n, 1, k, temp);
        return result;
    }

    /**
     *
     * @param num
     * @param index
     * @param k
     * @param temp
     */
    public static void backstrack(int num, int index, int k, LinkedList<Integer> temp) {
        if (temp.size() == count) {
            result.add(new LinkedList<Integer>(temp));
            return;
        }
        if (k > 0) {
            for (int i = index; i <= num; i++) {
                temp.add(i);
                backstrack(num, i + 1, k - 1, temp);
                temp.removeLast();
            }
        }
    }

    /**
     * run test
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        combine(n,k);
        System.out.println(combine(n,k));
    }
}
