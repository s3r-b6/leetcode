public class LowestCommonAncestor {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {val = x;}
	}

	static class Solution {

		public static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
			int lo = Math.min(p.val, q.val);
			int hi = Math.max(p.val, q.val);

			// This is basically a binary search over the binTree, exploiting the fact that both nodes
			// exist in the BST and that they are unique.
			while (root != null) {
				if (root.val > hi) {
					root = root.left;
				} else if (root.val < lo) {
					root = root.right;
				} else {
					// lo <= root <= hi, root is between lo and hi or is lo or hi.
					return root;
				}
			}

			return null;
		}

		public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (root == null) return null;

			// Nodes are unique && p and q exist in the BST.
			// Preorder traversal. If root is P or Q, return root, else, explore subtrees.
			if (root.val == p.val || root.val == q.val) return root;
			TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
			TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

			if (leftLCA != null && rightLCA != null) return root;
			return leftLCA != null ? leftLCA : rightLCA;

		}
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(6);
		n1.left = new TreeNode(2);
		n1.left.left = new TreeNode(0);
		n1.left.right = new TreeNode(4);

		n1.left.right.left = new TreeNode(3);
		n1.left.right.right = new TreeNode(5);

		n1.right = new TreeNode(8);
		n1.right.left = new TreeNode(7);
		n1.right.right = new TreeNode(9);

		System.out.println(Solution.lowestCommonAncestor(n1, new TreeNode(2), new TreeNode(4)));
	}

}