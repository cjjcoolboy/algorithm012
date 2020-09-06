import java.util.Stack;

/**
 * @Deseription 仅仅反转字母
 * leetcode--917
 **/
public class ReverseOnlyLetters {

    /**
     * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
     *
     * 示例 1：
     *
     * 输入："ab-cd"
     * 输出："dc-ba"
     * 示例 2：
     *
     * 输入："a-bC-dEf-ghIj"
     * 输出："j-Ih-gfE-dCba"
     * 示例 3：
     *
     * 输入："Test1ng-Leet=code-Q!"
     * 输出："Qedo1ct-eeLg=ntse-T!"
     *  
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-only-letters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param S
     * @return
     */
    public static String reverseOnlyLetters(String S) {
        Stack<String> stack = new Stack<String>();
        char[] chars = S.toCharArray();
        int length = chars.length;
        for(int i=0;i<length;++i){
            if(isLetter(chars[i])){
                stack.push(String.valueOf(chars[i]));
            }
        }
        for(int i=0;i<length;++i){
            if(isLetter(chars[i])){
                chars[i] = stack.pop().charAt(0);
            }
        }
        return String.valueOf(chars);
    }

    private static boolean isLetter(char c){
        return (c >='a' && c <= 'z') || (c >='A' && c <= 'Z');
    }

    public static void main(String[] args) {
        String str = "ab-cd";
        String s = reverseOnlyLetters(str);
        System.out.println("result:" + s);
    }
}
