
public class _112_Path_Sum {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/*
	 * 	����д󲿷ֶ�����Ҫ�ٶ���һ���������еݹ��
	 * 	����д��һ���Ե��õݹ�ķ���
	 * 
	 * 	�ݹ���ÿ���sumֵ�����˸ò���Ҫ�ĺ�
	 * */
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            return (root.val == sum);
        }
        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }
}
