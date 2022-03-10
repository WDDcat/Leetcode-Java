package general_1400_1499;
import java.util.ArrayList;
import java.util.List;

public class _1431_Kids_With_the_Greatest_Number_of_Candies {
	
	/*
	 * 	今天的题好简单
	 * 	没啥可说的，六一快乐
	 * 	送给小朋友的题~
	 * */
	
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int max = 0;
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] > max)
				max = candies[i];
		}

		List<Boolean> ans = new ArrayList<>();
		int limit = max - extraCandies;
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] >= limit)
				ans.add(true);
			else
				ans.add(false);
		}
		return ans;
	}
}
