package ex04;

/**
 * User
 */

public class User {
	private Integer ID;
	private String name;
	private int balance;
	private TransactionsLinkedList transactionsLinkedList;

	public User(int id, String name, int balance) {
		setID(id);
		setName(name);
		setBalance(balance);
		transactionsLinkedList = new TransactionsLinkedList();
	}

	public int getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public int getBalance() {
		return this.balance;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(int balance) {
		if (balance < 0) {
			System.err.println("Error: Start balance cannot be negative!");
			System.exit(-1);
		}
		this.balance = balance;
	}

	public void setTransactionsLinkedList(TransactionsLinkedList transactionsLinkedList) {
		this.transactionsLinkedList = transactionsLinkedList;
	}

	public TransactionsLinkedList getTransactionsLinkedList() {
		return transactionsLinkedList;
	}

	@Override
	public String toString() {
		return "\nID: " + this.ID + "\nName: " + this.name + "\nBalance: " + this.balance;
	}

}
