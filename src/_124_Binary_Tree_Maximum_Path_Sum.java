
public class _124_Binary_Tree_Maximum_Path_Sum {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/*
	 * 	今天的题思路又错了
	 * 	钻了牛角尖一直在考虑怎样把二叉树换成图结构，然后再求最大值
	 * 
	 * 	结果题解几行代码就解决了
	 * 	
	 * 	递归maxGain返回的是其中一条线的最大值
	 * 	然后max用来存储包括左右子树链接的最大值
	 * 	这样递归之后就完成了两种情况的遍历
	 * */
	
	int max = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		maxGain(root);
		return max;
    }
	
	int maxGain(TreeNode node) {
		if(node == null) return 0;
		int val = node.val;
		int left = Math.max(maxGain(node.left), 0);
		int right = Math.max(maxGain(node.right), 0);
		
		max = Math.max(max, val + left + right);
		
		return node.val + Math.max(left, right);
	}
}
