package firstHomework;

public class Main {

	public static void main(String[] args) {

		System.out.println("------------------------------------------------------------------------");

		Student student1 = new Student(1, "=> Ahmet Berkay Yýlmaz", "=> ahmet26@ahmet.com", "321456");
		Student student2 = new Student(2, "=> Alperen Yýlmaz", "=> alperen26@alperen.com", "654123");

		StudentService studentService = new StudentService();
		Student[] students = { student1, student2 };

		Category category1 = new Category(1, "Engin Demiroð", "=> Java + React Programlama");
		Category category2 = new Category(2, "Engin Demiroð", "=> C# + Angular Programlama");

		Category[] categorys = { category1, category2 };

		System.out.println(">Öðrenci Listesi<");
		System.out.println("*****************");
		for (Student student : students) {

			System.out.println(student.name);
		}

		System.out.println("------------------------------------------------------------------------");

		System.out.println(">Kurs Listesi<");
		System.out.println("**************");
		for (Category category : categorys) {

			System.out.println(category.courseName);
		}

		System.out.println("------------------------------------------------------------------------");

		System.out.println(">Bilgi<");
		System.out.println("*******");
		studentService.addStudent(student1);
		studentService.addStudent(student2);

		System.out.println("------------------------------------------------------------------------");

		System.out.println(">Bilgi<");
		System.out.println("*******");
		studentService.getEmail(student1);
		studentService.getEmail(student2);

		System.out.println("------------------------------------------------------------------------");

	}

}
