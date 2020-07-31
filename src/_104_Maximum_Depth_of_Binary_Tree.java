
public class _104_Maximum_Depth_of_Binary_Tree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * 	�����⾹ȻҲ�������
	 * 	���Ҷ��⵽��ɴ򿨲�໨�������Ӱ�
	 * 	̫���ˣ��ݹ��������
	 * */
	
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
