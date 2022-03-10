package general_0100_0199;
import java.util.HashMap;

public class _146_LRU_Cache {

	/*
	 * 	һ��ʼ��˼·�������������У�һ���洢keyֵ��һ���洢valueֵ
	 * 	Ȼ��ά���������У��ж�����ͨ���������飬��ά�����۹��ߣ�ʱ�临�Ӷ�O(n^2)
	 * 	
	 * 	�����뵽ʹ��˫����к͹�ϣ��ķ�����
	 * 	˫����п����ֲ������ɾ�Ĳ���
	 * 	ͬʱ��ϣ��洢keyֵ��keyֵ��Ӧ�洢���ݵ�λ��
	 * 	���������������ڣ�Ѱ�ҵ�˫������е�ĳһ��ֵ��Ҫ����˫����У������ӶȽ���O(n)
	 * 	
	 * 	���鿴����⣬����ʹ��˫����к͹�ϣ��ķ�����
	 * 	˫����в��䣬����ϣ�����ڴ洢keyֵ ��keyֵ��Ӧ��value��Node��ָ��
	 * 	�����ĺô��ǲ���Ѱ��˫��������ĳ��Ԫ�ص�λ�ã�ֱ��ͨ��ָ�붨λ��ɾ
	 * */
	
	private class Node {
		Node next;
		Node prev;
		int element;
		int key;

		Node(int k, int v) {
			this.key = k;
			this.element = v;
		}
	};

	private class DoubleLinkedList {
		private Node head = null;
		private Node tail = null;

		DoubleLinkedList() {
			Node dummyHead = new Node(-1, -1);
			Node dummyTail = new Node(-1, -1);
			dummyHead.next = dummyTail;
			dummyTail.prev = dummyHead;
			head = dummyHead;
			tail = dummyTail;
		}

		public void push(Node node) {
			node.prev = tail.prev;
			node.next = tail;
			tail.prev.next = node;
			tail.prev = node;
		}

		public Node pop() {
			Node tempNode = head.next;
			remove(tempNode);
			return tempNode;
		}

		public void remove(Node node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}

		public void refresh(Node p) {
			remove(p);
			push(p);
		}

		public void print() {
			Node p = head;
			while (p != null) {
				System.out.print("[" + p.key);
				System.out.print("," + p.element);
				System.out.print("] -> ");
				p = p.next;
			}
			System.out.println(".");
		}
	};

	private HashMap<Integer, Node> keyMap = new HashMap<>();
	private DoubleLinkedList valueList = new DoubleLinkedList();
	private int max, current = 0;

	public _146_LRU_Cache(int capacity) {
		max = capacity;
	}

	public int get(int key) {
		Node node = keyMap.get(key);
		if (node == null)
			return -1;
		valueList.refresh(node);
		return node.element;
	}

	public void put(int key, int value) {
		Node node = keyMap.get(key);
		if (keyMap.containsKey(key)) {
			node.element = value;
			valueList.refresh(node);
		} else {
			if (current == max) {
				Node tail = valueList.pop();
				keyMap.remove(tail.key);
				Node newNode = new Node(key, value);
				valueList.push(newNode);
				keyMap.put(key, newNode);
			} else {
				Node newNode = new Node(key, value);
				valueList.push(newNode);
				keyMap.put(key, newNode);
				current++;
			}
		}
//    	System.out.println("key:" + keyMap);
		valueList.print();
	}
}
