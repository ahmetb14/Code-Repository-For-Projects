package nLayeredECommerceSystem.core;

import nLayeredECommerceSystem.entities.concretes.Customer;
import nLayeredECommerceSystem.loginWithGoogle.LoginWithGoogleManager;

public class LoginWithGoogleAdapter implements ValidationService {

	@Override
	public void login(Customer customer) {

		LoginWithGoogleManager googleManager = new LoginWithGoogleManager();
		googleManager.register(customer.getEmail(), customer.getPassword());

	}

	@Override
	public void register(Customer customer) {

		LoginWithGoogleManager googleManager = new LoginWithGoogleManager();
		googleManager.login(customer.getEmail(), customer.getPassword());

	}

}
