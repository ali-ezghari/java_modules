package ex03;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

	private Node head = new Node(null, null, null);
	private Node tail = new Node(null, null, null);
	int size = 0;

	TransactionsLinkedList() {
		head = null;
		tail = null;
	}

	@Override
	public void addTransaction(Transaction data) {
		Node node = new Node(data, null, null);

		if (tail == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			node.setPrev(tail);
			tail = node;
		}
		size++;
	}

	@Override
	public void removeTransaction(UUID ID) {
		Node current = head;

		for (int i = 0; i < size; i++) {
			if (current.getData().getID().equals(ID)) {
				if (i == 0) {
					deleteAtBeginning();
					return;
				}
				if (i == size - 1) {
					deleteAtEnd();
					return;
				}

				current.getPrev().setNext(current.getNext());
				current.getNext().setPrev(current.getPrev());
				current.setPrev(null);
				current.setNext(null);
				size--;
				return;
			}
			current = current.getNext();
		}
		throw new TransactionNotFoundException("Transaction with id" + ID + "Is not found");
	}

	@Override
	public void printAllTransactions() {
		Node node = head;
		for (int i = 0; i < size; i++) {

			System.out.println(node.getData().toString());
			node = node.getNext();
		}
	}

	void deleteAtBeginning() {
		if (head == null) {
			return;
		}

		if (head == tail) {
			head = null;
			tail = null;
			return;
		}

		Node temp = head;
		head = head.getNext();
		head.setPrev(null);
		temp.setNext(null);
		size--;
	}

	void deleteAtEnd() {
		if (tail == null) {
			return;
		}

		if (head == tail) {
			head = null;
			tail = null;
			return;
		}

		Node temp = tail;
		tail = tail.getPrev();
		tail.setNext(null);
		temp.setPrev(null);
		size--;
	}
}

class Node {
	private Transaction data = null;
	private Node next = null;
	private Node prev = null;

	Node(Transaction data, Node prev, Node next) {
		setData(data);
		setPrev(prev);
		setNext(next);
	}

	// --- Getters ---
	public Transaction getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public Node getPrev() {
		return prev;
	}

	// --- Setters ---
	public void setData(Transaction data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
}