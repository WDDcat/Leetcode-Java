
public class _287FindtheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		if(nums.length <= 2){
            return nums[0];
        }
		
		int i = 0,j = 0;
		while(true){
            i = nums[i];
            j = nums[nums[j]];
            if(i == j) break;
        }
		
		i = 0;
        while(true){
            i = nums[i];
            j = nums[j];
            if(i == j) break;
        }
        return i;
	}
}
