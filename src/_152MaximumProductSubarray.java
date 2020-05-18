import java.lang.Math;

public class _152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        /*int result = nums[0];		//	-4
    	for(int i = 1; i <= nums.length; i++) {		//i = 1
    		for(int j = 0; j <= nums.length - i; j++) {		//j = 0
    			int muti = nums[j];				//muti = -4
    			for(int k = 1; k < i; k++) {	//k = 1
    				muti *= nums[j+k];
    			}
    			if(muti > result) result = muti;
    		}
    	}*///我能想出来的复杂度很高的实现方法，有时间可尝试优化
    	
    	int max = Integer.MIN_VALUE;
    	int imax= 1, imin= 1;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] < 0) {	//如果下一个值为负数，那么会导致与最大值相乘后变成最小的，与最小值相乘后变为最大的
    			int temp = imax;
    			imax = imin;
    			imin = temp;
    		}
    		imax = Math.max(imax*nums[i], nums[i]);
    		imin = Math.min(imin*nums[i], nums[i]);
    		
    		max = Math.max(max, imax);
    	}
    	return max;
    }
}
