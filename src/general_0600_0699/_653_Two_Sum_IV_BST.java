package general_0600_0699;

import java.util.ArrayList;
import java.util.List;

import base.TreeNode;

public class _653_Two_Sum_IV_BST {
	
	/*
	 * ��һ��ʼ�뵽�ķ�����
	 * ���е�����ӵ�һ�� List �У�Ȼ������Ȼ��˫ָ��
	 * 
	 * ������������� BST �Ļ���ֱ����������Ϳ��Եõ����������
	 * 
	 * ----------
	 * ������л�������һ������
	 * ����һ�� HashMap
	 * ������ <k-x, k-x�Ƿ����>
	 * ����ֻ��Ҫһ�� dfs���Ϳ��Ա���ӱ�����
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
