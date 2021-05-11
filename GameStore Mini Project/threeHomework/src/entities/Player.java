package entities;

import abstracts.Entity;

public class Player implements Entity {

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String tcNo;
	private String dateOfBirth;

	public Player(int id, String firstName, String lastName, int age, String tcNo, String dateOfBirth) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.tcNo = tcNo;
		this.dateOfBirth = dateOfBirth;

	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public int getAge() {

		return age;
	}

	public void setAge(int age) {

		this.age = age;
	}

	public String getTcNo() {

		return tcNo;
	}

	public void setTcNo(String tcNo) {

		this.tcNo = tcNo;
	}

	public String getDateOfBirth() {

		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {

		this.dateOfBirth = dateOfBirth;
	}

}
