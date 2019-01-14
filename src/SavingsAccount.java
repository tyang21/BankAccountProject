
public class SavingsAccount extends BankAccount
{
	private double intRate;
	private final double MIN_BAL;
	private final double MIN_BAL_FEE;
	/**
	 * Constructs a Savings Account with a initial balance not initialized
	 * @param n This is the owner of the account
	 * @param b This is the inital balance of the account
	 * @param r This is the interest rate 
	 * @param mb This is the Minimum Balance of a savings account
	 * @param mbf This is the Minimum Balance Fee if the account goes below the minimum balance
	 */
	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super(n,b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	/**
	 * Constructs a Savings Account with the initial balance initialized to 0
	 * @param n This is the owner of the account
	 * @param r This is the interest rate 
	 * @param mb This is the Minimum Balance
	 * @param mbf This is the Minimum Balance Fee
	 */
	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		this(n, 0, r, mb, mbf);
	}
	/**
	 * This deposits money into the Savings Account
	 * The Deposit amount cannot be less than 0
	 * @param amt This is the amount that is being deposited into the Savings Account
	 */
	public void deposit(double amt)
	{
		if(amt < 0)
		{
			throw new IllegalArgumentException();
		}
		super.deposit(amt);
		
	}
	/**
	 * This withdraws money from the Savings Account
	 * The Savings Account balance cannot go below 0 with the withdraw, and the withdraw amount cannot be 0 or less
	 * @param amt This is the amount that is being withdrawn from the Savings Account
	 */
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
	/**
	 * Transfer money from one Savings account to another. The transfer accounts must be with the same Name/Owner.
	 * The Transaction amount cannot be negative
	 * The Account that is transferring the money cannot go negative
	 * @param other This is the Savings account money is being transfered to.
	 * @param amt This is the amount of money to that is being transfered. 
	 */
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
