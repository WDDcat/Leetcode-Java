package general_0100_0199;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _126_Word_Ladder_II {
	private static final int INF = 1 << 20;
	private Map<String, Integer> wordId = new HashMap<>();; // ���ʵ�id��ӳ��
	private ArrayList<String> idWord = new ArrayList<>();; // id�����ʵ�ӳ��
	private ArrayList<Integer>[] edges; // ͼ�ı�

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		int id = 0;
		// ��wordList���е��ʼ���wordId�� ��ͬ��ֻ����һ��
		// ��Ϊÿһ�����ʷ���һ��id
		for (String word : wordList) {
			if (!wordId.containsKey(word)) {
				wordId.put(word, id++);
				idWord.add(word);
			}
		}

		// ��endWord����wordList�� ���޽�
		if (!wordId.containsKey(endWord)) {
			return new ArrayList<>();
		}

		// ��beginWordҲ����wordId��
		if (!wordId.containsKey(beginWord)) {
			wordId.put(beginWord, id++);
			idWord.add(beginWord);
		}

		// ��ʼ������õ�����
		edges = new ArrayList[idWord.size()];
		for (int i = 0; i < idWord.size(); i++) {
			edges[i] = new ArrayList<>();
		}

		// ��ӱ�
		for (int i = 0; i < idWord.size(); i++) {
			for (int j = 0; j < idWord.size(); j++) {
				if (transformCheck(idWord.get(i), idWord.get(j))) {
					edges[i].add(j);
					edges[j].add(i);
				}
			}
		}

		int dest = wordId.get(endWord); // Ŀ��ID
		List<List<String>> res = new ArrayList<>(); // ���
		int[] cost = new int[id]; // ��ÿ����Ĵ���
		for (int i = 0; i < id; i++) {
			cost[i] = INF; // ÿ����Ĵ��۳�ʼ��Ϊ�����
		}

		Queue<ArrayList<Integer>> q = new LinkedList<>();
		ArrayList<Integer> tmpBegin = new ArrayList<>();
		tmpBegin.add(wordId.get(beginWord));
		q.add(tmpBegin);

		cost[wordId.get(beginWord)] = 0;

		while (!q.isEmpty()) {
			ArrayList<Integer> now = q.poll();
			int last = now.get(now.size() - 1); // ������ʵĵ�
			if (last == dest) { // ���õ�Ϊ�յ���������res��
				ArrayList<String> tmp = new ArrayList<>();
				for (int index : now) {
					tmp.add(idWord.get(index)); // ת��Ϊ��Ӧ��word
				}
				res.add(tmp);
			} else { // �õ㲻Ϊ�յ� ��������
				for (int i = 0; i < edges[last].size(); i++) {
					int to = edges[last].get(i);
					// �˴�<=Ŀ�����ڰѴ�����ͬ�Ĳ�ͬ·��ȫ����������
					if (cost[last] + 1 <= cost[to]) {
						cost[to] = cost[last] + 1;
						// ��to����·����
						ArrayList<Integer> tmp = new ArrayList<>(now);
						tmp.add(to);
						q.add(tmp); // �����·���������
					}
				}
			}
		}
		return res;
	}

//	Boolean transformCheck(String str1, String str2) {
//		boolean same = true;
//		for(int i = 0; i < str1.length(); i++) {
//			if(str1.charAt(i) != str2.charAt(i)) {
//				if(same) same = false;
//				else return false;
//			}
//		}
//		return !same;
//	}
	private boolean transformCheck(String str1, String str2) {
		int differences = 0;
		for (int i = 0; i < str1.length() && differences < 2; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				++differences;
			}
		}
		return differences == 1;
	}
}
