package twoHomework;

public class Student extends User {

	private int successScore;
	private int numberOfCoursesCompleted;

	public Student(int id, String name, int age, String email, int successScore, int numberOfCoursesCompleted) {

		super(id, name, age, email);
		this.successScore = successScore;
		this.numberOfCoursesCompleted = numberOfCoursesCompleted;

	}

	public int getSuccessScore() {
		return successScore;
	}

	public void setSuccessScore(int successScore) {
		this.successScore = successScore;
	}

	public int getNumberOfCoursesCompleted() {
		return numberOfCoursesCompleted;
	}

	public void setNumberOfCoursesCompleted(int numberOfCoursesCompleted) {
		this.numberOfCoursesCompleted = numberOfCoursesCompleted;
	}

}
