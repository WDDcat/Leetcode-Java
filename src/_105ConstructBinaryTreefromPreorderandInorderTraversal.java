import java.util.HashMap;
import java.util.Map;

public class _105ConstructBinaryTreefromPreorderandInorderTraversal {
//	Definition for a binary tree node.
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/*
	 * 	���ݽṹ�����⣬����һ�㶼��д���������ṹ���⻹�ǵ�һ���ô���ʵ�֡�
	 * 	����Ŀ��������		preorder = [3,9,20,15,7]
	 *					inorder = [9,3,15,20,7]
	 *	ǰ���������ʽ�ǣ�[ ���ڵ� ,  [ ��������ǰ�������� ] ,  [ ��������ǰ�������� ]  ]
	 *	�����������ʽ�ǣ�[  [ ������������������ ] ,  ���ڵ� ,  [ ������������������ ]  ]
	 *	1. preorder�еĵ�һ��Ԫ��һ���Ǹ��ڵ�
	 *	2. inorder����preordre�е�һ��Ԫ����ͬ��Ԫ�����Ϊ�˸��ڵ�����������ݣ��Ҳ�Ϊ���������ݡ�
	 *	
	 *	�ݹ�ʵ�ּ��ɡ�
	 *	
	 *	P.S. ����ѧϰ��һ����֪ʶ
	 *	��ʵ�ִ�������Ѱ��ĳһֵ����λ��ʱ����ѭ�����������Ӷ�ΪO(n)��ʹ��O(1)��ʱ���Ӷ�Ӱ�첻��ܴ󣬵���ʹ�ø��ӶȽϴ�ʱ�ᱶ�����Ӹ��Ӷȡ�
	 *	����ʹ������HashMap�࣬�������Թ�ϣ�����ʽ�洢��������ʹ�����е�get������ȡֵ����Ӧ��λ�ã��ܹ�����С�临�Ӷȡ�
	 **/
	
	private Map<Integer, Integer> indexMap;
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		
		indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
		return myBuildTree(preorder, inorder, 0 , n - 1, 0, n - 1);
	}
	
	private TreeNode myBuildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
		if(preStart > preEnd) return null;
		TreeNode root = new TreeNode(preorder[preStart]); 
		
		int rootInInorder = indexMap.get(preorder[preStart]);
		int leftTreeLength = rootInInorder - inStart;
		
		root.left = myBuildTree(preorder, inorder, preStart + 1, preStart + leftTreeLength, inStart, rootInInorder - 1);
		root.right = myBuildTree(preorder, inorder, preStart + leftTreeLength + 1, preEnd, rootInInorder + 1, inEnd);
		
		return root;
	}
	
	
	/*
	 * 	�������֮������һ��������·�����
	 * 	����                3               Ϊ��
       		   / \                           ��
      		  9  20              preorder = [3, 9, 8, 5, 4, 10, 20, 15, 7]
     		 /  /  \             inorder = [4, 5, 8, 10, 9, 3, 15, 20, 7]
    		8  15   7                       ��
           / \                            index
          5  10
         /
        4
     *	 ��һ��ջ stack ��ά������ǰ�ڵ�����л�û�п��ǹ��Ҷ��ӵ����Ƚڵ㡹��ջ�����ǵ�ǰ�ڵ㡣
     *	1. �������ǽ����ڵ� 3 ��ջ���ٳ�ʼ�� index ��ָ��Ľڵ�Ϊ 4��������ǰ������е�ÿ���ڵ㣬���������ж�����ջ���ڵ������ӣ�����ջ��ĳ���ڵ���Ҷ��ӡ�
     *	
     *	�������Ǳ��� 9��9 һ����ջ���ڵ� 3 ������ӡ�����ʹ�÷�֤�������� 9 �� 3 ���Ҷ��ӣ���ô 3 û������ӣ�index Ӧ��ǡ��ָ�� 3����ʵ����Ϊ 4����˲�����ì�ܡ��������ǽ� 9 ��Ϊ 3 ������ӣ����� 9 ��ջ��      -->stack = [3, 9]
     *	�������Ǳ��� 8��5 �� 4��ͬ��ɵ����Ƕ�����һ���ڵ㣨ջ���ڵ㣩������ӣ��������ǻ�������ջ��																		-->stack = [3, 9, 8, 5, 4]
     *	�������Ǳ��� 10����ʱ����Ͳ�һ���ˡ����Ƿ��� index ǡ��ָ��ǰ��ջ���ڵ� 4��Ҳ����˵ 4 û������ӣ���ô 10 ����Ϊջ��ĳ���ڵ���Ҷ��ӡ�																		
     *	����������ǿ��԰� index ���������ƶ�������ջ���ڵ���бȽϡ���� index ��Ӧ��Ԫ��ǡ�õ���ջ���ڵ㣬��ô˵������������������ҵ���ջ���ڵ㣬���Խ� index ���� 1 ������ջ���ڵ㣬ֱ�� index ��Ӧ��Ԫ�ز�����ջ���ڵ㡣
     *	�������δ�ջ������ 4��5 �� 8�����ҽ� index �����ƶ������Ρ����ǽ� 10 ��Ϊ��󵯳��Ľڵ� 8 ���Ҷ��ӣ����� 10 ��ջ��														-->stack = [3, 9, 10]  index -> inorder[3] = 10
     *	֮��ͬ��
        */
}

