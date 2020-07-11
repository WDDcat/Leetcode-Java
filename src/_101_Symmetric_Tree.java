
public class _101_Symmetric_Tree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * public boolean isSymmetric(TreeNode root) { if(root == null) return true;
	 * return isLeftEqualsRight(root.left, root.right); }
	 * 
	 * public boolean isLeftEqualsRight(TreeNode left, TreeNode right) { if(left ==
	 * null && right == null) return true; if(left == null || right == null) return
	 * false; return left.val == right.val && isLeftEqualsRight(left.right,
	 * right.left) && isLeftEqualsRight(left.left, right.right); }
	 */
	
	/*
	 * 	上面的方法时我一开始想到的递归方法。即：
	 * 	左子树的右孩子 == 右子树的左孩子
	 * 	左子树的左孩子 == 右子树的有孩子
	 * 	只需维持两个关系即可。
	 * 
	 * 	然后发现时空复杂度都好高
	 * 	于是在题解里发现了一个高级方法，即：
	 * 	翻转root节点的左子树以及其子树
	 * 	然后判断左子树和右子树是不是完全一致就可以了
	 * 
	 * 	这样的执行时间可以缩到0ms
	 * 	不知道为啥
	 * */

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		reverseTree(root.left);
		return isEqual(root.left, root.right);
	}

	void reverseTree(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		reverseTree(root.left);
		reverseTree(root.right);
	}

	boolean isEqual(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		return left.val == right.val && isEqual(left.left, right.left) && isEqual(left.right, right.right);
	}
}
