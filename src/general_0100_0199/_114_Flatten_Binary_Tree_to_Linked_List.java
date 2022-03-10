package general_0100_0199;

import base.TreeNode;

public class _114_Flatten_Binary_Tree_to_Linked_List {

	/*
	 * 	��ε��ⲻ��Ҫ����ֵ����˼·��ݹ�Ҳ����
	 * 	��һ��������չ�������������ListȻ�����������ķ�ʽ�����Ǵ�����
	 * 	
	 * 	��Ų������
	 * 	�ݹ�չ��
	 * 	�� ����������׶� .right = root.right
	 * 	�� root.right = root.left
	 * 	�� root.left = null
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
