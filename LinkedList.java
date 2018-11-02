
public class LinkedList implements List {

	protected Node head;
	protected int size;

	public LinkedList() {
		size = 0;
		head = new Node();
	}

	public void add(Object obj) {
		if(obj == null) {
			throw new IllegalArgumentException("can't add node");
		} 
		Node newNode = new Node(obj);
		newNode.setNext(head);
		head = newNode;
		++size;                                                                                                                                                                                                                               
	}

	public void add(int pos, Object obj) {
		if(pos < 0 || pos > size) {
			throw new IllegalArgumentException("can't add node");
		}
		if(pos==0) { //inserting at head
			Node newNode = new Node();
			newNode.data = obj;
			newNode.next = head;
			head = newNode;
			++size;
		} else {
			Node previous = getNode(pos-1);
			Node node = new Node();
			node.data = obj;
			node.next = previous.next;
			previous.next = node;
			++size;
		}
	}

	public Object get(int pos) {
		if(pos < 0 || pos >= size) {
			throw new IllegalArgumentException("can't retrieve node");
		}
		Node node = getNode(pos);
		return node.data;
	}

	public Object remove(int pos) {
		if(pos < 0 || pos >= size) {
			throw new IllegalArgumentException("can't remove node");
		}
		if(pos==0) {
			Node curr = head;
			--size;
			return curr.data;
		}
		Node previous = getNode(pos-1);
		Node curr = previous.next;
		previous.next = curr.next;
		--size;
		return curr.data;
	}

	public int size() {
		return this.size;
	}

	public Node getNode(int pos) {
		if(pos < 0 || pos >= size) {
			throw new IllegalArgumentException("can't remove node");
		}
		Node curr = head;
		for(int i = 0; i < pos; i++) {
			curr = curr.next;
		}
		return curr;
	}

	protected class Node {

		protected Object data;
		protected Node next;

		public Node() {
			next = null;
			this.data = 0;
		}

		public Node(Object data) {
			next = null;
			this.data = data;
		}

		public Object getData() {
			return data;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getNext() {
			return next;
		}

	}
}