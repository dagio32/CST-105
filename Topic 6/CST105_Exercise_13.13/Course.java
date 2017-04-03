/**
 * 
 * Course Class
 * 
 * The Course class now implements the Comparable and Cloneable
 * interfaces.  Instances of Course can now be cloned and
 * should return a 0 when using the compareTo() method.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

public class Course implements Comparable<Course>, Cloneable
{
	// Main method for testing
	public static void main(String[] args)
	{
		// Instantiate new course
		Course course1 = new Course("CST-105");
		
		// Clone course1 to course2
		Course course2 = course1.clone();
		
		// Display result of compareTo()
		// compareTo() should return 0 denoting equality
		System.out.println(course1.compareTo(course2));
	}

	//
	// Class fields and methods
	//
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;

	public Course(String courseName)
	{
		this.courseName = courseName;
	}

	public void addStudent(String student)
	{
		students[numberOfStudents] = student;
		numberOfStudents++;

		if (numberOfStudents == students.length)
		{
			String[] studentsTemp = new String[numberOfStudents * 2];
			System.arraycopy(students, 0, studentsTemp, 0, students.length);
			students = studentsTemp;
		}
	}

	public String[] getStudents()
	{
		return students;
	}

	public int getNumberOfStudents()
	{
		return numberOfStudents;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public void clear()
	{
		String[] studentsTemp = new String[100];
		students = studentsTemp;
		numberOfStudents = 0;
	}

	public void dropStudent(String student)
	{
		boolean foundStudent = false;
		int initialNumberOfStudents = getNumberOfStudents();

		for (int i = 0; i < initialNumberOfStudents; i++)
		{
			if (foundStudent)
			{
				students[i - 1] = students[i];
				if (i == initialNumberOfStudents - 1)
				{
					students[i] = null;
				}
			}
			if (students[i] == student && !foundStudent)
			{
				students[i] = null;
				numberOfStudents--;
				foundStudent = true;
			}
		}

	}

	// Comparable implementation
	@Override
	public int compareTo(Course c)
	{
		return getCourseName().compareTo(c.getCourseName());
	}

	// Cloneable implementation
	@Override
	public Course clone()
	{
		try
		{
			Course courseClone = (Course)super.clone();
			return courseClone;
		}
		catch (CloneNotSupportedException ex)
		{
			return null;
		}
	}
}