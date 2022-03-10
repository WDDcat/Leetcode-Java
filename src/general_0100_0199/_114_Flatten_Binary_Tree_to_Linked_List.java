package general_0100_0199;

import base.TreeNode;

public class _114_Flatten_Binary_Tree_to_Linked_List {

	/*
	 * 	这次的题不需要返回值，但思路与递归也类似
	 * 	将一个二叉树展开成先序遍历的List然后以右子树的方式将他们串起来
	 * 	
	 * 	大概步骤就是
	 * 	递归展开
	 * 	① 左子树的最底端 .right = root.right
	 * 	② root.right = root.left
	 * 	③ root.left = null
	 * */
	
	public void flatten(TreeNode root) {	
		
		if (root == null)
			return;

		flatten(root.left);
		flatten(root.right);

		if (root.left != null) {
			TreeNode cur = root.left;
			while (cur.right != null) {
				cur = cur.right;
			}
			cur.right = root.right;
			root.right = root.left;
			root.left = null;
		}
	}
}
