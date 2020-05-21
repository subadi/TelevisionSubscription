package com.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.application.exception.InsufficiantBalanceException;
import com.application.exception.InvalidInputException;
import com.application.user.impl.UserImpl;
import com.application.user.impl.Userservices;

/**
 * @author subodhP
 *	client console
 */
public class Subscribe {

	public static void main(String[] args) {
		System.out.println("Welcome to SatTV");
		Options options = new Options();
		options.showOption();
	}
}

/**
 * @author subodhP
 *	client console options
 */
class Options
{
	Scanner scanner= new Scanner(System.in);
	Userservices userServices = new UserImpl(200);

	/**
	 * method to show various services to user
	 */
	public void showOption() {

		while(true){
			System.out.println("\n1. View Account Balance");
			System.out.println("2. Recharge Amount");
			System.out.println("3. View available packs, channels and services");
			System.out.println("4. Subscribe to base packs");
			System.out.println("5. Add channels to an existing subscription");
			System.out.println("6. Subscribe to special service");
			System.out.println("7. View current subscription details");
			System.out.println("8. Update email and phone number for notifications");
			System.out.println("9. Exit");
			try {
				System.out.println("\nPlease select option: ");
				int option = Integer.parseInt(scanner.nextLine());
				if (option > 9) {
					throw new InputMismatchException();
				} else if (option == 9) {
					System.out.println("Logout Successful");
					System.exit(0);
				} else {
					callServices(option);
				}
			} catch (InputMismatchException e) {
				System.out.println("Please select valid option: "+e.getMessage());
				showOption();
			}catch (InsufficiantBalanceException e) {
				System.out.println("Please select valid option: "+e.getMessage());
				showOption();
			}catch (InvalidInputException e ) {
				System.out.println("Please select valid option: "+e.getMessage());
				showOption();
			}
		}
	}
	
	
	/**
	 * @param option
	 * cann various services based on client requirment
	 * @throws InvalidInputException 
	 * @throws InsufficiantBalanceException 
	 */
	private void callServices(int option) throws InvalidInputException, InsufficiantBalanceException {
		switch (option) {
		case 1:
			userServices.showBalance();
			break;
		case 2:
			userServices.recharge();
			break;
		case 3:
			userServices.viewAllService();
			break;
		case 4:
			userServices.subscribeBase();
			break;
		case 5:
			userServices.addChannel();
			break;
		case 6:
			userServices.subscribeSpecialService();
			break;
		case 7:
			userServices.viewDetails();
			break;
		case 8:
			userServices.updatePhoneEmail();
			break;
		}
		return;
	}
}