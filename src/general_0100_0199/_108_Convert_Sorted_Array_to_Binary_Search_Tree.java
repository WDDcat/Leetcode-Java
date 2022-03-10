package general_0100_0199;

import base.TreeNode;

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

	/*
	 * 	�븴���ˣ�һ��ʼ��������ô����ƽ�������
	 * 	����������Ŀ�и�������������
	 * 	�м���Ϊroot����ߵ����������������ұߵ�������������
	 * 	�ݹ�
	 * 	���
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
