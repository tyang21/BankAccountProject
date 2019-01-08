import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountMain 
{
	private static final double OVER_DRAFT_FEE = 15;
	private static double RATE = .0025;
	private static final double TRANSACTION_FEE = 1.5;
	private static final double MIN_BAL = 300;
	private static final double MIN_BAL_FEE = 10;
	private static final int FREE_TRANSACTIONS = 10;
	private static ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
	private static Scanner in;
	
	public static void main(String[] args) 
	{
		in = new Scanner(System.in);
		boolean contRunning = true;
		while (contRunning)
		{
			System.out.println("Would you like to register an account (r), make  a transaction (t), or quit?");
			String answer = in.nextLine();
			
			switch (answer)
			{
			case "r":
				registerAccount();
				break;
			case "t":
				transactionAccount();
				break;
				
			case "q":
				return;
			}
			
			
		}
	}

	private static void registerAccount()
	{
		boolean reg = true;
		while (reg)
		{
			System.out.println("Would you like to register a checking account(c) or savings account(s)");
			String answer1 =  in.nextLine();
			
			switch(answer1)
			{
			case "c":
				System.out.println("What would you like the name of your account to be?");
				String answer2 = in.nextLine();
				bankAccounts.add(new CheckingAccount(answer2 , OVER_DRAFT_FEE,TRANSACTION_FEE, FREE_TRANSACTIONS));
				reg = false;
				break;
			case "s":
				System.out.println("What would you like the name of your account to be?");
				String answer3 = in.nextLine();
				bankAccounts.add(new SavingsAccount(answer3, RATE, MIN_BAL, MIN_BAL_FEE));
				reg = false;
				break;
			}

		}
		
	}
	private static void transactionAccount()
	{
		boolean trans= true;
		while(trans)
		{
			System.out.println("What is your account number?");
			int answer4 = in.nextInt();
			for(BankAccount a : bankAccounts)
			{
				if(answer4 == a.getAccountNum())
				{
					System.out.println("Would you like to Deposit(d), Withdraw(w), transfer(t) or get account numbers(a)?");
					String answer2 = in.nextLine();
					switch(answer2)
					{
					case "d":
						
					}
				}
			}
			
		
		}
	}
}
