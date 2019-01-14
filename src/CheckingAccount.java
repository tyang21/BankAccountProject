
public class CheckingAccount extends BankAccount 
{
	private final double OVER_DRAFT_FEE;
	private final double TRANSACTION_FEE;
	private final double FREE_TRANS;
	private int numTransactions;
	
	/**
	 * Constructs a Checking Account with an initial balance that the user inputs
	 * @param n This is the owner of the Checking Account. 
	 * @param b This is the initial balance of the Checking Account. 
	 * @param odf This is the Over Draft Fee.
	 * @param tf This is the transaction fee.
	 * @param freeTrans This is the number of free transactions allowed in one month
	 */
	public CheckingAccount(String n, double b, double odf, double tf, int freeTrans)
	{
		super(n, b);
		OVER_DRAFT_FEE  =  odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	/**
	 * Constructs a Checking Account with an initial balance already initialized to 0
	 * @param n This is the owner of the Checking Account
	 * @param odf This is the Over Draft fee
	 * @param tf This is the transaction fee
	 * @param freeTrans This is the number of free transactions allowed in one month
	 */
	public CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
	this(n, 0, odf, tf, freeTrans);
	}
	
	/**
	 * This deposits money into the Checking Account
	 * The Deposit amount cannot be less than 0
	 * @param amt This is the amount that is being deposited into the Checking Account
	 */
	public void deposit(double amt)
	{
		 if(amt < 0)
		 {
			 throw new IllegalArgumentException();
		 }
		 super.deposit(amt);
		 numTransactions++;
		 if(numTransactions > FREE_TRANS)
		 {
			 super.withdraw(TRANSACTION_FEE);
		 }
		 if(getBalance() < 0)
		 {
			 super.withdraw(OVER_DRAFT_FEE);
		 }
		 
	}
	/**
	 * This withdraws money from the Checking Account
	 * The Checking Account balance cannot go below 0 with the withdraw, and the withdraw amount cannot be 0 or less
	 * @param amt This is the amount that is being withdrawn from the Checking Account
	 */
	public void withdraw(double amt)
	{
		if(getBalance() < 0  || amt <= 0)
		{
			throw new IllegalArgumentException();
		}
		super.withdraw(amt);
		numTransactions++;
		if(numTransactions > FREE_TRANS)
		{
			super.withdraw(TRANSACTION_FEE);
		}
		if(getBalance() < 0)
		{
			super.withdraw(OVER_DRAFT_FEE);
		}
	}
	/**
	 * Transfer money from one Checking account to another. The transfer accounts must be with the same Name/Owner.
	 * The Transaction amount cannot be negative
	 * The Account that is transferring the money cannot go negative
	 * @param other This is the Checking account money is being transfered to.
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
	/**
	 * When the end of the month comes, the number of transactions resets.
	 */
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
	}
	
}
