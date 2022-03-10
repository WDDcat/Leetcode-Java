package interview;

import base.ListNode;

public class Interview_02_01_Remove_Duplicate_Node {
	
	/*
	 * 	Ϊ�˲��ÿռ临�Ӷ���O(n)
	 * 	ֻ�ܽ���һ������洢ĳ�������Ƿ����
	 * 	���־�remove
	 * */
	
	public ListNode removeDuplicateNodes(ListNode head) {
		if (head == null || head.next == null)
			return head;

		boolean[] exist = new boolean[20001];
		exist[head.val] = true;
		ListNode p = head.next, pre = head;
		while (p != null) {
			if (exist[p.val]) {
				pre.next = p.next;
				p = pre.next;
			} else {
				exist[p.val] = true;
				pre = p;
				p = p.next;
			}
		}
		return head;
	}
}
