/**
 * @author Ketan Kumar
 * Illustrating banking operation using Regular Expression and Exception Handling
 *
 */
package banking.App;

//Importing scanner class to get user input
import java.util.Scanner;

import bank.App.Model.bankAppModel;
import bank.App.Controller.*;
import static java.lang.System.*;

public class App 
{
    public static void main( String[] args )
    {
    	//creating scanner object named scan
        Scanner scan = new Scanner(System.in);
        out.println("------Welcome------");
        out.print("Enter Account Holder Name : ");
        String accName = scan.next();
        out.print("Enter Account Number : ");
        int accNum = scan.nextInt();
        out.print("Enter Amount : ");
        int accBal = scan.nextInt();
        out.print("Enter Password : ");
        String accPswd = scan.next();
        
        // Creating Object of bankAppModel named bm
        bankAppModel bm = new bankAppModel();
        
        // Creating Object of bankAppController named bc
        bankAppController bc = new bankAppController();
        
        // Calling get set method to store user input for execution
        bm.setAccName(accName); bm.getAccName();
        bm.setAccNum(accNum); bm.getAccNum();
        bm.setAccBal(accBal); bm.getAccBal();
        bm.setAccPswd(accPswd); bm.getAccPswd();
        
        try {
        	// Checking validity of User Name
        	if(bc.checkUserName(bm)) {
        		try {	     			
        			// Checking validity of Password
        			if(bc.checkPswd(bm)) {
        				out.println("Account Details : ");
        				
        				// Calling toString method to print Account Details.
        				out.println(bm.toString());
        				out.println("-------------------");
        				int choice = 0;
        				while(choice<3) {
        					out.println("Enter 1 to Withdraw \nEnter 2 to Deposit \nEnter 3 to Exit :");
        					choice = scan.nextInt();
        				// Using switch case to perform user selected operation
        				switch(choice) {
        				case 1 :	 out.println("Enter Password");
        							 String pswd  = scan.next();
        							 bm.setGivenPswd(pswd); bm.getGivenPswd();
        					try {
        						// Matching Password
        						if(bc.verifyPswd(bm)) {
        							out.println("Enter Amount : ");
        							int amount = scan.nextInt();
        							bm.setAmount(amount); bm.getAmount();
        							try {
        								// Checking if Balance is sufficient to Withdraw Amount.
        								if(bc.checkBal(bm)) {
        									out.println("----------\nAccount Balance : "+bm.getToWithDraw());
        									bm.setAccBal(bm.getToWithDraw()); // Updating Account Balance
        								}
        							}
        							// throwing exception if Amount is more than balance.
        							catch(Exception e) {
                						out.println(e.getMessage());
        							}	
        						}
        					}
        					// Throwing Exception if Password does'nt match.
        					catch(Exception e) {
        						out.println(e.getMessage());	
        					}
        					break;
        					
        					case 2 :	 out.println("Enter Password");
        								pswd  = scan.next();
        								bm.setGivenPswd(pswd); bm.getGivenPswd();
        					try {
        						// Matching Password
        						if(bc.verifyPswd(bm)) {
        							out.println("Enter Amount : ");
        							int amount = scan.nextInt();
        							bm.setAmount(amount); bm.getAmount();
        									out.println("----------\nAccount Balance : "+bm.getToDeposit());
        									bm.setAccBal(bm.getToDeposit()); // Updating Account Balance
        							}
        						}
        						// throwing exception if Amount is more than balance.
        						catch(Exception e) {
        							out.println(e.getMessage());	
        						}
        					break;
        					
        					case 3 :
        						out.println("----------\nAccount Details : ");
                				
                				// Calling toString method to print Account Details.
                				out.println(bm.toString());
        					
        					default : System.exit(0);
        				}
        			}
        		}
        	}
        	// Throw Exception if Password is Invalid
        	catch(Exception e){
        			out.println(e.getMessage());
        		}
        	}
        }
        // Throw Exception if Name is Invalid
        catch (Exception e) {
        	out.println(e.getMessage());      	
        }
        scan.close();
    }
}