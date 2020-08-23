import java.util.ArrayList;
import java.util.List;

/**
 * @Deseription 括号生成
 * leetcode--22
 **/
public class GenerateParenthesis {

    /**
     * 剪枝方法
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result,n,"",0,0);
        return result;
    }

    /**
     * 1. 左括号优先于右括号
     * 2. 左括号数小于总数
     * 3. 右括号的数小于左括号（合法性）
     * @param result
     * @param n
     * @param s
     * @param left
     * @param right
     */
    private static void helper(List<String> result,int n,String s,int left,int right){
        if(s.length() == n*2){
            result.add(s);
            return;
        }
        String leftStr = "(";
        String rightStr = ")";
        if(left < n && left >= right){
            helper(result,n,s+leftStr,left+1,right);
        }
        if(right < n && left >= right){
            helper(result,n,s+rightStr,left,right+1);
        }
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println("result:"+result);
    }
}
