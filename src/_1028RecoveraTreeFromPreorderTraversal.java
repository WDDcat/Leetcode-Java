
public class _1028RecoveraTreeFromPreorderTraversal {
	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	/*
	 * 	完全！没看题解！自己完成！困难题目！
	 * 	唯一不足的一点是还是用到了全局变量，而且时空不是很优感觉
	 * 
	 * 	递归，传入递归深度参数
	 * 	
	 * 	“１－２－３”
	 * 	树节点的深度等于他前面　‘－’　的个数
	 * 	所以如果深度　！＝　‘－’　的个数，　就return null
	 * 	但需要对s进行拆解，并在root.left 和 root.right 之间记录变化的s
	 * 	就添加了全局变量
	 * 	
	 * 	想到一种办法，就是递归的时候记录s的起始位置，然后做subString，就可以省去全局变量
	 * */
	
	String str;
	
	public TreeNode recoverFromPreorder(String S) {
		str = S;
		return madeATree(0);
    }
	
	TreeNode madeATree(int depth) {
		if(str.length() == 0) return null;
		System.out.println("depth " + depth + ": " + str);
		for(int i = 0; i < depth; i++) {
			if(str.charAt(i) != '-') {
				return null;
			}
		}
		str = str.substring(depth, str.length());
		
		System.out.println("s after process:" + str);
		int num = 0;
		while(str.length() > 0 && str.charAt(0) != '-') {
			num = num * 10 + Integer.valueOf(str.charAt(0) - 48);
			str = str.substring(1, str.length());
		}
		System.out.println("num after process:" + num);
		TreeNode root = new TreeNode(num);
		
		root.left = madeATree(depth + 1);
		
		root.right = madeATree(depth + 1);
		return root;
	}
}
