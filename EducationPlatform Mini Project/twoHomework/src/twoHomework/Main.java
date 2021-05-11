package twoHomework;

public class Main {

	public static void main(String[] args) {

		System.out.println("________________________________________________________________");
		System.out.println("  => JAVA & REACT YAZILIM GEL��T�R�C�S� YET��T�RME KAMPI <=");
		System.out.println("________________________________________________________________");
		System.out.println("|--------------------------------------------------------------|");
		System.out.println(">E�itmen Operasyonlar�<");
		System.out.println("***********************");
		InstructorManager instructorManager = new InstructorManager();
		Instructor instructor = new Instructor(1, "> Engin Demiro�", 30, "engin@engin.com", 3000, 100);
		instructorManager.add(instructor);
		instructor.setName("> ENG�N DEM�RO�");
		instructorManager.update(instructor);
		instructorManager.delete(instructor);

		System.out.println("|--------------------------------------------------------------|");
		System.out.println(">��renci Operasyonlar�<");
		System.out.println("***********************");
		StudentManager studentManager = new StudentManager();
		Student student = new Student(2, "> Ahmet Berkay Y�lmaz", 19, "ahmet@ahmet.com", 80, 10);
		studentManager.add(student);
		student.setName("> AHMET BERKAY YILMAZ");
		studentManager.update(student);
		studentManager.delete(student);

		System.out.println("|--------------------------------------------------------------|");
		System.out.println(">T�m Ki�ilerin Listesi<");
		System.out.println("***********************");
		UserManager userManager = new UserManager();
		userManager.getAll(student);
		userManager.getAll(instructor);

		System.out.println("|--------------------------------------------------------------|");
		System.out.println("________________________________________________________________");
		System.out.println("             => ZORLANMAZSAN GEL��EMEZS�N... <=");
		System.out.println("________________________________________________________________");

	}

}
