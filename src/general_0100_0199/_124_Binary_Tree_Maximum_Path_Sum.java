package general_0100_0199;

import base.TreeNode;

public class _124_Binary_Tree_Maximum_Path_Sum {

	/*
	 * 	�������˼·�ִ���
	 * 	����ţ�Ǽ�һֱ�ڿ��������Ѷ���������ͼ�ṹ��Ȼ���������ֵ
	 * 
	 * 	�����⼸�д���ͽ����
	 * 	
	 * 	�ݹ�maxGain���ص�������һ���ߵ����ֵ
	 * 	Ȼ��max�����洢���������������ӵ����ֵ
	 * 	�����ݹ�֮����������������ı���
	 * */
	
	private int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxGain(root);
		return max;
	}

	private int maxGain(TreeNode node) {
		if (node == null)
			return 0;
		int val = node.val;
		int left = Math.max(maxGain(node.left), 0);
		int right = Math.max(maxGain(node.right), 0);

		max = Math.max(max, val + left + right);

		return node.val + Math.max(left, right);
	}
}
