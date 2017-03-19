
public class ClassTester
{

	public static void main(String[] args)
	{
		Time time1 = new Time();
		System.out.println("Time 1 (no arg constructor):");
		System.out.println(time1.getHour() + ":" + time1.getMinute() + ":" + time1.getSecond() + "\r\n");
		
		Time time2 = new Time(555550000);
		System.out.println("Time 2 (elapsed time constructor):");
		System.out.println(time2.getHour() + ":" + time2.getMinute() + ":" + time2.getSecond());
	}

}
