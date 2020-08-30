/**
 * @Deseription 颠倒二进制位
 * leetcode--190
 **/
public class ReverseBits {

    public static int reverseBits(int n) {
        int ret = 0;
        int power = 31;
        while(power >= 0){
            ret += (n & 1) << power;
            n = n >> 1;
            power -= 1;
        }
        return ret;
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        int n = Integer.parseUnsignedInt("00000010100101000001111010011100",2);
        int result = reverseBits(n);
        System.out.println("result:"+result);
    }
}
