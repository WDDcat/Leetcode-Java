package general_1400_1499;
import java.util.ArrayList;
import java.util.List;

public class _1431_Kids_With_the_Greatest_Number_of_Candies {
	
	/*
	 * 	�������ü�
	 * 	ûɶ��˵�ģ���һ����
	 * 	�͸�С���ѵ���~
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
