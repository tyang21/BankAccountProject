
public class CheckingAccount extends BankAccount 
{
	private final double OVER_DRAFT_FEE;
	private final double TRANSACTION_FEE;
	private final double FREE_TRANS;
	private int numTransactions;
	
	public CheckingAccount(String n, double b, double odf, double tf, int freeTrans)
	{
		super(n, b);
		OVER_DRAFT_FEE  =  odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	public CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
	this(n, 0, odf, tf, freeTrans);
	}
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
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
	}
	
}
