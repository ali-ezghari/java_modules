package ex04;

import java.util.UUID;

public class TransactionsService {
	private UsersList usersList = new UsersArrayList();

	public void addUser(User user) {
		usersList.addUser(user);
	}

	public int getUserBalance(Integer ID) {
		return usersList.getUserById(ID).getBalance();
	}

	public void performTransfer(Integer senderID, Integer reciptientID, Integer amount) {
		User sender = usersList.getUserById(senderID);
		User recipient = usersList.getUserById(reciptientID);

		Transaction debit = new Transaction(sender, recipient, Type.OUTCOME, amount);
		Transaction credit = new Transaction(sender, recipient, Type.INCOME, amount);

		debit.takeTransaction();
		credit.takeTransaction();
	}

	public TransactionsLinkedList getUserTransactions(User user) {
		User userdata = usersList.getUserById(user.getID());
		return userdata.getTransactionsLinkedList();
	}

	public void removeTransaction(UUID dataID, Integer userID) {
		User user = usersList.getUserById(userID);
		user.getTransactionsLinkedList().removeTransaction(dataID);
	}

}
