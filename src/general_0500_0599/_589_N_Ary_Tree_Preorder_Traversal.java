package general_0500_0599;

import java.util.ArrayList;
import java.util.List;

import base.Node;

public class _589_N_Ary_Tree_Preorder_Traversal {
	
	/*
	 * ǰ�������ûɶ��˵���˰�
	 * */
	
	public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        return preorderTree(root, list);
    }
	
	private List<Integer> preorderTree(Node root, List<Integer> list) {
		if(root.children == null) return list;
		list.add(root.val);
		for (Node node : root.children) {
			preorderTree(node, list);
		}
		return list;
	}
}
