package twoHomework;

public class UserManager {

	public void getAll(User user) {

		System.out.println(user.getName() + " -> Ýsimli Kiþi Sistemden Getirldi!");

	}

	public void add(User user) {

		System.out.println(user.getName() + " -> Ýsimli Kiþi Sisteme Eklendi!");

	}

	public void delete(User user) {

		System.out.println(user.getName() + " -> Ýsimli Kiþi Sistemden Silindi!");

	}

	public void update(User user) {

		System.out.println(user.getName() + " -> Ýsimli Kiþi Sistemde Güncellendi!");

	}

}
