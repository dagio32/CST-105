import java.util.Date;

public class Main
{

	public static void main(String[] args)
	{
		Person person = new Person("Bob", "123 Main Street", "5554449876", "Joe.Person@email.com");
		System.out.println(person.toString());
		
		Student student = new Student("John", "123 Main Street", "5554449876", "Joe.Student@email.com", "Freshman");
		System.out.println(student.toString());
		
		Employee employee = new Employee("Joe", "123 Main Street", "5554449876", "Joe.Employee@email.com", "Office1", 50000, new Date());
		System.out.println(employee.toString());
		
		Faculty faculty = new Faculty("Jim", "123 Main Street", "5554449876", "Joe.Faculty@email.com", "Office1", 30000, new Date(), 7, 17, "Entry Level");
		System.out.println(faculty.toString());
		
		Staff staff = new Staff("Jack", "123 Main Street", "5554449876", "Joe.Staff@email.com", "Office1", 75000, new Date(), "Supervisor");
		System.out.println(staff.toString());
	}

}
