
/**
 * @Deseription 翻转字符串里的单词
 * leetdoce -- 151
 **/
public class ReverseWords {

    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     *
     *  
     *
     * 示例 1：
     *
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     * 示例 2：
     *
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     *
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        //最暴力的方法，遍历字符串，把所有单词放到一个数组里面
        String[] strs = s.split(" ");
        int length = strs.length;
        StringBuilder result = new StringBuilder();
        int isEndIndex = length-1;
        for(int i=isEndIndex;i>=0;--i){
            String word = strs[i].trim();
            if(" ".equals(word) || "".equals(word)){
                isEndIndex--;
                continue;
            }
            result.append(isEndIndex == 0 ? word : word + " ");
        }
        return result.toString().trim();
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        String centences = "a good   example";
        System.out.println("result:{}",reverseWords(centences));
    }
}
