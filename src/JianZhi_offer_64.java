
public class JianZhi_offer_64 {
	public int sumNums(int n) {
//		return n == 0 ? 0 : n + sumNums(n - 1);
		
		/*
		 * 	又是一道知识复习题
		 * 	一开始想到的方法就是递归，但没有办法判断递归的结束位置
		 * 	
		 * 	然后题解里告诉我利用逻辑运算符的短路性质
		 * 	即 A && B时，如果A已经是false，则不回去执行B的内容
		  */
		
		Boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
		return n;
    }
}
