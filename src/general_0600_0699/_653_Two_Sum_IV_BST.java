package general_0600_0699;

import java.util.ArrayList;
import java.util.List;

import base.TreeNode;

public class _653_Two_Sum_IV_BST {
	
	/*
	 * 我一开始想到的方法是
	 * 所有的数添加到一乐 List 中，然后排序，然后双指针
	 * 
	 * 后来发现如果是 BST 的话，直接中序遍历就可以得到排序的数组
	 * 
	 * ----------
	 * 在题解中还看到了一个方法
	 * 建立一个 HashMap
	 * 里面存放 <k-x, k-x是否存在>
	 * 这样只需要一次 dfs，就可以边添加便检查了
	 * */
	
	List<Integer> nums = new ArrayList<>();
	
	public boolean findTarget(TreeNode root, int k) {
		dfs(root);
		int l = 0; 
		int r = nums.size() - 1;
		while(l < r) {
			int sum = nums.get(l) + nums.get(r);
			if(sum < k) {
				l++;
			} else if(sum == k) {
				return true;
			} else {
				r--;
			}
		}
		return false;
    }
	
	private void dfs(TreeNode root) {
		if(root.left != null) {
			dfs(root.left);
		} 
		nums.add(root.val);
		if(root.right != null) {
			dfs(root.right);
		}
	}
}
