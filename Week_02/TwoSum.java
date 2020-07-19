import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Deseription 两数之和
 * leetcode -- 1
 **/
public class TwoSum {

    /**
     * Violence solution
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if(length < 1){
            return new int[]{};
        }
        for(int i=0;i<length;++i){
            int first = nums[i];
            for(int j=i+1;j<length;++j){
                if(first+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * better solution
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(length);
        for(int i=0;i<length;++i){
            int otherNum = target - nums[i];
            if(map.containsKey(otherNum)){
                result[0] = i;
                result[1] = map.get(otherNum);
                return result;
            }
            map.put(nums[i],i);
        }
        throw new RuntimeException("no result");
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        //Violence solution
        System.out.println("result:"+ Arrays.toString(twoSum(nums, target)));
        //better solution
        System.out.println("result:"+ Arrays.toString(twoSum2(nums, target)));
    }
}
