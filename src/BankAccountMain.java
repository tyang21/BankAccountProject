import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountMain 
{
	private static final double OVER_DRAFT_FEE = 15;
	private double RATE = .0025;
	private static final double TRANSACTION_FEE = 1.5;
	private static final double MIN_BAL = 300;
	private static final double MIN_BAL_FEE = 10;
	private static final double FREE_TRANSACTIONS = 10;
	
	private static Scanner in;
	
	public static void main(String[] args) 
	{
		ArrayList<BankAccount> bank = new ArrayList<BankAccount>();
		in = new Scanner(System.in);
		
		while (true)
		{
			System.out.println("Would you like to register an account (r), make  a transaction (t), or quit?");
			String answer = in.nextLine();
			
			switch (answer)
			{
			case "r":
				registerAccount();
				break;
			case "t":
				System.out.println("todo transaction");
				break;
				
			case "q":
				return;
			}
			
			
		}
	}

	private static void registerAccount()
	{
		while (true)
		{
			System.out.println("Would you like to register a checking account(c) or savings account(s)");
			String answer1 =  in.nextLine();
			
			switch(answer1)
			{
			case "c":
				
				break;
			case "s":
				break;
				
			}
			break;
		}
	}
}
