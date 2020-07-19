import java.util.*;

/**
 * @Deseription 前 K 个高频元素
 * leetcode -- 347
 **/
public class TopKFrequent {

    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>(length);
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> topK = new PriorityQueue<Map.Entry<Integer,Integer>>((m1, m2) -> m2.getValue() - m1.getValue());
        topK.addAll(map.entrySet());
        int[] result = new int[k];
        for(int i=0;i<k;++i){
            result[i] = Objects.requireNonNull(topK.poll()).getKey();
        }
        return result;
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ints = topKFrequent(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
