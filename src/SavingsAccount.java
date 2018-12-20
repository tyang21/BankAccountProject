
public class SavingsAccount extends BankAccount
{
	private double intRate;
	private final double MIN_BAL;
	private final double MIN_BAL_FEE;
	
	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super(n,b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		this(n, 0, r, mb, mbf);
	}
	public void deposit(double amt)
	{
		if(amt < 0)
		{
			throw new IllegalArgumentException();
		}
		super.deposit(amt);
		
	}
	public void withdraw(double amt)
	{
		if(amt < 0 || super.getBalance() - amt < 0)
		{
			throw new IllegalArgumentException();
		}
		super.withdraw(amt);
		if (this.getBalance() < MIN_BAL)
		{
			super.withdraw(MIN_BAL_FEE);
		}
	}
	public void transfer(BankAccount other, double amt)
	{
		if(!other.getName().equals(getName()) || this.getBalance() - amt < 0 || amt < 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			super.transfer(other, amt);
		}
	}
	public void addInterest()
	{
		this.deposit((getBalance() * intRate));
	}
	public void endOfMonthUpdate()
	{
		this.addInterest();
	}
	
}
