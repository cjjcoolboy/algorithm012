import java.util.Arrays;
import java.util.Collections;

/**
 * @Deseription 岛屿数量
 * leetcode -- 200
 **/
public class NumIslands {

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 示例 1:
     * 输入:
     * [
     * ['1','1','1','1','0'],
     * ['1','1','0','1','0'],
     * ['1','1','0','0','0'],
     * ['0','0','0','0','0']
     * ]
     * 输出: 1
     * 示例 2:
     *
     * 输入:
     * [
     * ['1','1','0','0','0'],
     * ['1','1','0','0','0'],
     * ['0','0','1','0','0'],
     * ['0','0','0','1','1']
     * ]
     * 输出: 3
     * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int row = grid.length;
        if(row < 1){
            return 0;
        }
        int column = grid[0].length;
        int count = 0;
        for(int i=0;i<row;++i){
            for(int j=0;j<column;++j){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j,row,column);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid,int i,int j,int row,int column){
        // terminator
        if(i<0 || j<0 || i>=row || j>=column || grid[i][j] == '0'){
            return;
        }
        // process logic
        grid[i][j] = '0';
        // drill down
        dfs(grid,i+1,j,row,column);
        dfs(grid,i,j+1,row,column);
        dfs(grid,i-1,j,row,column);
        dfs(grid,i,j-1,row,column);
        // restore
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] grid = new char[4][5];
        int count = numIslands(grid);
        System.out.println("result:"+count);
    }
}
