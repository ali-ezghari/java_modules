package ex02;

public class Program {

	public static void main(String[] args) {
		User user1 = new User(UserIdsGenerator.getInstance().generateId(), "Ali", 1234);
		User user2 = new User(UserIdsGenerator.getInstance().generateId(), "Karim", 1234);
		User user3 = new User(UserIdsGenerator.getInstance().generateId(), "Mohamed", 1234);
		User user4 = new User(UserIdsGenerator.getInstance().generateId(), "Ali", 1234);
		User user5 = new User(UserIdsGenerator.getInstance().generateId(), "Karim", 1234);
		User user6 = new User(UserIdsGenerator.getInstance().generateId(), "Mohamed", 1234);
		User user7 = new User(UserIdsGenerator.getInstance().generateId(), "Ali", 1234);
		User user8 = new User(UserIdsGenerator.getInstance().generateId(), "Karim", 1234);
		User user9 = new User(UserIdsGenerator.getInstance().generateId(), "Mohamed", 1234);
		User user10 = new User(UserIdsGenerator.getInstance().generateId(), "Mohamed", 1234);
		User user11 = new User(UserIdsGenerator.getInstance().generateId(), "Mohamed", 1234);

		UsersList uList = new UsersArrayList();
		try {
			uList.addUser(user1);
			uList.addUser(user2);
			uList.addUser(user3);
			uList.addUser(user4);
			uList.addUser(user5);
			uList.addUser(user6);
			uList.addUser(user7);
			uList.addUser(user8);
			uList.addUser(user9);
			uList.addUser(user10);
			uList.addUser(user11);


			System.out.println(uList.getUserById(5));
			System.out.println(uList.getUserById(2));
			System.out.println(uList.getUserById(3));

		} catch (UserNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {
			System.out.println("End of the program");
		}

	}
}