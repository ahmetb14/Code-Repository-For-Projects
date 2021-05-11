package nLayeredECommerceSystem.business.concretes;

import java.util.List;

import nLayeredECommerceSystem.business.abstracts.CustomerService;
import nLayeredECommerceSystem.business.abstracts.CustomerValidationService;
import nLayeredECommerceSystem.core.ValidationService;
import nLayeredECommerceSystem.core.email.EmailService;
import nLayeredECommerceSystem.entities.concretes.Customer;

public class BaseValidationManager implements ValidationService {

	List<Customer> customers;
	CustomerService customerService;
	CustomerValidationService customerValidationService;
	EmailService emailService;

	public BaseValidationManager(CustomerService customerService, CustomerValidationService customerValidationService,
			EmailService emailService, List<Customer> customers) {

		this.customerService = customerService;
		this.customerValidationService = customerValidationService;
		this.emailService = emailService;
		this.customers = customers;

	}

	@Override
	public void login(Customer customer) {

		Customer customerToLogin = customerService.getPasswordByEmail(customer.getEmail(), customer.getPassword());

		if (customer.getEmail() == null || customer.getPassword() == null) {
			System.out.println("> Giriþ Yapma Baþarýsýz!, > Lütfen Tüm Girdi Alanlarýný Doldurunuz!");
			return;
		}
		if (customerToLogin == null) {
			System.out.println("> Giriþ Yapma Baþarýsýz!, > Lütfen Girdilerinizi Kontrol Edip Tekrar Deneyiniz!");
			return;
		} else {
			System.out.println("> Giriþ Yapma Ýþlemi Baþarýlý! : > Hoþgeldiniz Sayýn " + customerToLogin.getFirstName()
					+ " " + customerToLogin.getLastName());

		}

	}

	@Override
	public void register(Customer customer) {

		for (Customer customerList : customers) {
			if (customerList.getEmail().equals(customer.getEmail())
					&& customer.getPassword().equals(customer.getPassword())) {
				System.out.println("> Kayýt Ýþlemi Yapýlamadý!");
				System.out.println();
				System.out.println("> Bu Email Adresi Zaten Sistemde Kayýtlý! : " + customer.getEmail());
				return;
			}
		}

		Customer customerToRegister = new Customer(customer.getId(), customer.getFirstName(), customer.getLastName(),
				customer.getEmail(), customer.getPassword());

		if (customerValidationService.isValid(customerToRegister) == false) {
			System.out.println("> Kayýt Olma Baþarýsýz!, > Lütfen Girdilerinizi Kontrol Edip Tekrar Deneyiniz!");
			return;
		} else {
			System.out.println(
					"> Kayýt Olma Baþarýlý!, > Lütfen Email Adresinize Gelen Doðrulama Linkine Týklayarak Kayýt Olma Ýþlemini Tamamlayýnýz!");
			emailService.transmitting("> Kayýt Olmayý Doðrulamak Ýçin Buraya Týklayýnýz!",
					customerToRegister.getEmail());
			customerService.add(customerToRegister);

		}

	}

}
