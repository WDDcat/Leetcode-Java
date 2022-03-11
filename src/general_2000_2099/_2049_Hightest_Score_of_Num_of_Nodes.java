package general_2000_2099;

import java.util.ArrayList;
import java.util.List;

public class _2049_Hightest_Score_of_Num_of_Nodes {
	
	/*
	 * 需要建立一个 children 列表维护子节点的位置
	 * children<
	 * 		0 --> {leftNode, rightNode}
	 * 		1 --> {leftNode, rightNode}
	 * >
	 * 
	 * 一棵二叉树去掉一个节点后可以被拆成3个子树
	 * 左子树、右子树、还有一个包含父节点的树
	 * - 左右子树可以用递归的方式计算节点个数
	 * - 包含父节点的树可以用 n - left - right - 1 计算
	 * 
	 * 我这个方法除了一些小问题，但数据量太大了，也不好查错，先用题解打了卡，明天再琢磨琢磨
	 * 
	 * 题解中给出了一个dfs的方法，但我简单看了一下没看明白，日后再研究
	 * */
	
	int length;
	List<Integer>[] children;
	long max = -1;
	int cnt = 0;
	
	public int countHighestScoreNodes(int[] parents) {
		
		// 数据预处理
		length = parents.length;
		children = new List[length];
		for (int i = 0; i < length; i++) {
            children[i] = new ArrayList<Integer>();
        }
		for(int i = 0; i < length; i++) {
			int p = parents[i];
			if(p != -1) {
				children[p].add(i);
			}
		}
		
		for(int i = 0; i < parents.length; i++) {
			int left = 0, right = 0;
			if(children[i].size() > 0) {
				left = getCount(children[i].get(0));
			}
			if(children[i].size() > 1) {
				right = getCount(children[i].get(1));
			}
			int parent = length - 1 - left - right;
			if(left == 0) left = 1;
			if(right == 0) right = 1;
			if(parent == 0) parent = 1;
			long score = left * right * parent;
			System.out.println(i + ":" + left + "*" + right + "*" + parent + "=" + score);
			
			if(score > max) {
				max = score;
				cnt = 1;
			} else if(score == max) {
				cnt++;
			}
		}
		
		return cnt;
    }
	
	private int getCount(int node) {
		int count = 1;
		for(int i : children[node]) {
			count += getCount(i);
		}
		return count;
	}
}
