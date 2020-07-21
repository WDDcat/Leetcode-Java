import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _95_Unique_Binary_Search_Trees_II {

	public class TreeNode {
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

	/*
	 * 递归，逐层创建分别的左右子树
	 */

	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<TreeNode>();
		}
		return generateTreesList(1, n);
	}

	public List<TreeNode> generateTreesList(int start, int end) {
		List<TreeNode> roots = new LinkedList<>();

		if (start > end) {
			roots.add(null);
			return roots;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> leftTrees = generateTreesList(start, i - 1);
			List<TreeNode> rightTrees = generateTreesList(i + 1, end);

			for (TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					TreeNode currTree = new TreeNode(i);
					currTree.left = left;
					currTree.right = right;
					roots.add(currTree);
				}
			}
		}

		return roots;
	}
}
