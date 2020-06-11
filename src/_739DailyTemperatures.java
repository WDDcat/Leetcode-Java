import java.util.ArrayList;
import java.util.List;

public class _739DailyTemperatures {
	class Union{
		int pos;
		int num;
		Union(int p, int n) {
			pos = p;
			num = n;
		}
	}
	
	public int[] dailyTemperatures(int[] T) {
		
		/*
		 * 	自己想出来的方法
		 * 	用一个union存储未找到更高温度的位置和温度值
		 * 	
		 * 	遍历数组，i<i+1时就把ans[i] = 1
		 * 	如果不能确定就放进一个待处理的List中
		 * 	每次遍历完一个数，检查待处理list是不是有值
		 * 	有的话，遍历一遍把小于当前数的都拿出来位置做减法存进去
		 * 
		 * 	然后发现测试用例中一个[76,76,...,76,76]
		 * 	就又加了一个bool的raise，
		 * 	当温度递增时是true
		 * 	这样只有下一个数更高时才会遍历待处理项
		 * 	如果没有更高的话，说明更高的值都无法满足，这个值肯定也不行
		 * */
		
		boolean raise = false;
		List<Union> unpredict = new ArrayList<>();
		int[] ans = new int[T.length];
		
		for(int i = 1; i < T.length; i++) {
			if(T[i] > T[i-1]) {
				ans[i-1] = 1;
				raise = true;
			}
			else {
				Union union = new Union(i-1, T[i-1]);
				unpredict.add(union);
				raise = false;
			}
			if(unpredict.size() > 0 && raise) {
				System.out.println(i + " in");
				for(int j = 0; j < unpredict.size(); j++) {
					if(T[i] > unpredict.get(j).num) {
						System.out.println(T[i] + " > " + unpredict.get(j).num);
						ans[unpredict.get(j).pos] = (i - unpredict.get(j).pos);
						System.out.println("ans[" + unpredict.get(j).pos + "] = " + (i - unpredict.get(j).pos));
						unpredict.remove(j--);
					}
				}
			}
		}
		ans[T.length - 1] = 0;
		for(int i = 0; i < unpredict.size(); i++) {
			ans[unpredict.get(i).pos] = 0;
		}
		return ans;
    }
	
	void print(List<Union> list) {
		System.out.print("[");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).pos + ":" + list.get(i).num + " -> ");
		}
		System.out.println("]");
	}
}

/*
 * 
0
[]
1
[]
2
[2:75 -> ]
in
3
[2:75 -> 3:71 -> ]
in
4
[2:75 -> 3:71 -> ]
in
5
[2:75 -> 3:71 -> ]
in
72 > 71
6
[2:75 -> 3:71 -> 6:76 -> ]
in
76 > 75
76 > 71

 * 
 * 
 * */
