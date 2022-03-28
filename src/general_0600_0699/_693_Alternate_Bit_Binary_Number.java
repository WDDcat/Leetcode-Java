package general_0600_0699;

public class _693_Alternate_Bit_Binary_Number {
	
	/*
	 * 又学到了一个新方法
	 * 假设 n 的二进制数是   1010101b
	 * n >> 1 就是       0101010b
	 * m = n + n>>1 就是 1111111b
	 * 
	 * 如何判断这个结果 m 是否满足全 1
	 *     m =   01111111b
	 * m + 1 =   10000000b
	 * m & m+1 = 00000000b
	 */
	
	public boolean hasAlternatingBits(int n) {
        int m = n ^ (n >> 1);
        return (m & (m + 1)) == 0;
    }
	
//	/*
//	 * 不断除2，然后记录上一次除2的结果
//	 * 我这里用了 (double) n / 2.0 和 n / 2 来判断除2之后的余数
//	 * 【本来这题都准备push了 突然想到 代码里有 % 取余的形式，我zz了】
//	 * */
//	
//	public boolean hasAlternatingBits(int n) {
//		int last = -1;
//		while(n > 0) {
//			if((double) n / 2.0 == n / 2) {
//				if(last == 0) return false;
//				last = 0;
//			} else {
//				if(last == 1) return false;
//				last = 1;
//			}
//			n /= 2;
//		}
//		return true;
//    }
}
