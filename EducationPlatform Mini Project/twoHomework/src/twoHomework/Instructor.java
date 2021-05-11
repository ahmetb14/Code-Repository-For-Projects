package twoHomework;

public class Instructor extends User {

	private int numberOfStudent;
	private int numberOfCourses;

	public Instructor(int id, String name, int age, String email, int numberOfStudent, int numberOfCourses) {

		super(id, name, age, email);
		this.numberOfStudent = numberOfStudent;
		this.numberOfCourses = numberOfCourses;

	}

	public int getNumberOfStudent() {
		return numberOfStudent;
	}

	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}

	public int getNumberOfCourses() {
		return numberOfCourses;
	}

	public void setNumberOfCourses(int numberOfCourses) {
		this.numberOfCourses = numberOfCourses;
	}

}
