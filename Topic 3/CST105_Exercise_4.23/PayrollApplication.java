/**
 * 
 * Payroll Calculator
 * 
 * This program will accept employee information
 * and print a payroll statement.
 * 
 * @author  Nicholas Robertson
 * Grand Canyon University
 * 
*/

import java.text.NumberFormat;
import java.util.Scanner;

public class PayrollApplication 
{
	
	public static void main(String[] args) 
	{
		//Instantiate Scanner named input
		Scanner input = new Scanner(System.in);
		
		//Introduction
		System.out.println("This program will accept employee information and print a payroll statement.");
		System.out.println("When entering the tax rates, enter as decimals.  For example, .05 for 5%, .25 for 25%, etc.\r\n");
		
		//Accept user inputs
		System.out.println("Enter employee's name: ");
		String employeeName = input.nextLine();
		System.out.println("Enter number of hours worked in a week: ");
		double employeeHours = input.nextDouble();
		System.out.println("Enter hourly pay rate: ");
		double employeePayRate = input.nextDouble();
		System.out.println("Enter federal tax withholding rate: ");
		double employeeFederalTaxRate = input.nextDouble();
		System.out.println("Enter state tax withholding rate: ");
		double employeeStateTaxRate = input.nextDouble();
		
		//Calculate pay and taxes
		double employeeGrossPay = employeePayRate * employeeHours;
		double employeeFederalTaxesWithheld = employeeGrossPay * employeeFederalTaxRate;
		double employeeStateTaxesWithheld = employeeGrossPay * employeeStateTaxRate;
		double employeeTotalDeduction = employeeFederalTaxesWithheld + employeeStateTaxesWithheld;
		double employeeNetPay = employeeGrossPay - employeeTotalDeduction;
		
		//Create formatters for $$ and %%
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		NumberFormat percentageFormatter = NumberFormat.getPercentInstance();
		
		//Display result
		System.out.println("Employee Name: " + employeeName);
		System.out.println("Hours Worked: " + employeeHours);
		System.out.println("Pay Rate: " + currencyFormatter.format(employeePayRate));
		System.out.println("Gross Pay: " + currencyFormatter.format(employeeGrossPay));
		System.out.println("Deductions: ");
		System.out.println("   Federal Withholding (" + percentageFormatter.format(employeeFederalTaxRate) + "): " + currencyFormatter.format(employeeFederalTaxesWithheld));
		System.out.println("   State Withholding (" + percentageFormatter.format(employeeStateTaxRate) + "): " + currencyFormatter.format(employeeStateTaxesWithheld));
		System.out.println("   Total Deduction: " + currencyFormatter.format(employeeTotalDeduction));
		System.out.println("Net Pay: " + currencyFormatter.format(employeeNetPay));
	}
	
}
