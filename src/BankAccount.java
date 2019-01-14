/** 
 * Make Sure to have Java Comments
 * @author tyang21
 *
 */
public abstract class BankAccount 
{
	
	private static int nextAccNum;
	private String name;
	private int acctNum;
	private double balance;
	/**
	 * Constructs a Bank Account that automatically sets the initial balance to 0.
	 * @param n This is the owner of the Bank Account. 
	 */
	public BankAccount(String n)
	{
		this.name = n;
		balance = 0;
		acctNum = nextAccNum;
		nextAccNum++;
	}
	/**
	 * Constructs a Bank Account that includes an initial balance that the user inputs
	 * @param n This is the owner of the BankAccount. 
	 * @param b This is the initial balance the user wants to input in the Bank Account. 
	 */
	public BankAccount(String n, double b)
	{
		this.name = n;
		this.acctNum = nextAccNum;
		nextAccNum++;
		balance = b;
	}
	/**
	 * This deposits money into Bank Account
	 * @param amt This is the amount the user wants to deposit into the bank account. 
	 */
	public void deposit(double amt)
	{
		balance += amt;
	}
	/**
	 * Withdraw money from Bank Account object
	 * @param amt This is the amount the user wants to withdraw from the Bank Account. 
	 */
	public void withdraw(double amt)
	{
		balance -= amt;
	}
	/**
	 * @return String This returns the BankAccount's owner.
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @return int This returns the BankAccount's balance.
	 */
	public double getBalance()
	{
		return balance;
	}
	/**
	 * Abstract Method. Updates information at the end of the month, to be implemented in the Savings and CheckingAccount method
	 */
	public abstract void endOfMonthUpdate();
	/**
	 * Transfer money from one bank account to another
	 * @param other This is the Bank account money is being transfered to.
	 * @param amt This is the amount of money to that is being transfered. 
	 */
	public void transfer(BankAccount other, double amt)
	{
		this.withdraw(amt);
		other.deposit(amt);
	}
	/**
	 * @return String This displays the bank account in the format account number, owner of the account, balance of the account)
	 */
	public String toString()
	{
		return("Account Number:" + acctNum + "	Owner:    " + name + "    " + "	Balance:	$" + balance);
	}
	/**
	 * 
	 * @return int This returns the account number of the Bank Account Object
	 */
	public int getAccountNum()
	{
		return acctNum;
	}
	

}
