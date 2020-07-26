/**
 * @Deseription 从前序与中序遍历序列构造二叉树
 * leetcode -- 105
 **/
public class BuildTree {

    /**
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     *
     * @param preorder
     * @param pStart
     * @param pEnd
     * @param inorder
     * @param iStart
     * @param iEnd
     * @return
     */
    private static TreeNode help(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        // terminator
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        // process logic
        TreeNode treeNode = new TreeNode(preorder[pStart]);
        //index
        int index = 0;
        while (inorder[iStart + index] != preorder[pStart]) {
            index++;
        }
        // drill down
        treeNode.left = help(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
        //drill down
        treeNode.right = help(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
        return treeNode;

    }

    /**
     * run test
     * @param args
     */
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
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
