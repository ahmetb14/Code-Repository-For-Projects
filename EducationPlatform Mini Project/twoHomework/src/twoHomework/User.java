package twoHomework;

public class User {

	private int id;
	private String name;
	private int age;
	private String email;

	public User(int id, String name, int age, String email) {

		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
