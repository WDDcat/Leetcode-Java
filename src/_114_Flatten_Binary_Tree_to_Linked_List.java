
public class _114_Flatten_Binary_Tree_to_Linked_List {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public void flatten(TreeNode root) {
		
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
