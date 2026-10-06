package ex04;

public class Program {
	public static void main(String[] args) {
		User user1 = new User(123, "Ali", 1234);
		User user2 = new User(321, "Karim", 1234);

		Transaction trans1 = new Transaction(user1, user2, Type.INCOME, 5);
		trans1.takeTransaction();

		Transaction trans2 = new Transaction(user1, user2, Type.OUTCOME, -66);
		trans2.takeTransaction();

		TransactionsList tList = new TransactionsLinkedList();
		tList.addTransaction(trans1);
		tList.addTransaction(trans2);

		tList.printAllTransactions();
		System.out.println(trans1);
		System.out.println(trans2);

		tList.removeTransaction(trans2.getID());

		System.out.println("------------------------");
		tList.printAllTransactions();

	}
}
