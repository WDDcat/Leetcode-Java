import java.util.Stack;

public class JianZhi_Offer_09 {
	
	/*
	 * 	这个题在我知道力扣之前就有做过
	 * 	就像两个杯子来回倒嘛
	 * 	需要做那种操作就移到哪个杯子里去
	 * */
	
	Stack<Integer> appendStack = new Stack<>();
	Stack<Integer> deleteStack = new Stack<>();
	boolean append = true;
	
	public JianZhi_Offer_09() {
		
    }
    
    public void appendTail(int value) {
    	if(!append) {
    		delete2append();
    	}
    	append = true;
    	appendStack.add(value);
    }
    
    public int deleteHead() {
    	if(append) {
    		append2delete();
    	}
    	append = false;
    	return deleteStack.isEmpty() ? -1 : deleteStack.pop();
    }
    
    void append2delete() {
    	while(!appendStack.isEmpty()) {
    		deleteStack.add(appendStack.pop());
    	}
    }
    
    void delete2append() {
    	while(!deleteStack.isEmpty()) {
    		appendStack.add(deleteStack.pop());
    	}
    }
}
