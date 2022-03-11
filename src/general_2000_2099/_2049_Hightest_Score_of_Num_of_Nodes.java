package general_2000_2099;

import java.util.ArrayList;
import java.util.List;

public class _2049_Hightest_Score_of_Num_of_Nodes {
	
	/*
	 * ��Ҫ����һ�� children �б�ά���ӽڵ��λ��
	 * children<
	 * 		0 --> {leftNode, rightNode}
	 * 		1 --> {leftNode, rightNode}
	 * >
	 * 
	 * һ�ö�����ȥ��һ���ڵ����Ա����3������
	 * ��������������������һ���������ڵ����
	 * - �������������õݹ�ķ�ʽ����ڵ����
	 * - �������ڵ���������� n - left - right - 1 ����
	 * 
	 * �������������һЩС���⣬��������̫���ˣ�Ҳ���ò�����������˿�����������ĥ��ĥ
	 * 
	 * ����и�����һ��dfs�ķ��������Ҽ򵥿���һ��û�����ף��պ����о�
	 * */
	
	int length;
	List<Integer>[] children;
	long max = -1;
	int cnt = 0;
	
	public int countHighestScoreNodes(int[] parents) {
		
		// ����Ԥ����
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
