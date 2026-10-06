package ex00;

import java.util.UUID;

enum Type {
	INCOME,
	OUTCOME
}

/**
 * Transaction
 */
public class Transaction {
	private UUID ID;
	private User recipient;
	private User sender;
	private Type transferType;
	private int transferAmount;

	public Transaction(User sender, User recipient, Type type, int amount) {
		setID(UUID.randomUUID());
		setSender(sender);
		setRecipient(recipient);
		setTransferType(type);
		setTransferAmount(amount);
	}

	// GETTERS
	public UUID getID() {
		return ID;
	}

	public User getRecipient() {
		return recipient;
	}

	public User getSender() {
		return sender;
	}

	public Type getTransferType() {
		return transferType;
	}

	public int getTransferAmount() {
		return transferAmount;
	}

	// SETTERS
	public void setID(UUID ID) {
		this.ID = ID;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public void setTransferType(Type transferType) {
		this.transferType = transferType;
	}

	public void setTransferAmount(int transferAmount) {
		if (transferType == Type.OUTCOME && transferAmount > 0) {
			System.err.println("Error: Transfer outcome must be negative!");
			System.exit(-1);
		} else if (transferType == Type.INCOME && transferAmount < 0) {
			System.err.println("Error: Transfer income must be positive!");
			System.exit(-1);
		}
		this.transferAmount = transferAmount;
	}

	public void takeTransactin() {
		if (this.transferType == Type.INCOME) {
			sender.setBalance(sender.getBalance() + transferAmount);
			recipient.setBalance(recipient.getBalance() - transferAmount);
		} else if (this.transferType == Type.OUTCOME) {
			sender.setBalance(sender.getBalance() - transferAmount);
			recipient.setBalance(recipient.getBalance() + transferAmount);
		}
	}

}