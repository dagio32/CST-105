/**
 * 
 * Course Class Tester
 * 
 * This program tests the Course class by instantiating a new course,
 * adding three students, dropping one, and then displaying the students
 * in the course.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

public class CourseClassTester
{

	public static void main(String[] args)
	{
		// Instantiate a course and provide course name
		Course course = new Course("CST-105");

		// Add three students
		course.addStudent("Johnny");
		course.addStudent("Billy");
		course.addStudent("Bobby");
		
		// Drop a student
		course.dropStudent("Billy");

		String[] students = course.getStudents();

		// Display the students in the course
		for (int i = 0; i < course.getNumberOfStudents(); i++)
		{
			System.out.println(students[i]);
		}
	}

}
