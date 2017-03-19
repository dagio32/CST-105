/**
 * 
 * Tax Class Tester
 * 
 * This program prints tax information for incomes between $50000 and $60000
 * in $1000 increments.  Both the 2001 and 2009 tax brackets and rates are
 * displayed in this application.
 * 
 * @author Nicholas Robertson
 * Grand Canyon University
 * 
 **/

public class TaxClassTester
{

	public static void main(String[] args)
	{
		// Define brackets for 2001 tax season
		int[][] brackets2001 = new int[][] { { 27050, 65550, 136750, 297350 }, { 45200, 109250, 166500, 297350, },
				{ 22600, 54625, 83250, 148675, }, { 36250, 93650, 151650, 297350 } };
		
		// Define rates for 2001 tax season
		double[] rates2001 = {.15, .275, .305, .355, .391};
		
		// Instantiate tax2001 object starting at 50000 taxable income
		Tax tax2001 = new Tax(0, brackets2001, rates2001, 50000);
		
		// Print tax information
	    System.out.println("Taxes for 2001:\r\n");
	    
	    System.out.println("Singe filer:");
	    printTaxInformation(tax2001);
		
	    System.out.println("Married filing jointly or qualifying widow(er):");
	    tax2001.setFilingStatus(1);
	    tax2001.setTaxableIncome(50000);
	    printTaxInformation(tax2001);
	    
	    System.out.println("Married filing separately:");
	    tax2001.setTaxableIncome(50000);
	    tax2001.setFilingStatus(2);
	    printTaxInformation(tax2001);
	    
	    System.out.println("Head of household:");
	    tax2001.setTaxableIncome(50000);
	    tax2001.setFilingStatus(3);
	    printTaxInformation(tax2001);
		
		// Define brackets for 2009 tax season
		int[][] brackets2009 = new int[][] { { 8350, 33950, 82250, 171550, 372950 },
				{ 16700, 67900, 137050, 208850, 372950 }, { 8350, 33950, 68525, 104425, 186475 },
				{ 11950, 45500, 117450, 190200, 372950 } };
		
		// Define rates for 2009 tax season
		double[] rates2009 = {.10, .15, .25, .28, .33, .35};
		
		// Instantiate tax2009 object starting at 50000 taxable income
		Tax tax2009 = new Tax(0, brackets2009, rates2009, 50000);
		
		// Print tax information
		System.out.println("Taxes for 2009:");
		
	    System.out.println("Singe filer:");
	    printTaxInformation(tax2009);
		
	    System.out.println("Married filing jointly or qualifying widow(er):");
	    tax2009.setTaxableIncome(50000);
	    tax2009.setFilingStatus(1);
	    printTaxInformation(tax2009);
	    
	    System.out.println("Married filing separately:");
	    tax2009.setTaxableIncome(50000);
	    tax2009.setFilingStatus(2);
	    printTaxInformation(tax2009);
	    
	    System.out.println("Head of household:");
	    tax2009.setTaxableIncome(50000);
	    tax2009.setFilingStatus(3);
	    printTaxInformation(tax2009);
	}
	
	private static void printTaxInformation(Tax taxes)
	{
		for (int i = 0; i < 11; i++)
		{
		    System.out.print("Income: " + taxes.getTaxableIncome());
		    System.out.println("		Taxes: " + taxes.getTax());
		    taxes.setTaxableIncome(taxes.getTaxableIncome() + 1000);
		}
		System.out.println();
	}

}
