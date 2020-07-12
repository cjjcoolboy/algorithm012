import java.util.Arrays;

/**
 * 合并两个有序数组
 * leetcode -- 88
 **/
public class MergeTwoArrays {

    /**
     * simple solution
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for(int i=m;i<m+n;++i){
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
    }

    /**
     * better solution double Pointer
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        int length = m+n;
        int p1 = m-1 < 0 ? 0 : m-1;
        int p2 = n-1 < 0 ? 0 : n-1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] < nums2[p2]){
                nums1[length-1] = nums2[p2];
                p2--;
            }else{
                nums1[length-1] = nums1[p1];
                p1--;
            }
            length--;
        }
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        //simple solution
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
        //better solution
        int[] nums11 = new int[]{1,2,3,0,0,0};
        int m1 = 3;
        int[] nums21 = new int[]{2,5,6};
        int n1 = 3;
        merge1(nums11,m1,nums21,n1);
        System.out.println(Arrays.toString(nums11));
    }
}