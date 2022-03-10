package general_0100_0199;

import base.TreeNode;

public class _104_Maximum_Depth_of_Binary_Tree {

	/*
	 * 	这种题竟然也上了题库
	 * 	从我读题到完成打卡差不多花了三分钟吧
	 * 	太简单了，递归就完事了
	 * */
	
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
