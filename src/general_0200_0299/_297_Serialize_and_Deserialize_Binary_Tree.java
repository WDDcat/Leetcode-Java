package general_0200_0299;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import base.TreeNode;

public class _297_Serialize_and_Deserialize_Binary_Tree {

	/*
	 * 	����DFS����
	 * 	�������Ҫ���������Ҫ���������Ҫ
	 * 	�Ⱥ󿴴������㣺
	 * 	1. ���л���˳�����������һ��
	 * 	2.���л��ĸ�ʽ��һ��
	 * 	
	 * 	ȥ��������Ҫ����DFS����BFS����
	 * 	����Ƚϼ򵥵ĵݹ��
	 * 	��һ��null���жϾͺ���
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

	private String Encode(TreeNode n) {
		if (n == null) {
			return "null";
		}
		String s = String.valueOf(n.val);
		s += "," + Encode(n.left);
		s += "," + Encode(n.right);
		return s;
	}

	private TreeNode Decode(List<String> list) {
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
