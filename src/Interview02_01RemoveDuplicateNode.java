
public class Interview02_01RemoveDuplicateNode {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode removeDuplicateNodes(ListNode head) {
		
		/*
		 * 	为了不让空间复杂度是O(n)
		 * 	只能建立一个数组存储某个数字是否出现
		 * 	出现就remove
		 * */
		
		if(head == null || head.next == null) return head;

        boolean[] exist = new boolean[20001];
        exist[head.val] = true;
		ListNode p = head.next, pre = head;
		while(p != null) {            
			if(exist[p.val]) {
				pre.next = p.next;
                p = pre.next;
			}
			else {
				exist[p.val] = true;
				pre = p;
				p = p.next;
			}
		}
		return head;
    }
}
