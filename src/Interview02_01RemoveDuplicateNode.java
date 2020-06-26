
public class Interview02_01RemoveDuplicateNode {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode removeDuplicateNodes(ListNode head) {
		
		/*
		 * 	Ϊ�˲��ÿռ临�Ӷ���O(n)
		 * 	ֻ�ܽ���һ������洢ĳ�������Ƿ����
		 * 	���־�remove
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
