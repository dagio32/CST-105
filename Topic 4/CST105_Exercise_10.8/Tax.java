/**
 * 
 * Tax Class
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

public class Tax
{
	private int filingStatus;
	private int[][] brackets;
	private double[] rates;
	private double taxableIncome;
	
	private final int SINGLE_FILER = 0;
	private final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER = 1;
	private final int MARRIED_SEPARATELY = 2;
	private final int HEAD_OF_HOUSEHOLD = 3;
	
	public Tax()
	{
		filingStatus = 0;
		brackets = new int[4][6];
		rates = new double[6];
		taxableIncome = 0;
	}
	
	public Tax(int FilingStatus, int[][] Brackets, double[] Rates, double TaxableIncome)
	{
		filingStatus = FilingStatus;
		brackets = Brackets;
		rates = Rates;
		taxableIncome = TaxableIncome;
	}
	
	public double getTax()
	{
		double tax = 0;

		// Five tax brackets
		if (rates.length == 4)
		{
			tax = getTaxFiveBrackets();
		}
		// Six tax brackets
		else
		{
			tax = getTaxSixBrackets();
		}

		return tax;
	}
	
	public double getTaxFiveBrackets()
	{
		double tax = 0;
		
		if (taxableIncome <= brackets[filingStatus][0])
		{
			tax = taxableIncome * rates[0];
		}
		else if (taxableIncome <= brackets[filingStatus][1])
		{
			tax = brackets[filingStatus][0] * rates[0] + (taxableIncome - brackets[filingStatus][0]) * rates[1];
		}
		else if (taxableIncome <= brackets[filingStatus][2])
		{
			tax = brackets[filingStatus][0] * rates[0] + brackets[filingStatus][1] * rates[1]
					+ (taxableIncome - brackets[filingStatus][1]) * rates[2];
		}
		else if (taxableIncome <= brackets[filingStatus][3])
		{
			tax = brackets[filingStatus][0] * rates[0] + brackets[filingStatus][1] * rates[1]
					+ brackets[filingStatus][2] * rates[2] + (taxableIncome - brackets[filingStatus][2]) * rates[3];
		}
		else
		{
			tax = brackets[filingStatus][0] * rates[0] + brackets[filingStatus][1] * rates[1]
					+ brackets[filingStatus][2] * rates[2] + brackets[filingStatus][3] * rates[3]
					+ (taxableIncome - brackets[filingStatus][3]) * rates[4];
		}
		
		return tax;
	}
	
	public double getTaxSixBrackets()
	{
		double tax = 0;

		if (taxableIncome <= brackets[filingStatus][0])
		{
			tax = taxableIncome * rates[0];
		}
		else if (taxableIncome <= brackets[filingStatus][1])
		{
			tax = brackets[filingStatus][0] * rates[0] + (taxableIncome - brackets[filingStatus][0]) * rates[1];
		}
		else if (taxableIncome <= brackets[filingStatus][2])
		{
			tax = brackets[filingStatus][0] * rates[0] + brackets[filingStatus][1] * rates[1]
					+ (taxableIncome - brackets[filingStatus][1]) * rates[2];
		}
		else if (taxableIncome <= brackets[filingStatus][3])
		{
			tax = brackets[filingStatus][0] * rates[0] + brackets[filingStatus][1] * rates[1]
					+ brackets[filingStatus][2] * rates[2] + (taxableIncome - brackets[filingStatus][2]) * rates[3];
		}
		else if (taxableIncome <= brackets[filingStatus][4])
		{
			tax = brackets[filingStatus][0] * rates[0] + brackets[filingStatus][1] * rates[1]
					+ brackets[filingStatus][2] * rates[2] + brackets[filingStatus][3] * rates[3]
					+ (taxableIncome - brackets[filingStatus][3]) * rates[4];
		}
		else
		{
			tax = brackets[filingStatus][0] * rates[0] + brackets[filingStatus][1] * rates[1]
					+ brackets[filingStatus][2] * rates[2] + brackets[filingStatus][3] * rates[3]
					+ brackets[filingStatus][4] * rates[4]	+ (taxableIncome - brackets[filingStatus][4]) * rates[5];
		}

		return tax;
	}
	
	// Setter methods
	public void setFilingStatus(int FilingStatus)
	{
		filingStatus = FilingStatus;
	}
	
	public void setBrackets(int[][] Brackets)
	{
		brackets = Brackets;
	}
	
	public void setRates(double[] Rates)
	{
		rates = Rates;
	}
	
	public void setTaxableIncome(double TaxableIncome)
	{
		taxableIncome = TaxableIncome;
	}
	
	// Getter methods
	public int getFilingStatus()
	{
		return filingStatus;
	}
	
	public int[][] getBrackets()
	{
		return brackets;
	}
	
	public double[] getRates()
	{
		return rates;
	}
	
	public double getTaxableIncome()
	{
		return taxableIncome;
	}
}
