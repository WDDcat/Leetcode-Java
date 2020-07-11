
public class _101_Symmetric_Tree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * public boolean isSymmetric(TreeNode root) { if(root == null) return true;
	 * return isLeftEqualsRight(root.left, root.right); }
	 * 
	 * public boolean isLeftEqualsRight(TreeNode left, TreeNode right) { if(left ==
	 * null && right == null) return true; if(left == null || right == null) return
	 * false; return left.val == right.val && isLeftEqualsRight(left.right,
	 * right.left) && isLeftEqualsRight(left.left, right.right); }
	 */
	
	/*
	 * 	����ķ���ʱ��һ��ʼ�뵽�ĵݹ鷽��������
	 * 	���������Һ��� == ������������
	 * 	������������ == ���������к���
	 * 	ֻ��ά��������ϵ���ɡ�
	 * 
	 * 	Ȼ����ʱ�ո��Ӷȶ��ø�
	 * 	����������﷢����һ���߼�����������
	 * 	��תroot�ڵ���������Լ�������
	 * 	Ȼ���ж����������������ǲ�����ȫһ�¾Ϳ�����
	 * 
	 * 	������ִ��ʱ���������0ms
	 * 	��֪��Ϊɶ
	 * */

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		reverseTree(root.left);
		return isEqual(root.left, root.right);
	}

	void reverseTree(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		reverseTree(root.left);
		reverseTree(root.right);
	}

	boolean isEqual(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		return left.val == right.val && isEqual(left.left, right.left) && isEqual(left.right, right.right);
	}
}
