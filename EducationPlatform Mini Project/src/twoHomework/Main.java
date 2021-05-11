package twoHomework;

public class Main {

	public static void main(String[] args) {

		System.out.println("________________________________________________________________");
		System.out.println("  => JAVA & REACT YAZILIM GELÝÞTÝRÝCÝSÝ YETÝÞTÝRME KAMPI <=");
		System.out.println("________________________________________________________________");
		System.out.println("|--------------------------------------------------------------|");
		System.out.println(">Eðitmen Operasyonlarý<");
		System.out.println("***********************");
		InstructorManager instructorManager = new InstructorManager();
		Instructor instructor = new Instructor(1, "> Engin Demiroð", 30, "engin@engin.com", 3000, 100);
		instructorManager.add(instructor);
		instructor.setName("> ENGÝN DEMÝROÐ");
		instructorManager.update(instructor);
		instructorManager.delete(instructor);

		System.out.println("|--------------------------------------------------------------|");
		System.out.println(">Öðrenci Operasyonlarý<");
		System.out.println("***********************");
		StudentManager studentManager = new StudentManager();
		Student student = new Student(2, "> Ahmet Berkay Yýlmaz", 19, "ahmet@ahmet.com", 80, 10);
		studentManager.add(student);
		student.setName("> AHMET BERKAY YILMAZ");
		studentManager.update(student);
		studentManager.delete(student);

		System.out.println("|--------------------------------------------------------------|");
		System.out.println(">Tüm Kiþilerin Listesi<");
		System.out.println("***********************");
		UserManager userManager = new UserManager();
		userManager.getAll(student);
		userManager.getAll(instructor);

		System.out.println("|--------------------------------------------------------------|");
		System.out.println("________________________________________________________________");
		System.out.println("             => ZORLANMAZSAN GELÝÞEMEZSÝN... <=");
		System.out.println("________________________________________________________________");

	}

}
