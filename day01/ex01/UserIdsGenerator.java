package ex01;


public class UserIdsGenerator {
	private static UserIdsGenerator instance;
	private static Integer lastGeneratedId = 2;

	public Integer generateId() {
		return lastGeneratedId++;
	}

	public static UserIdsGenerator getInstance() {
		if (instance == null) {
			instance = new UserIdsGenerator();
		}
		return instance;
	}
}
