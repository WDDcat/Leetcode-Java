package jian_zhi;
import java.util.Stack;

public class JianZhi_Offer_09 {
	
	/*
	 * 	这个题在我知道力扣之前就有做过
	 * 	就像两个杯子来回倒嘛
	 * 	需要做那种操作就移到哪个杯子里去
	 * */
	
	private Stack<Integer> appendStack = new Stack<>();
	private Stack<Integer> deleteStack = new Stack<>();
	private boolean append = true;

	public void appendTail(int value) {
		if (!append) {
			delete2append();
		}
		append = true;
		appendStack.add(value);
	}

	public int deleteHead() {
		if (append) {
			append2delete();
		}
		append = false;
		return deleteStack.isEmpty() ? -1 : deleteStack.pop();
	}

	private void append2delete() {
		while (!appendStack.isEmpty()) {
			deleteStack.add(appendStack.pop());
		}
	}

	private void delete2append() {
		while (!deleteStack.isEmpty()) {
			appendStack.add(deleteStack.pop());
		}
	}
}
