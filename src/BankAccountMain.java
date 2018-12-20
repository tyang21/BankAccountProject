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
	
	public static void main(String[] args) 
	{
		ArrayList<BankAccount> bank = new ArrayList<BankAccount>();
		Scanner in = new Scanner(System.in);
		
		while (true)
		{
			System.out.println("Would you like to register an account (r), make  a transaction (t), or quit?");
			String answer = in.nextLine();
			
			switch (answer)
			{
			case "r":
				boolean register = true;
				while(register)
				{
				System.out.println("Would you like to register a checking account(c) or savings account(s)");
				String answer1 =  in.nextLine();
				switch(answer1)
				{
					case "c":
					register = false;
					break;
					
				case "s":
					register = false;
					break;
				}
				break;
				}
			case "t":
				System.out.println("todo transaction");
				break;
				
			case "q":
				return;
			}
			
		}
	}

}
