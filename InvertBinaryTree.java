public class InvertBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;

            if (root.left != null)
                invertTree(root.left);
            if (root.right != null)
                invertTree(root.right);

            return root;
        }
    }
}
