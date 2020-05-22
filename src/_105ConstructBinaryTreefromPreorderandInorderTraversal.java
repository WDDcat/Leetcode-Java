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
	 * 	数据结构常考题，不过一般都是写出二叉树结构，这还是第一次用代码实现。
	 * 	以题目用例分析		preorder = [3,9,20,15,7]
	 *					inorder = [9,3,15,20,7]
	 *	前序遍历的形式是：[ 根节点 ,  [ 左子树的前序遍历结果 ] ,  [ 右子树的前序遍历结果 ]  ]
	 *	中序遍历的形式是：[  [ 左子树的中序遍历结果 ] ,  根节点 ,  [ 右子树的中序遍历结果 ]  ]
	 *	1. preorder中的第一个元素一定是根节点
	 *	2. inorder中与preordre中第一个元素相同的元素左侧为此根节点的左子树内容，右侧为右子树内容。
	 *	
	 *	递归实现即可。
	 *	
	 *	P.S. 这里学习了一个新知识
	 *	在实现从数组中寻找某一值所在位置时，若循环遍历，则复杂度为O(n)，使用O(1)次时复杂度影响不会很大，但当使用复杂度较大时会倍数增加复杂度。
	 *	这里使用了了HashMap类，将数组以哈希表的形式存储起来，再使用其中的get函数获取值所对应的位置，能够大大减小其复杂度。
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
	 * 	看了题解之后发现了一个很妙的新方法：
	 * 	以树                3               为例
       		   / \                           ↓
      		  9  20              preorder = [3, 9, 8, 5, 4, 10, 20, 15, 7]
     		 /  /  \             inorder = [4, 5, 8, 10, 9, 3, 15, 20, 7]
    		8  15   7                       ↑
           / \                            index
          5  10
         /
        4
     *	 用一个栈 stack 来维护「当前节点的所有还没有考虑过右儿子的祖先节点」，栈顶就是当前节点。
     *	1. 首先我们将根节点 3 入栈，再初始化 index 所指向的节点为 4，随后对于前序遍历中的每个节点，我们依此判断它是栈顶节点的左儿子，还是栈中某个节点的右儿子。
     *	
     *	··我们遍历 9。9 一定是栈顶节点 3 的左儿子。我们使用反证法，假设 9 是 3 的右儿子，那么 3 没有左儿子，index 应该恰好指向 3，但实际上为 4，因此产生了矛盾。所以我们将 9 作为 3 的左儿子，并将 9 入栈。      -->stack = [3, 9]
     *	··我们遍历 8，5 和 4。同理可得它们都是上一个节点（栈顶节点）的左儿子，所以它们会依次入栈。																		-->stack = [3, 9, 8, 5, 4]
     *	··我们遍历 10，这时情况就不一样了。我们发现 index 恰好指向当前的栈顶节点 4，也就是说 4 没有左儿子，那么 10 必须为栈中某个节点的右儿子。																		
     *	··因此我们可以把 index 不断向右移动，并与栈顶节点进行比较。如果 index 对应的元素恰好等于栈顶节点，那么说明我们在中序遍历中找到了栈顶节点，所以将 index 增加 1 并弹出栈顶节点，直到 index 对应的元素不等于栈顶节点。
     *	··依次从栈顶弹出 4，5 和 8，并且将 index 向右移动了三次。我们将 10 作为最后弹出的节点 8 的右儿子，并将 10 入栈。														-->stack = [3, 9, 10]  index -> inorder[3] = 10
     *	之后同理。
        */
}

