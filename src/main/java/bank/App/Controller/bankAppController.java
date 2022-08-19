package bank.App.Controller;
import java.io.IOException;
import java.util.regex.Pattern;

import bank.App.Model.bankAppModel;

public class bankAppController {
	
	//Creating checkUserName to check validity of Name
	public boolean checkUserName(bankAppModel bm) throws IOException{
		String userName = bm.getAccName();
		// matching format
		if(Pattern.matches("[a-zA-z0-9 ]{6,15}", userName)) {
			return true;
		}
		else {
			// Creating exception that trigger if Name is not in correct Format
			throw new IOException ("Exception : Invalid Username !! \nUsername can only be alphanumeric and should be under 15 letters !!");
		}
	}

	//Creating checkPswd to check validity of Password
	public boolean checkPswd(bankAppModel bm) throws IOException{
		String userPswd = bm.getAccPswd();
		// matching format
		if(Pattern.matches("[a-zA-z0-9#@]{6,}", userPswd)) {
			return true;
		}
		else {
			// Creating exception that trigger if Password is not in correct Format
			throw new IOException ("Exception : Invalid Password !! \nPassword can only be alphanumeric and should be atleast 6 letters !!");
		}
	}
	
	//Creating verifyPswd to match given password to user password.
	public boolean verifyPswd(bankAppModel bm) throws IOException{
		String userPswd = bm.getAccPswd();
		String check = bm.getGivenPswd();
		// matching password
		if(userPswd.equals(check)) {
			return true;
		}
		else {
			// Creating exception that trigger if password not match
			throw new IOException ("Exception : Password Incorrect !!!");
		}
	}
	
	//Creating checkBal to check if Amount exceed the Withdraw Limit
	public boolean checkBal(bankAppModel bm) throws IOException{
		int balance = bm.getAccBal();
		int amount = bm.getAmount();
		//Checking balance
		if(balance>amount) {
			return true;
		}
		else {
			// Creating exception that trigger if balance is less than amount
			throw new IOException("Exception : Amount exceed the Withdraw Limit \nBalance Insufficient !!");
		}
	}
	
}
