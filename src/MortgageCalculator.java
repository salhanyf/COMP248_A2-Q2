// ------------------------------------------------------- 
// Assignment 2
// COMP 248 Section (S) – Winter 2019
// Concordia University
// --------------------------------------------------------
import java.util.Scanner;
public class MortgageCalculator {
	public static void main(String[] args) {
		//declaration of the scanner object.
		Scanner Scan = new Scanner(System.in);
				
		//declares several variables which would be needed to store info.
		double mortgageIns, loan;
		double rate =0, MortgagePay =0;
				
		//welcome message.
		System.out.println("        Welcome to your mortgage calculator       ");
		System.out.println("        ----------------------------------- ");
				
		//asks the user for the price of the house.
		System.out.print("Please enter the asking price for the house: ");
		double askingPrice = Scan.nextInt();
				
		//asks for amortization period.
		System.out.print("Please enter the loan amortization period in years: ");
		int period = Scan.nextInt();
				
		//asks for the bank's interest rate.
		System.out.print("Please enter the interest rate offered by the bank: ");
		double bankRate = Scan.nextDouble();
				
		//asks for down payment available with the user.
		System.out.print("Please enter the down payment amount in dollars: ");
		double downPayment = Scan.nextInt();
			
		//forces the user to enter minimum of 5% down payment.
		while ( downPayment <= (askingPrice*4.99)/100) {
			System.out.print("Please enter the down payment amount in dollars: ");
			downPayment = Scan.nextInt();
		}
					
		//assigns mortgage insurance interest depending on amount of down payment the user have.
		if (downPayment >=((askingPrice*5)/100)&& downPayment <=((askingPrice*9.99)/100)) {
			rate = 0.04;
		} else if (downPayment >=((askingPrice*10)/100)&& downPayment <=((askingPrice*14.99)/100)) {
			rate = 0.031;
		} else if (downPayment >=((askingPrice*15)/100)&& downPayment <=((askingPrice*19.99)/100)) {
			rate = 0.028;	
		} else if (downPayment >=((askingPrice*20)/100)) {
			rate = 0.00;	
		}	
		
		//mortgage insurance
		mortgageIns = (askingPrice - downPayment) * rate;
		
		//loan amount
		loan = askingPrice - downPayment + mortgageIns;
				
		//asks the user for mode of payment could be monthly or weekly.
		System.out.print("Please enter mode of mortage payments monthly (M/m)"
						+ " or bi-weekly (B/b): ");
				
		//variables needed for verification
		char mode;
		boolean validMode;
				 
		//forces the user to enter a valid char; either 'm' or 'b' both case in-sensitive.
		do {
			mode = Scan.next().charAt(0);
			validMode = (mode =='m')||(mode =='M')||(mode =='b')||(mode =='B');
			if (!validMode)
				System.out.print("Please enter mode of mortage payments monthly (M/m)"
								+ " or bi-weekly (B/b): ");
			} while (!validMode);
				
			//'r' is the monthly/bi-weekly interest rate, 'n' is the number of payments
			double r=0;
			int n=0;
			
			//in case of payments done monthly, mortgage payments become:
			if ((mode =='m')||(mode =='M')){
				r = (bankRate/100)/12;
				n = period*12;
				
				MortgagePay = loan	* (r*(Math.pow(1+r, n)))/(Math.pow(1+r, n)-1);
			} 
			
			//in case of payments done bi-weekly, mortgage payments become:
			else if ((mode =='b')||(mode =='B')){
				r = (bankRate/100)/26;
				n = period*26;
					
				MortgagePay = loan	* (r*(Math.pow(1+r, n)))/(Math.pow(1+r, n)-1);
			}
			
			//displays results.
			System.out.println("\nMortage Result");
			System.out.println("--------------");
			System.out.println("\nYour mortgage insurance will be $"+mortgageIns);
			System.out.println("Your total loan amount will be $"+loan);
			System.out.println("Your mortgage payments will be $"+MortgagePay);
			System.out.println("\n--------------");
			System.out.println("Thanks for using mortgage calculator");

			//closes the scanner object.
			Scan.close();
				
	}	//End of main().
}	//End of class Mortgage.
		
