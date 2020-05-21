
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.application.exception.InsufficiantBalanceException;
import com.application.exception.InvalidInputException;
import com.application.operator.BasePack;
import com.application.operator.impl.EnglishService;
import com.application.operator.impl.GoldPack;
import com.application.operator.impl.SilverPack;
import com.application.user.impl.UserImpl;

public class ApplicationTests {


	@BeforeEach
	public void setup() {

	}

	@AfterEach
	public void end() {
	}

	@Test
	void checkInitialBalance() {
		UserImpl userImpl = new UserImpl(300);
		assertEquals(300, userImpl.showBalance());
	}

	@Test
	void checkInitialBalanceInvalid() {
		UserImpl userImpl = new UserImpl(0);
		userImpl.setBalance(600);
		assertNotEquals(200, userImpl.showBalance());

	}

	@Test
	void addChannelWithoutSubscriptionGold() {
		UserImpl userImpl = new UserImpl(0);
		userImpl.setSubScribed(true);
		BasePack goldPack = new GoldPack();
		userImpl.setBasePack(goldPack); //
		
		assertEquals(false,userImpl.addChannel());
	}

	@Test
	void addChannelWithoutSubscriptionSilver() {
		UserImpl userImpl = new UserImpl(0);
		
		userImpl.setSubScribed(true);
		BasePack silverPack = new SilverPack();
		userImpl.setBasePack(silverPack);

		String input = "NAT";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals(false,userImpl.addChannel());
	}

	/**
	 * enter non numeric value
	 * 
	 * @throws InvalidInputException
	 */

	@Test
	void rechargeValid() throws InvalidInputException {
		UserImpl user = new UserImpl(0);

		String input = "300";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		
		assertEquals(true,user.recharge());

	}

	/**
	 * enter non numeric value
	 */

	@Test
	void rechargeInValid() {
		UserImpl user = new UserImpl(0);

		String input = "XYZ";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertThrows(InvalidInputException.class, () -> {
			user.recharge();
		});

	}

	/**
	 * update mail and phone
	 */

	@Test
	void checkUpdate() {
		UserImpl user = new UserImpl(0);

		String email = "abc@gmail.com";
		InputStream in = new ByteArrayInputStream(email.getBytes());
		System.setIn(in);

		
		assertEquals(true,user.updatePhoneEmail());

	}

	/**
	 * show services
	 */

	@Test
	void showServices() {
		UserImpl user = new UserImpl(300);
		user.viewAllService();

		assertEquals(true,user.viewAllService());

	}

	/**
	 * Gold subscription with duration < 3
	 */

	@Test
	void subscribeGoldValid() {
		UserImpl userImpl = new UserImpl(0);
		userImpl.setBalance(300);

		String input = "G";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals(true,userImpl.subscribeBase());
	}

	/**
	 * Silver Subscription with duration < 3
	 */

	@Test
	void subscribeSilverValid() {
		UserImpl userimpl = new UserImpl(0);
		userimpl.setBalance(300);

		String input = "S";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals(true,userimpl.subscribeBase());
	}

	/**
	 * Silver Subscription with duration > 3
	 */

	@Test
	void subscribeSilverDiscount() {
		UserImpl userimpl = new UserImpl(0);
		userimpl.setBalance(300);

		String input = "G";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		String duration = "4";
		InputStream ins = new ByteArrayInputStream(duration.getBytes());
		System.setIn(ins);

		assertEquals(false,userimpl.subscribeBase());
	}

	/**
	 * Enter invalid Pack type e.g X
	 */

	@Test
	void subscribeInValidPack() {
		UserImpl userimpl = new UserImpl(0);
		userimpl.setBalance(300);

		String input = "X";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertEquals(false,userimpl.subscribeBase());
	}

	/**
	 * Sunscribe special service with insufficiant balance
	 */

	@Test
	void subscribeCooking() {
		UserImpl userimpl = new UserImpl(0);

		String input = "LearnCooking";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertThrows(InsufficiantBalanceException.class, () -> {
			userimpl.subscribeSpecialService();
		});

	}

	/**
	 * Sunscribe special service with insufficiant balance
	 * 
	 * @throws InsufficiantBalanceException
	 */

	@Test
	void subscribeEnglishWithoutBalance() throws InsufficiantBalanceException {
		UserImpl userimpl = new UserImpl(0);

		String input = "LearnEnglish";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		assertThrows(InsufficiantBalanceException.class, () -> {
			userimpl.subscribeSpecialService();
		});

	}

	@Test
	void subscribeEnglishWithBalance() throws InsufficiantBalanceException {
		UserImpl userimpl = new UserImpl(0);
		userimpl.setBalance(500);
		
		String input = "LearnEnglish";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		
		assertEquals(true,userimpl.subscribeSpecialService());
	}

	@Test
	void viewAllDetailsGold() {
		UserImpl userImpl = new UserImpl(0);
		BasePack goldPack = new GoldPack();
		userImpl.setBasePack(goldPack);
		
		assertEquals(true,userImpl.viewDetails());
		
	}

	@Test
	void viewAllDetailsSilver() {
		UserImpl userImpl = new UserImpl(0);
		BasePack silverPack = new SilverPack();
		userImpl.setBasePack(silverPack);
		
		assertEquals(true,userImpl.viewDetails());
	}

	@Test
	void viewAllDetailsSpecial() {
		UserImpl userImpl = new UserImpl(0);
		EnglishService englishService = new EnglishService();
		userImpl.setSpecialServices(englishService);
	}

	@Test
	void addChannelWithoutSubscription() {
		UserImpl userimpl = new UserImpl(0);
		
		assertEquals(true,userimpl.addChannel());
	}

	@Test
	void addChannelWithSubscription() {
		UserImpl userimpl = new UserImpl(0);
		assertEquals(true,userimpl.addChannel());
	}

}
