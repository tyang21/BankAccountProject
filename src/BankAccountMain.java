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
				contRunning = false;
				break;
			}
			
			
		}
	}

	private static boolean isNumeric(String str)
	{
		try
		{
				Double.parseDouble(str);
				return true;
		}
		catch(IllegalArgumentException e)
		{
				return false;
		}
	}

	private static void registerAccount()
	{
		
		System.out.println("What would you like the name of your account to be?");
		String answer2 = in.nextLine();
		
		boolean cs = true;
		while(cs)
		{
			System.out.println("Would you like to register a checking account(c) or savings account(s)");
			String answer1 =  in.nextLine();
			
			switch(answer1)
			{
			case "c":
				
				bankAccounts.add(new CheckingAccount(answer2 , OVER_DRAFT_FEE,TRANSACTION_FEE, FREE_TRANSACTIONS));
				cs = false;
				break;
			case "s":
				bankAccounts.add(new SavingsAccount(answer2, RATE, MIN_BAL, MIN_BAL_FEE));
				cs = false;
				break;
			}
		}
		double amt;
		boolean dep = true;
		while (dep)
		{
			System.out.println("How much do you want to initially deposit?(Can be 0)");
			String depans = in.nextLine();
			if(isNumeric(depans))
			{
				amt = Double.parseDouble(depans);
				dep = false;
				
			}
			
		}
		
	}
	private static void transactionAccount()
	{
		BankAccount a = null;
		boolean num = true;
		while(num)
		{
			int acct;
			System.out.println("What is your account number?");
			String answer4 = in.nextLine();
			if(isNumeric(answer4))
			{
				 acct =(int) Double.parseDouble(answer4);
				 a = getAcctByNum(acct);
				 num = false;
			}
		}
			boolean trans = true;
			while(trans)
			{
				double amt;
				System.out.println("Would you like to Deposit(d), Withdraw(w), transfer(t) or get account numbers(a)?");
				String answer2 = in.nextLine();
				switch(answer2)
				{
				case "d":
					boolean dep = true;
					while (dep)
					{
						System.out.println("How much do you want to deposit?(Can be 0)");
						String depans = in.nextLine();
						if(isNumeric(depans))
						{
							amt = Double.parseDouble(depans);
							dep = false;
							a.deposit(amt);
						}
					}
					break;
				case "w":
					boolean wit = true;
					while (wit)
					{
						System.out.println("How much do you want to withdraw");
						String witans = in.nextLine();
						if(isNumeric(witans))
						{
							amt = Double.parseDouble(witans);
							wit = false;
							a.withdraw(amt);
						}
						break;
					}
				case"t":
					BankAccount b = null;
					boolean transacc = true;
					while(transacc)
					{
						int acct;
						System.out.println("Which Account number do you want to transfer to?");
						String ans5 = in.nextLine();
						if(isNumeric(ans5))
						{
							acct = (int) Double.parseDouble(ans5);
							b = getAcctByNum(acct);
							transacc = false;
							
						}
					}
					boolean tra = true;
					while(tra)
					{
						System.out.println("How much do you want to transfer?");
						String transamt = in.nextLine();
						if(isNumeric(transamt))
						{
							amt = Double.parseDouble(transamt);
							a.transfer(b, amt);
						}
					}
					break;
				}
				
			}
			
	}
	private static BankAccount getAcctByNum(int n)
	{
		for(BankAccount a : bankAccounts)
		{
			if (n == a.getAccountNum())
			{
				return a;
			}
		}
		return null;
		
	}
}
