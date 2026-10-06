package ex00;

public class Program {
	public static void main(String[] args) {
		User user1 = new User(123, "Ali", 1234);
		User user2 = new User(321, "Karim", 1234);

		Transaction trans1 = new Transaction(user1, user2, Type.INCOME, 5);
		trans1.takeTransactin();

		Transaction trans2 = new Transaction(user1, user2, Type.OUTCOME, -66);
		trans2.takeTransactin();

		System.out.println(user1.getBalance());
		System.out.println(user2.getBalance());

		System.out.println(user1);
	}
}
