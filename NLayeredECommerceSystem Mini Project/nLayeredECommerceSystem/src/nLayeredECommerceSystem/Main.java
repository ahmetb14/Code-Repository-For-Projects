package nLayeredECommerceSystem;

import java.util.List;

import nLayeredECommerceSystem.business.abstracts.CustomerService;
import nLayeredECommerceSystem.business.abstracts.CustomerValidationService;
import nLayeredECommerceSystem.business.concretes.BaseValidationManager;
import nLayeredECommerceSystem.business.concretes.CustomerManager;
import nLayeredECommerceSystem.business.concretes.CustomerValidationManager;
import nLayeredECommerceSystem.core.ValidationService;
import nLayeredECommerceSystem.core.LoginWithGoogleAdapter;
import nLayeredECommerceSystem.core.email.EmailManager;
import nLayeredECommerceSystem.core.email.EmailService;
import nLayeredECommerceSystem.dataAccess.concretes.HibernateCustomerDao;
import nLayeredECommerceSystem.entities.concretes.Customer;
import nLayeredECommerceSystem.simulatedDatabase.SimulatedDatabase;

public class Main {

	public static void main(String[] args) {

		List<Customer> customersFake = SimulatedDatabase.GetCustomerRecordsList();
		List<Customer> customersList = SimulatedDatabase.GetCustomerList();

		CustomerService customerService = new CustomerManager(new HibernateCustomerDao(customersFake));
		CustomerValidationService customerValidationService = new CustomerValidationManager();
		EmailService emailService = new EmailManager();
		ValidationService validationService = new BaseValidationManager(customerService, customerValidationService,
				emailService, customersList);

		System.out.println("-------------------------------------------------------------------------");
		System.out.println("*************************************************************************");
		System.out.println("                  -> KAYIT ÝÞLEMLERÝ EKRANI <-");
		System.out.println("*************************************************************************");

		for (Customer customerLi : customersList) {
			System.out.println();
			System.out.println("-------------------------------------------------------------------------");
			validationService.register(customerLi);
		}

		System.out.println("-------------------------------------------------------------------------");
		System.out.println();
		System.out.println("*************************************************************************");
		System.out.println("                  -> GÝRÝÞ ÝÞLEMLERÝ EKRANI <-");
		System.out.println("*************************************************************************");

		for (Customer customerLi : customersFake) {
			System.out.println();
			System.out.println("-------------------------------------------------------------------------");
			validationService.login(customerLi);
		}

		System.out.println("-------------------------------------------------------------------------");
		System.out.println();
		System.out.println("*************************************************************************");
		System.out.println("             -> GOOGLE ÝLE GÝRÝÞ ÝÞLEMLERÝ EKRANI <-");
		System.out.println("*************************************************************************");
		System.out.println();

		ValidationService googleValdaitonService = new LoginWithGoogleAdapter();
		System.out.println("-------------------------------------------------------------------------");
		Customer customerGoogle = new Customer(4, "Burak Emre", "Aktaþ", "burakemre26@burak.com", "369147");
		googleValdaitonService.register(customerGoogle);
		System.out.println("-------------------------------------------------------------------------");
		googleValdaitonService.login(customerGoogle);

		System.out.println("-------------------------------------------------------------------------");
		System.out.println();
		System.out.println("*************************************************************************");
		System.out.println("          => E TÝCARET SÝSTEMÝ ÝÞLEM PANELÝ EKRANLARI <= ");
		System.out.println("*************************************************************************");
		System.out.println("-------------------------------------------------------------------------");

	}

}
