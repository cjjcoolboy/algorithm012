/**
 * @Deseription 二叉树的最近公共祖先
 * leetcode -- 236
 **/
public class LowestCommonAncestor {

    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // terminator
        if (root == null || root == p || root == q){
            return root;
        }
        // process logic
        // drill down
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        //lowestCommonAncestor();
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
}
