package bank.App.Model;

public class bankAppModel {
	
	private int accNum;
	private int accBal;
	private int amount;
	private String accName;
	private String accPswd;
	private String givenPswd;

	
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public int getAccBal() {
		return accBal;
	}
	public void setAccBal(int accBal) {
		this.accBal = accBal;
	}
	public String getAccName() {
		return accName;
	}
	public String getGivenPswd() {
		return givenPswd;
	}
	public void setGivenPswd(String givenPswd) {
		this.givenPswd = givenPswd;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getAccPswd() {
		return accPswd;
	}
	public void setAccPswd(String accPswd) {
		this.accPswd = accPswd;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getToDeposit() {
		return accBal+amount;
	}
	public int getToWithDraw() {
		return  accBal-amount;
	}
	@Override
	public String toString() {
		return "--------------------\n[ Account Number = " + accNum + "\nAccount Balance = " + accBal + "\nAccount Holder Name = " + accName + "\nAccount Password = " + accPswd
				+ "]";
	}
	
}
