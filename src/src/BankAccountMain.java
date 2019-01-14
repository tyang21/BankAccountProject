import java.util.ArrayList;
import java.util.Scanner;
/**
 * Bank Account Project
 * @author Tyler Yang
 * Period 7
 */
public class BankAccountMain 
{
	private static final double OVER_DRAFT_FEE = 15;
	private static final double RATE = .0025;
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
	/**
	 * Checks if the String is numeric
	 * @param str This is the string the method is checking to see if it is numeric
	 * @return boolean This returns true if the value is numeric, false if the value is not
	 */
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
/**
 * This method is used when the user asks to register an account. The user can register a Checking or savings account.
 * The method also asks for the owner name of the account and how much the user wants to initially deposit.
 */
	private static void registerAccount()
	{
		BankAccount a = null;
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
				
				double amt = -1;
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
				try
				{
					BankAccount s = new CheckingAccount(answer2 , OVER_DRAFT_FEE,TRANSACTION_FEE, FREE_TRANSACTIONS);
					s.deposit(amt);
					bankAccounts.add(s);
					System.out.println(s.toString());
				}
				catch(Exception e)
				{
					System.out.println("Deposit not authorized, Try to register the Account again.");
				}
				cs = false;
				
				break;
			case "s":
				double amt1 = -1;
				boolean dep1 = true;
				while (dep1)
				{
					System.out.println("How much do you want to initially deposit?(Can be 0)");
					String depans = in.nextLine();
					if(isNumeric(depans))
					{
						amt1 = Double.parseDouble(depans);
						dep1 = false;
					}
				}
				
				
				try
				{
					BankAccount d = new SavingsAccount(answer2, RATE, MIN_BAL, MIN_BAL_FEE);
					d.deposit(amt1);
					bankAccounts.add(d);
					System.out.println(d.toString());
				}
				catch(Exception e)
				{
					System.out.println("Deposit not authorized, Try registering the account again");
				}
				
				cs = false;
				
				break;
			}
		}
		
		
	}
	/**
	 * This method is used when the User wants to do some sort of transaction. The user can deposit, withdraw, transfer or retrieve their account numbers.
	 * For each of the transactions, the user is also prompted for which number they want to do the transaction from.
	 * If the user does not know their account number, they can find their account by the owner name
	 */
	private static void transactionAccount()
	{
			boolean trans = true;
			while(trans)
			{
				double amt;
				System.out.println("Would you like to Deposit(d), Withdraw(w), transfer(t) or get account numbers(a)?");
				String answer2 = in.nextLine();
				switch(answer2)
				{
				case "d":
					BankAccount acctNum2 = null;
					trans = false;
					boolean numCont = true;
					while(numCont)
					{
						System.out.println("What is the account number you want to retrieve?");
						String acctAns = in.nextLine();
						if(isNumeric(acctAns))
						{
							acctNum2 = getAcctByNum((int) Double.parseDouble(acctAns));
							if(acctNum2 == null)
							{
								boolean option = true;
								while(option)
								{
									System.out.println("I'm Sorry, that account number is invalid, would you like to try again(r) or enter your account name(n)");
									String retry = in.nextLine();
									switch(retry)
									{
									case "r":
										option = false;
										break;
									case "n":
										option = false;
										System.out.println("What is the name of the owner of the accounts?");
										String name_ = in.nextLine();
										for(BankAccount c : bankAccounts)
										{
											if(c.getName().equals(name_))
											{
												if(c instanceof CheckingAccount)
												{
													System.out.println("\n" + c.toString() + " CheckingAccount");
												}
												else if(c instanceof SavingsAccount)
												{
													System.out.println("\n" + c.toString() + " SavingsAccount");
												}
												
											}
											else
											{
												System.out.println("Im Sorry, there is no account number associated to this name");
												option = true;
											}
										}
										break;
										
										
									
										
									}	
								}
							}
							else
							{
								numCont = false;
							}
						
						}
						else
						{
							System.out.println("Please Try Again");
						}
					}
					boolean dep = true;
					while (dep)
					{
						System.out.println("How much do you want to deposit?(Can be 0)");
						String depAns = in.nextLine();
						if(isNumeric(depAns))
						{
							amt = Double.parseDouble(depAns);
							dep = false;
							try
							{
								acctNum2.deposit(amt);
								System.out.println(acctNum2.toString());
							}
							catch(Exception e)
							{
								System.out.println(acctNum2.toString());
								System.out.println("Transaction not authorized");
							}
							
						}
					}
					break;
				case "w":
					BankAccount acctNum3 = null;
					trans = false;
					boolean numCont3 = true;
					while(numCont3)
					{
						System.out.println("What is the account number you want to retrieve?");
						String acctAns = in.nextLine();
						if(isNumeric(acctAns))
						{
							acctNum3 = getAcctByNum((int) Double.parseDouble(acctAns));
							if(acctNum3 == null)
							{
								boolean option = true;
								while(option)
								{
									System.out.println("I'm Sorry, that account number is invalid, would you like to try again(r) or enter your account name(n)");
									String retry = in.nextLine();
									switch(retry)
									{
									case "r":
										option = false;
										break;
									case "n":
										option = false;
										System.out.println("What is the name of the owner of the accounts?");
										String name_ = in.nextLine();
										for(BankAccount c : bankAccounts)
										{
											if(c.getName().equals(name_))
											{
												if(c instanceof CheckingAccount)
												{
													System.out.println("\n" + c.toString() + "	CheckingAccount");
												}
												else if(c instanceof SavingsAccount)
												{
													System.out.println("\n" + c.toString() + "	SavingsAccount");
												}
												
											}
											else
											{
												System.out.println("Im Sorry, there is no account number associated to this name");
												option = true;
											}
										}
										break;
										
										
									
										
									}	
								}
							}
							else
							{
								numCont3 = false;
							}
						
						}
						else
						{
							System.out.println("Please Try Again");
						}
					}
					boolean wit = true;
					while (wit)
					{
						System.out.println("How much do you want to withdraw?");
						String witAns = in.nextLine();
						if(isNumeric(witAns))
						{
							amt = Double.parseDouble(witAns);
							wit = false;
							try
							{
								acctNum3.withdraw(amt);
								System.out.println(acctNum3.toString());
							}
							catch(Exception e)
							{
								System.out.println("Transaction not authorized");
								System.out.println(acctNum3.toString());
							}
						}
					}
					break;
				case"t":
					BankAccount acctNum = null;
					trans = false;
					boolean numCont2 = true;
					while(numCont2)
					{
						System.out.println("What is the account number you want to retrieve?");
						String acctAns = in.nextLine();
						if(isNumeric(acctAns))
						{
							acctNum = getAcctByNum((int) Double.parseDouble(acctAns));
							if(acctNum == null)
							{
								boolean option = true;
								while(option)
								{
									System.out.println("I'm Sorry, that account number is invalid, would you like to try again(r) or enter your account name(n)");
									String retry = in.nextLine();
									switch(retry)
									{
									case "r":
										option = false;
										break;
									case "n":
										option = false;
										System.out.println("What is the name of the owner of the accounts?");
										String name_ = in.nextLine();
										for(BankAccount c : bankAccounts)
										{
											if(c.getName().equals(name_))
											{
												if(c instanceof CheckingAccount)
												{
													System.out.println("\n" + c.toString() + "	CheckingAccount");
												}
												else if(c instanceof SavingsAccount)
												{
													System.out.println("\n" + c.toString() + "	SavingsAccount");
												}
											}
											else
											{
												System.out.println("Im Sorry, there is no account number associated to this name");
												option = true;
											}
										}
										break;
										
										
									
										
									}	
								}
							}
							else
							{
								numCont2 = false;
							}
						
						}
					}
					BankAccount b = null;
					boolean transAcc = true;
					while(transAcc)
					{
						int acct;
						System.out.println("Which Account number do you want to transfer to?");
						String ans5 = in.nextLine();
						if(isNumeric(ans5))
						{
							acct = (int) Double.parseDouble(ans5);
							b = getAcctByNum(acct);
							if(b == null)
							{
								boolean option = true;
								while(option)
								{
									System.out.println("I'm Sorry, that account number is invalid, would you like to try again(r) or enter your account name(n)");
									String retry = in.nextLine();
									switch(retry)
									{
									case "r":
										option = false;
										break;
									case "n":
										option = false;
										System.out.println("What is the name of the owner of the accounts?");
										String name_ = in.nextLine();
										for(BankAccount c : bankAccounts)
										{
											if(c.getName().equals(name_))
											{
												if(c instanceof CheckingAccount)
												{
													System.out.println("\n" + c.toString() + "	CheckingAccount");
												}
												else if(c instanceof SavingsAccount)
												{
													System.out.println("\n" + c.toString() + "	SavingsAccount");
												}
											}
											else
											{
												System.out.println("Im Sorry, there is no account number associated to this name");
												option = true;
											}
										}
										break;
										
										
									
										
									}	
								}
							}
							else
							{
								transAcc = false;
							}
							
						}
					}
					boolean tra = true;
					while(tra)
					{
						System.out.println("How much do you want to transfer?");
						String transAmt = in.nextLine();
						if(isNumeric(transAmt))
						{
							amt = Double.parseDouble(transAmt);
							tra = false;
							try
							{
								acctNum.transfer(b, amt);
								System.out.println(acctNum.toString());
								System.out.println(b.toString());
							}
							catch(Exception e)
							{
								System.out.println("Transaction not authorized");
								System.out.println(acctNum.toString());
								System.out.println(b.toString());
							}
						}
					}
					break;
				case "a":
					boolean option = true;
					while(option)
					{		
						System.out.println("What is the name of the owner of the accounts?");
						String name_ = in.nextLine();
						for(BankAccount c : bankAccounts)
						{
							if(c.getName().equals(name_))
							{
								if(c instanceof CheckingAccount)
								{
									System.out.println("\n" + c.toString() + "	CheckingAccount");
									option = false;
								}
								else if(c instanceof SavingsAccount)
								{
									System.out.println("\n" + c.toString() + "	SavingsAccount");
									option = false;
								}
							}
							else
							{
								System.out.println("Im Sorry, there is no account number associated to this name");
								option = true;
							}
						
							}
						}
					break;
				}
			}
	}	
	/**
	 * This method finds an account in the array list based on the account number
	 * @param n This is the account number that is going to be found within the Bank Account array list
	 * @return int The Account associated with the account number
	 * @return null if the account associated could not be found within the arraylist
	 */
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
