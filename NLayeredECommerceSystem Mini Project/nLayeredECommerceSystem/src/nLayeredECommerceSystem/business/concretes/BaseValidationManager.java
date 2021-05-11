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
			System.out.println("> Giri� Yapma Ba�ar�s�z!, > L�tfen T�m Girdi Alanlar�n� Doldurunuz!");
			return;
		}
		if (customerToLogin == null) {
			System.out.println("> Giri� Yapma Ba�ar�s�z!, > L�tfen Girdilerinizi Kontrol Edip Tekrar Deneyiniz!");
			return;
		} else {
			System.out.println("> Giri� Yapma ��lemi Ba�ar�l�! : > Ho�geldiniz Say�n " + customerToLogin.getFirstName()
					+ " " + customerToLogin.getLastName());

		}

	}

	@Override
	public void register(Customer customer) {

		for (Customer customerList : customers) {
			if (customerList.getEmail().equals(customer.getEmail())
					&& customer.getPassword().equals(customer.getPassword())) {
				System.out.println("> Kay�t ��lemi Yap�lamad�!");
				System.out.println();
				System.out.println("> Bu Email Adresi Zaten Sistemde Kay�tl�! : " + customer.getEmail());
				return;
			}
		}

		Customer customerToRegister = new Customer(customer.getId(), customer.getFirstName(), customer.getLastName(),
				customer.getEmail(), customer.getPassword());

		if (customerValidationService.isValid(customerToRegister) == false) {
			System.out.println("> Kay�t Olma Ba�ar�s�z!, > L�tfen Girdilerinizi Kontrol Edip Tekrar Deneyiniz!");
			return;
		} else {
			System.out.println(
					"> Kay�t Olma Ba�ar�l�!, > L�tfen Email Adresinize Gelen Do�rulama Linkine T�klayarak Kay�t Olma ��lemini Tamamlay�n�z!");
			emailService.transmitting("> Kay�t Olmay� Do�rulamak ��in Buraya T�klay�n�z!",
					customerToRegister.getEmail());
			customerService.add(customerToRegister);

		}

	}

}
