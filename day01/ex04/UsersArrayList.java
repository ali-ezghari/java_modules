package ex04;

import java.util.Arrays;

public class UsersArrayList implements UsersList {
	private static final int DEFAULT_CAPACITY = 10;
	private User[] users = new User[DEFAULT_CAPACITY];
	private int size = 0;

	@Override
	public void addUser(User user) {
		if (size == users.length)
			increaseCapacity();
		this.users[size] = user;
		this.size++;
	}

	@Override
	public User getUserById(int id) {
		for (int i = 0; i < size; i++) {
			if (users[i].getID() == id) {
				return users[i];
			}
		}
		throw new UserNotFoundException("User with ID " + id + " not found.");
	}

	@Override
	public User getUserByIndex(int index) {
		return users[index];
	}

	@Override
	public int getNumberOfUsers() {
		return this.size;
	}

	private void increaseCapacity() {
		int newCapacity = users.length + (users.length / 2);
		users = Arrays.copyOf(users, newCapacity);
	}

}
