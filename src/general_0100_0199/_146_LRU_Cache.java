package general_0100_0199;
import java.util.HashMap;

public class _146_LRU_Cache {

	/*
	 * 	一开始的思路：建立两个队列，一个存储key值，一个存储value值
	 * 	然后维护两个队列，判断有无通过遍历数组，但维护代价过高，时间复杂度O(n^2)
	 * 	
	 * 	后来想到使用双向队列和哈希表的方法，
	 * 	双向队列可以弥补数组插删的不足
	 * 	同时哈希表存储key值和key值对应存储数据的位置
	 * 	但这样的问题在于：寻找到双向队列中的某一个值需要遍历双向队列，将复杂度降至O(n)
	 * 	
	 * 	最后查看了题解，还是使用双向队列和哈希表的方法，
	 * 	双向队列不变，但哈希表用于存储key值 和key值对应的value的Node的指针
	 * 	这样的好处是不用寻找双向队列里的某个元素的位置，直接通过指针定位插删
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
