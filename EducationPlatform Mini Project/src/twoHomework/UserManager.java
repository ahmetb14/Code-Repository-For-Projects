package twoHomework;

public class UserManager {

	public void getAll(User user) {

		System.out.println(user.getName() + " -> �simli Ki�i Sistemden Getirldi!");

	}

	public void add(User user) {

		System.out.println(user.getName() + " -> �simli Ki�i Sisteme Eklendi!");

	}

	public void delete(User user) {

		System.out.println(user.getName() + " -> �simli Ki�i Sistemden Silindi!");

	}

	public void update(User user) {

		System.out.println(user.getName() + " -> �simli Ki�i Sistemde G�ncellendi!");

	}

}
