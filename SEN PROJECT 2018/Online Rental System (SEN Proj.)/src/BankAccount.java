
public class BankAccount {

	
	long Accountnumber;
	int amount;
	String bankName;
	int branchCode;

	public void AddDetails(long accnum,int amt,String name,int code)
	{

	}
	public long getAccountnumber() {
		return Accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		Accountnumber = accountnumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public void checkAmount()
	{
		System.out.println("Account Balance : " + amount);
	}
 	public void printReceipt()
 	{
 		System.out.println("Transaction Done successfully");
 	}
	
	
}
