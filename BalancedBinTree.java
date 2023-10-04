public class BalancedBinTree {
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

	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		} else if (root.left != null && root.right != null) {
			return Math.max(height(root.left), height(root.right)) + 1;
		} else if (root.left != null) {
			return height(root.left) + 1;
		} else if (root.right != null) {
			return height(root.right) + 1;
		} else {
			return 1;
		}

	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		return isBalanced(root.left) && isBalanced(root.right)
				&& Math.abs(height(root.left) - height(root.right)) <= 1;
	}
}
