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
    	}*///����������ĸ��ӶȺܸߵ�ʵ�ַ�������ʱ��ɳ����Ż�
    	
    	int max = Integer.MIN_VALUE;
    	int imax= 1, imin= 1;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] < 0) {	//�����һ��ֵΪ��������ô�ᵼ�������ֵ��˺�����С�ģ�����Сֵ��˺��Ϊ����
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
