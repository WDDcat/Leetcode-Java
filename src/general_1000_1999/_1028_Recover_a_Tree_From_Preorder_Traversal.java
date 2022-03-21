package general_1000_1999;

import base.TreeNode;

public class _1028_Recover_a_Tree_From_Preorder_Traversal {

	/*
	 * 	��ȫ��û����⣡�Լ���ɣ�������Ŀ��
	 * 	Ψһ�����һ���ǻ����õ���ȫ�ֱ���������ʱ�ղ��Ǻ��Ÿо�
	 * 
	 * 	�ݹ飬����ݹ���Ȳ���
	 * 	
	 * 	��������������
	 * 	���ڵ����ȵ�����ǰ�桡���������ĸ���
	 * 	���������ȡ����������������ĸ���������return null
	 * 	����Ҫ��s���в�⣬����root.left �� root.right ֮���¼�仯��s
	 * 	��������ȫ�ֱ���
	 * 	
	 * 	�뵽һ�ְ취�����ǵݹ��ʱ���¼s����ʼλ�ã�Ȼ����subString���Ϳ���ʡȥȫ�ֱ���
	 * */
	
	private String str;

	public TreeNode recoverFromPreorder(String S) {
		str = S;
		return madeATree(0);
	}

	private TreeNode madeATree(int depth) {
		if (str.length() == 0)
			return null;
		System.out.println("depth " + depth + ": " + str);
		for (int i = 0; i < depth; i++) {
			if (str.charAt(i) != '-') {
				return null;
			}
		}
		str = str.substring(depth, str.length());

		System.out.println("s after process:" + str);
		int num = 0;
		while (str.length() > 0 && str.charAt(0) != '-') {
			num = num * 10 + Integer.valueOf(str.charAt(0) - 48);
			str = str.substring(1, str.length());
		}
		System.out.println("num after process:" + num);
		TreeNode root = new TreeNode(num);

		root.left = madeATree(depth + 1);

		root.right = madeATree(depth + 1);
		return root;
	}
}