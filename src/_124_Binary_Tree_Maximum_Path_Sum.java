
public class _124_Binary_Tree_Maximum_Path_Sum {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
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
