package general_0100_0199;

import base.TreeNode;

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

	/*
	 * 	想复杂了，一开始还在想怎么构建平衡二叉树
	 * 	后来发现题目中给的是排序数组
	 * 	中间设为root，左边的数交给左子树，右边的数交给右子树
	 * 	递归
	 * 	完成
	 * */

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;
		return createTree(nums, 0, nums.length);
	}

	private TreeNode createTree(int[] nums, int begin, int end) {
		if (begin == end)
			return null;
		int mid = (begin + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = createTree(nums, begin, mid);
		root.right = createTree(nums, mid + 1, end);
		return root;
	}
}
