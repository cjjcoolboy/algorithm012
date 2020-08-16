/**
 * 最小路径和
 * leetcode--64
 **/
public class MinPathSum {

    /**
     * dp solve
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        // 动态规划
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        // 初始化列
        for(int i=1;i<column;++i){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        // 初始化行
        for(int i=1;i<row;++i){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //状态方程
        for(int i=1;i<row;++i){
            for(int j=1;j<column;++j){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[row-1][column-1];
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int result = minPathSum(grid);
        System.out.println("result: "+result);
    }
}
