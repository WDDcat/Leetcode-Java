package general_0100_0199;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _126_Word_Ladder_II {
	private static final int INF = 1 << 20;
	private Map<String, Integer> wordId = new HashMap<>();; // 单词到id的映射
	private ArrayList<String> idWord = new ArrayList<>();; // id到单词的映射
	private ArrayList<Integer>[] edges; // 图的边

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		int id = 0;
		// 将wordList所有单词加入wordId中 相同的只保留一个
		// 并为每一个单词分配一个id
		for (String word : wordList) {
			if (!wordId.containsKey(word)) {
				wordId.put(word, id++);
				idWord.add(word);
			}
		}

		// 若endWord不在wordList中 则无解
		if (!wordId.containsKey(endWord)) {
			return new ArrayList<>();
		}

		// 把beginWord也加入wordId中
		if (!wordId.containsKey(beginWord)) {
			wordId.put(beginWord, id++);
			idWord.add(beginWord);
		}

		// 初始化存边用的数组
		edges = new ArrayList[idWord.size()];
		for (int i = 0; i < idWord.size(); i++) {
			edges[i] = new ArrayList<>();
		}

		// 添加边
		for (int i = 0; i < idWord.size(); i++) {
			for (int j = 0; j < idWord.size(); j++) {
				if (transformCheck(idWord.get(i), idWord.get(j))) {
					edges[i].add(j);
					edges[j].add(i);
				}
			}
		}

		int dest = wordId.get(endWord); // 目的ID
		List<List<String>> res = new ArrayList<>(); // 存答案
		int[] cost = new int[id]; // 到每个点的代价
		for (int i = 0; i < id; i++) {
			cost[i] = INF; // 每个点的代价初始化为无穷大
		}

		Queue<ArrayList<Integer>> q = new LinkedList<>();
		ArrayList<Integer> tmpBegin = new ArrayList<>();
		tmpBegin.add(wordId.get(beginWord));
		q.add(tmpBegin);

		cost[wordId.get(beginWord)] = 0;

		while (!q.isEmpty()) {
			ArrayList<Integer> now = q.poll();
			int last = now.get(now.size() - 1); // 最近访问的点
			if (last == dest) { // 若该点为终点则将其存入答案res中
				ArrayList<String> tmp = new ArrayList<>();
				for (int index : now) {
					tmp.add(idWord.get(index)); // 转换为对应的word
				}
				res.add(tmp);
			} else { // 该点不为终点 继续搜索
				for (int i = 0; i < edges[last].size(); i++) {
					int to = edges[last].get(i);
					// 此处<=目的在于把代价相同的不同路径全部保留下来
					if (cost[last] + 1 <= cost[to]) {
						cost[to] = cost[last] + 1;
						// 把to加入路径中
						ArrayList<Integer> tmp = new ArrayList<>(now);
						tmp.add(to);
						q.add(tmp); // 把这个路径加入队列
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
