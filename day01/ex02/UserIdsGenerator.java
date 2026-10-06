package ex02;

public class UserIdsGenerator {
	private static UserIdsGenerator instance = null;
	private static Integer lastGeneratedId = 0;

	public Integer generateId() {
		lastGeneratedId++;
		return lastGeneratedId;
	}

	public static UserIdsGenerator getInstance() {
		if (instance == null) {
			instance = new UserIdsGenerator();
		}
		return instance;
	}
}
