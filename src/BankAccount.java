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
	
	public BankAccount(String n)
	{
		this.name = n;
		balance = 0;
		acctNum = nextAccNum;
		nextAccNum++;
	}
	public BankAccount(String n, double b)
	{
		this.name = n;
		this.acctNum = nextAccNum;
		nextAccNum++;
		balance = b;
	}
	public void deposit(double amt)
	{
		balance += amt;
	}
	public void withdraw(double amt)
	{
		balance -= amt;
	}
	public String getName()
	{
		return name;
	}
	public double getBalance()
	{
		return balance;
	}
	public abstract void endOfMonthUpdate();
	public void transfer(BankAccount other, double amt)
	{
		this.withdraw(amt);
		other.deposit(amt);
	}
	public String toString()
	{
		return(acctNum + "    " + name + "    " + "$" + balance);
	}
	public int getAccountNum()
	{
		return acctNum;
	}
	

}
