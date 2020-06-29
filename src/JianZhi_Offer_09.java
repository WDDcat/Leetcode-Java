import java.util.Stack;

public class JianZhi_Offer_09 {
	
	/*
	 * 	���������֪������֮ǰ��������
	 * 	���������������ص���
	 * 	��Ҫ�����ֲ������Ƶ��ĸ�������ȥ
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
