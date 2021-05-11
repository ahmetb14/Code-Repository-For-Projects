package nLayeredECommerceSystem.business.concretes;

import java.util.regex.Pattern;

import nLayeredECommerceSystem.business.abstracts.CustomerValidationService;
import nLayeredECommerceSystem.entities.concretes.Customer;

public class CustomerValidationManager implements CustomerValidationService {

	static String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

	public static final Pattern pattern = Pattern.compile(regex);

	@Override
	public boolean isValid(Customer customer) {

		boolean result = true;

		if (customer.getFirstName().length() <= 2 || customer.getLastName().length() <= 1
				|| isValidEmail(customer.getEmail()) == false || customer.getPassword().length() <= 7) {

			result = false;
			System.out.println("> Girilen Bilgiler Hatal�!, > L�tfen Girdilerinizi Kontrol Edip Tekrar Deneyiniz!");

		} else {

			System.out.println("> Girilen Bilgiler Onayl�!, > Do�rulama Ba�ar�yla Ger�ekle�ti!");

		}

		return result;

	}

	private boolean isValidEmail(String email) {

		return Pattern.matches(regex, email);

	}

}
