/**
 * 
 * MyString1 Class
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

public class MyString1
{
	private char[] Chars;

	public MyString1(char[] chars)
	{
		Chars = chars;
	}

	public char charAt(int index)
	{
		return Character.valueOf(Chars[index]);
	}

	public int length()
	{
		return Chars.length;
	}

	public MyString1 substring(int begin, int end)
	{
		MyString1 myString = new MyString1(Chars);
		
		int range = end - begin + 1;
		char[] tempChars = new char[range];
		
		for (int i = 0; i < range; i ++)
		{
			tempChars[i] = charAt(begin + i);			
		}
		
		myString.Chars = tempChars;
		
		return myString;
	}

	public MyString1 toLowerCase()
	{
		MyString1 myString = new MyString1(Chars);
		
		for (int i = 0; i < Chars.length; i ++)
		{
			myString.Chars[i] = Character.toLowerCase(charAt(i));			
		}
		
		return myString;
	}

	public boolean equals(MyString1 s)
	{
		if (s.equals(Chars))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static MyString1 valueOf(int i)
	{
		String tempString = Integer.toString(i);
		char[] tempChars = tempString.toCharArray();
		
		MyString1 myString = new MyString1(tempChars);
		
		return myString;
	}
}
