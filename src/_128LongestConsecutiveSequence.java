import java.util.HashSet;
import java.util.Set;

public class _128LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		
		/*
		 * 	一看就会，一做就废
		 * 	
		 * 	道理我都懂，就是不会做
		 * 	
		 * 	通过remove这种方法可以减少重复查询
		 *	也就是如果2345连着的话
		 *	查过2后删除了345
		 *	这样就不会再通过3探索到245
		 *	这样可以省略很多时间
		 **/
		
		Set<Integer> numsSet = new HashSet<>();
        for (Integer num : nums) {
            numsSet.add(num);
        }
        int longest = 0;
        for (Integer num : nums) {
            if (numsSet.remove(num)) {
                // 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
                int currentLongest = 1;
                int current = num;
                while (numsSet.remove(current - 1)) current--;
                currentLongest += (num - current);
                // 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
                current = num;
                while(numsSet.remove(current + 1)) current++;
                currentLongest += (current - num);
                // 搜索完后更新longest.
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }
}
