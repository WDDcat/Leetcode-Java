package general_0100_0199;

import base.TreeNode;

public class _112_Path_Sum {

	/*
	 * 	����д󲿷ֶ�����Ҫ�ٶ���һ���������еݹ��
	 * 	����д��һ���Ե��õݹ�ķ���
	 * 
	 * 	�ݹ���ÿ���sumֵ�����˸ò���Ҫ�ĺ�
	 * */
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			return (root.val == sum);
		}
		return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
	}
}
