package general_0500_0599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _599_Minimum_Index_Sum_of_Two_Lists {
	
	
	/*
	 * 我又在评论区里找到了一个有意思的解法
	 * */
	public String[] findRestaurant(String[] list1, String[] list2) {
		return IntStream.range(0, list1.length + list2.length)
	            .boxed()
	            .collect(Collectors.groupingBy(i -> i < list1.length ? list1[i] : list2[i - list1.length]))
	            .entrySet()
	            .stream()
	            .filter(entry -> entry.getValue().size() == 2)
	            .collect(Collectors.groupingBy(entry -> entry.getValue().get(0) + entry.getValue().get(1), TreeMap::new, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
	            .values()
	            .iterator()
	            .next()
	            .toArray(new String[0]);
	}
	
	/*
	 * 之所以有下面的方法，是因为我想到了HashMap，但是没想到怎么使用它能够存储<单词首字母,索引值,整个单词>
	 * 后来又想了想直接把存储成 <单词,索引值> 就好了
	 * 所以就有了第二个方法
	 * 
	 * 这个方法用时比较短，但是内存消耗还是挺高的
	 * */
	
//	public String[] findRestaurant(String[] list1, String[] list2) {
//		
//		Map<String, Integer> map = new HashMap<>();
//		int minIndexSum = Integer.MAX_VALUE;
//		List<String> ans = new ArrayList<String>();
//		
//		for(int i = 0; i < list1.length; i++) {
//			map.put(list1[i], i);
//		}
//		for(int i = 0; i < list2.length; i++) {
//			if(map.containsKey(list2[i])) {
//				int sum = map.get(list2[i]) + i;
//				if(sum < minIndexSum) {
//					ans.clear();
//					ans.add(list2[i]);
//					minIndexSum = sum;
//				} else if(sum == minIndexSum) {
//					ans.add(list2[i]);
//				}
//			}
//		}
//		return ans.toArray(new String[ans.size()]);	
//	}

	/*
	 * 1. 建立一个像字典一样的以首字母开头的查询表
	 * 		[A, B, C, D, ...., K, ...]
	 *     		Burger King    KFC
	 * 2. 为了记录索引,我把添加进去的单词后面 加了一个 ",n" // n为在列表中的索引值
	 * 		[A, B, C, D, ...., K, ...]
	 *     		Burger King,2  KFC,1
	 * 3. 然后再从另一个表里面去查字典就行了
	 * */
	
//	public String[] findRestaurant(String[] list1, String[] list2) {
//		
//		List<String>[] indexList = new ArrayList[26];
//		int minIndexSum = Integer.MAX_VALUE;
//		List<String> ans = new ArrayList<String>();
//		
//		// 1.
//		for(int i = 0; i < 26; i++) {
//			indexList[i] = new ArrayList<>();
//		}
//		
//		for(int i = 0; i < list1.length; i++) {
//			indexList[(int) list1[i].toUpperCase().charAt(0) - 65].add(list1[i] + "," + i);//2.
//		}
//		
//		//3.
//		for(int i = 0; i < list2.length; i++) {
//			int n = (int) list2[i].toUpperCase().charAt(0) - 65;
//			if(indexList[n].isEmpty()) continue;
//			for(String c : indexList[n]) {
//				String[] split = c.split(",");
//				if(split[0].equals(list2[i])) {
//					int sum = i + Integer.valueOf(split[1]);
//					if(sum < minIndexSum) {
//						ans.clear();
//						ans.add(list2[i]);
//						minIndexSum = sum;
//					} else if(sum == minIndexSum) {
//						ans.add(list2[i]);
//					}
//				}
//			}
//		}
//		return ans.toArray(new String[ans.size()]);		
//    }
}
