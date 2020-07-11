
public class _112_Path_Sum {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/*
	 * 	题解中大部分都是需要再定义一个函数进行递归的
	 * 	这里写了一个自调用递归的方法
	 * 
	 * 	递归中每层的sum值代表了该层需要的和
	 * */
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            return (root.val == sum);
        }
        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }
}
