/**
 * 
 * Time Class
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

public class Time
{
	private long hour;
	private long minute;
	private long second;

	private final int HOURS_IN_DAY = 24;
	private final int MINUTES_IN_HOUR = 60;
	private final int SECONDS_IN_MINUTE = 60;
	
	public Time()
	{
		setTime(System.currentTimeMillis());
	}
	
	public Time(long milliseconds)
	{
		setTime(milliseconds);
	}
	
	public Time(long Hour, long Minute, long Second)
	{
		hour = Hour;
		minute = Minute;
		second = Second;
	}
	
	public long getHour()
	{
		return hour;
	}
	
	public long getMinute()
	{
		return minute;
	}
	
	public long getSecond()
	{
		return second;
	}
	
	public void setTime(long milliseconds)
	{
		hour = getElapsedHour(milliseconds) % HOURS_IN_DAY;
		minute = getElapsedMinute(milliseconds) % MINUTES_IN_HOUR;
		second = getElapsedSecond(milliseconds) % SECONDS_IN_MINUTE;
	}
	
	private long getElapsedHour(long milliseconds)
	{
		return milliseconds / (1000 * 60 * 60);
	}

	private long getElapsedMinute(long milliseconds)
	{
		return milliseconds / (1000 * 60);
	}

	private long getElapsedSecond(long milliseconds)
	{
		return milliseconds / 1000;
	}


}
