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
	 * Base Bank Account constructor
	 * @param name
	 */
	public BankAccount(String n)
	{
		this.name = n;
		balance = 0;
		acctNum = nextAccNum;
		nextAccNum++;
	}
	/**
	 * Bank Account Constructor that also includes a initial balance
	 * @param name
	 * @param initial balance
	 */
	public BankAccount(String n, double b)
	{
		this.name = n;
		this.acctNum = nextAccNum;
		nextAccNum++;
		balance = b;
	}
	/**
	 * Deposit money into Bank Account
	 * @param amount to deposit
	 */
	public void deposit(double amt)
	{
		balance += amt;
	}
	/**
	 * Withdraw money from Bank Account object
	 * @param amount to withdraw
	 */
	public void withdraw(double amt)
	{
		balance -= amt;
	}
	/**
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @return balance
	 */
	public double getBalance()
	{
		return balance;
	}
	/**
	 * Abstract end of Month Update method to be implemented in Subclasses
	 */
	public abstract void endOfMonthUpdate();
	/**
	 * Transfer money from one bank account to another
	 * @param Bank account to transfer money too
	 * @param amount of money to transfer
	 */
	public void transfer(BankAccount other, double amt)
	{
		this.withdraw(amt);
		other.deposit(amt);
	}
	/**
	 * displays Bank Account format ( Account Number, Name, Balance)
	 */
	public String toString()
	{
		return(acctNum + "    " + name + "    " + "$" + balance);
	}
	public int getAccountNum()
	{
		return acctNum;
	}
	

}
