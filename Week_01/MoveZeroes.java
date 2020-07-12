/**
 * leetcode -- 283
 * 移动零
 */
public class MoveZeroes{

    /**
     * move zero
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int lastNonZeroIndex = 0;
        for(int i=0;i<length;++i){
            if(nums[i] != 0){
                //swap when num is not equal zero
                swap(nums,lastNonZeroIndex,i);
                lastNonZeroIndex++;
            }
        }
    }

    /**
     * swap two elements
     * @param nums
     * @param i
     * @param j
     */
    static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }
}