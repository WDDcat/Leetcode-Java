import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _297_Serialize_and_Deserialize_Binary_Tree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * 	经典DFS解题
	 * 	审题很重要，审题很重要，审题很重要
	 * 	先后看错了两点：
	 * 	1. 序列化的顺序需与给定的一致
	 * 	2.序列化的格式需一致
	 * 	
	 * 	去除这两点要求，用DFS或者BFS均可
	 * 	还算比较简单的递归吧
	 * 	做一下null的判断就好了
	 * */
	
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return Encode(root);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] dataArray = data.split(",");
		List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
		return Decode(dataList);
	}

	String Encode(TreeNode n) {
		if (n == null) {
			return "null";
		}
		String s = String.valueOf(n.val);
		s += "," + Encode(n.left);
		s += "," + Encode(n.right);
		return s;
	}

	TreeNode Decode(List<String> list) {
		if (list.get(0).equals("null")) {
			list.remove(0);
			System.out.println(list);
			return null;
		}

		TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
		list.remove(0);
		System.out.println(list);
		root.left = Decode(list);
		root.right = Decode(list);
		return root;
	}
}
