package com.application.user.impl;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.application.constant.BasicPackages;
import com.application.constant.Channels;
import com.application.exception.InsufficiantBalanceException;
import com.application.exception.InvalidInputException;
import com.application.operator.BasePack;
import com.application.operator.impl.CookingServices;
import com.application.operator.impl.EnglishService;
import com.application.operator.impl.GoldPack;
import com.application.operator.impl.SilverPack;
import com.application.user.User;

/**
 * @author subodhP User services implementation
 */
public class UserImpl extends User implements Userservices {



	private final static String GOLD = "G";
	private final static String SILVER = "S";
	private final static String LEARNENGLISH = "LearnEnglish";
	private final static String LEARNCOOKING = "LearnCooking";

	
	/*
	 * public UserImpl() { super(balance); }
	 */

	public UserImpl(int balance) {
		super(balance);
	}
	
	
	/**
	 * 
	 * To display this balance
	 */
	
	public int showBalance() {
		System.out.println("Your Current accoutn balance is: " + this.getBalance());
		return this.getBalance();
	}

	/**
	 * To recharge balance
	 * 
	 * @throws InvalidInputException
	 */
	
	public boolean recharge() throws InvalidInputException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter amount to recharge");
		try {
			int amt = scanner.nextInt();
			int balance = this.getBalance();
			balance += amt;
			this.setBalance(balance);
			System.out.println("Recharge Succesful");
			System.out.println("Your new balance is: " + this.getBalance());
		} catch (InputMismatchException e) {
			System.out.println("Please enter valid amount" + e.getMessage());
			scanner.close();
			throw new InvalidInputException("Please enter valid input:");
		}
		scanner.close();
		return true;
	}

	/**
	 * Display All services offered
	 */
	
	public boolean viewAllService() {
		System.out.println("Channel Services");
		System.out.println("Available packs for subscription");
		SilverPack silverPack = new SilverPack();

		List<Channels> silverPackChannels = silverPack.getChannel();

		System.out.println("Silver Pack: ");
		for (Channels channel : silverPackChannels) {
			System.out.print(channel.getKey() + ", ");
		}
		System.out.println(" " + silverPack.getPrice() +" Rs.");

		GoldPack goldPack = new GoldPack();

		List<Channels> goldPackChannels = goldPack.getChannel();

		System.out.println("Gold Pack: ");
		for (Channels channel : goldPackChannels) {
			System.out.print(channel.getKey() + ", ");
		}
		System.out.println(" " + goldPack.getPrice() + " Rs.");

		System.out.println("Available channels for subscription: ");
		for (Channels channel : Channels.values()) {
			System.out.print(channel.getKey() + ": " + channel.getValue() + " Rs. , ");
		}

		System.out.println("\nAvailable services for subscription");
		EnglishService englishService = new EnglishService();
		CookingServices cookingServices = new CookingServices();
		System.out.println("\n"+englishService.getServiceName() + " " + englishService.getPrice() + "\n"
				+ cookingServices.getServiceName() + " " + cookingServices.getPrice());

		return true;
	}

	/**
	 * TO Subscribe to gold or silver services
	 */
	
	public boolean subscribeBase() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter the Pack you wish to subscribe: (Silver: ‘S’, Gold: ‘G’)");
			String packType = scanner.nextLine();
			char pack = packType.charAt(0);
			switch (pack) {
			case 'G':
				BasePack goldPack = new GoldPack();
				this.setBasePack(goldPack);
				break;
			case 'S':
				BasePack silverPack = new SilverPack();
				this.setBasePack(silverPack);
				break;
			default:
				System.out.println("Invalid subscription");
				System.out.println("Please enter S or G");
				return false;

			}
			BasicPackages packages = BasicPackages.valueOf(packType);
			System.out.println("Enter of Months: ");
			int duration = scanner.nextInt();
			int subscribedAmount = packages.getValue() * duration;
			if (duration >= 3) {
				System.out.println("You are Eligible for 10 % Discount");
				final int discount = (subscribedAmount * 10) / 100;
				System.out.println("Discount applied:" + discount);
				subscribedAmount -= discount;
				System.out.println("Final Price after discount: " + subscribedAmount);

			}

			System.out.println("Subscribed amout is: " + subscribedAmount + " this amoutn is: " + this.getBalance());
			if (subscribedAmount > this.getBalance()) {
				throw new InsufficiantBalanceException("insufficiant balance");
			}

			this.setBalance(this.getBalance() - subscribedAmount);
			System.out.println("You have successfully subscribed the following packs: " + packages.getKey());
			System.out.println("Monthly Package price is: " + packages.getValue());
			System.out.println("Number of month: " + duration);
			System.out.println("Subscription Amount: " + subscribedAmount);
			System.out.println("Account balance: " + this.getBalance());
			this.setSubScribed(true);

			// write service
			System.out.println("Email notification sent successfully");
			System.out.println("SMS notification sent successfully");
		} catch (Exception e) {
			System.out.println("Please enter Valid Input: " + e.getMessage());
		}
		return true;
	}

	/**
	 * To add channel to current subscription
	 */
	
	public boolean addChannel() {

		Scanner scanner = new Scanner(System.in);
		if (this.isSubScribed()) {
			if (this.getBasePack().packType.equals(GOLD)) {
				System.out.println("You have all the channels as you have subscribed to gold pack.");
				return false;
			} else if (this.getBasePack().packType.equals(SILVER)) {
				System.out.println("Enter channel names to add (separated by commas): ");
				String channels = scanner.nextLine();
				String[] channel = channels.split(",");
				List<Channels> channelList = this.getBasePack().getChannel();

				int flg = 0;
				for (String ch : channel) {
					
					System.out.println("channel is "+ch); 
					flg = 0;
					
					Iterator<Channels> iterator = Channels.addChannelSet.iterator();
					while (iterator.hasNext()) {
						
						if(iterator.next().getKey().equalsIgnoreCase(ch))
						{
							
							if (ch.equalsIgnoreCase("Discovery")) {
								if (this.getBalance() > Channels.DISC.getValue()) {
									this.setBalance(this.getBalance() - Channels.DISC.getValue());
									channelList.add(Channels.DISC);
									flg=1;
								} else {
									System.out.println("Not have sufficint balance");
									return false;
								}
							} else if (ch.equalsIgnoreCase("NatGeo")) {
								if (this.getBalance() > Channels.NAT.getValue()) {
									this.setBalance(this.getBalance() - Channels.NAT.getValue());
									channelList.add(Channels.NAT);
									flg=1;
								} else {
									System.out.println("Not have sufficint balance");
									return false;
								}
							}
						
						}
						
					}

					 if(flg==0){
							System.out.println("You have entered wrong channel: " + ch);
							System.out.println("Channel name must include below channles: ");
							// Channels.addChannelSet.forEach(channelname ->
							// System.out.println(channelname));
							Iterator<Channels> it = Channels.addChannelSet.iterator();
							while (it.hasNext()) {
								System.out.println(it.next().getKey());
							}
							return false;
						}
					
				}

				System.out.println("Channels added successfully.");

			} else {
				System.out.println("You must purchase subscription first.");
				return false;
			}
		}
		return true;
	}

	/**
	 * Subscribe speacial services such as english class or cookign classes.
	 * 
	 * @throws InsufficiantBalanceException
	 */
	
	public boolean subscribeSpecialService() throws InsufficiantBalanceException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the service name");
		String specialServiceName = scanner.nextLine();

		if (specialServiceName.equalsIgnoreCase("LearnEnglish")) {
			EnglishService englishService = new EnglishService();
			if (this.getBalance() > englishService.getPrice()) {
				this.setSpecialServices(englishService);
				this.setBalance(this.getBalance() - englishService.getPrice());
			} else {
				scanner.close();
				throw new InsufficiantBalanceException(" insufficiant balance");
			}
			System.out.println("Service subscribed successfully");
			System.out.println("Accout Balance: " + this.getBalance());

		} else if (specialServiceName.equalsIgnoreCase("LearnCooking")) {
			CookingServices cookingServices = new CookingServices();
			if (this.getBalance() > cookingServices.getPrice()) {
				this.setSpecialServices(cookingServices);
				this.setBalance(this.getBalance() - cookingServices.getPrice());
			} else {
				scanner.close();
				throw new InsufficiantBalanceException(" insufficiant balance");
			}
			System.out.println("Service subscribed successfully");
			System.out.println("Accout Balance: " + this.getBalance());

		} else {
			System.out.println("No Such Service Availbale");
			System.exit(0);
		}

		System.out.println("Email notification sent successfully");
		System.out.println("SMS notification sent successfully");
		scanner.close();
		return true;
	}

	/**
	 * To display this's all subscription history
	 */
	
	public boolean viewDetails() {

		if (this.getBasePack() != null) {
			if (this.getBasePack().packType.equals(GOLD)) {
				System.out.println("Currently subscribed packs GOLD");

			} else if (this.getBasePack().packType.equals(SILVER)) {
				System.out.println("Currently subscribed packs SILVER");
			}
			for (Channels channel : this.getBasePack().getChannel()) {
				System.out.print(channel + " ");
			}
		} else {
			System.out.println("\nNot suscribed to any base packgae");
		}
		if (this.getSpecialServices() != null) {
			if (this.getSpecialServices().getServiceName().equalsIgnoreCase(LEARNENGLISH)) {
				System.out.println("Currently subscribed packs LEARNENGLISH");
			} else if (this.getSpecialServices().getServiceName().equalsIgnoreCase(LEARNCOOKING)) {
				System.out.println("Currently subscribed packs LEARNCOOKING");
			}
		} else {
			System.out.println("Not subscribed to any speacial service");
		}
		return true;
	}

	/**
	 * update phone and email of this
	 */
	@Override
	public boolean updatePhoneEmail() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter your email: ");
		String email = scanner.nextLine();

		if (this.getEmail() == null)
			this.setEmail(email);

		scanner.close();
		return true;
	}

}
