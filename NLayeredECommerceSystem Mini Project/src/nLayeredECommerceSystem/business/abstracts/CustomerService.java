package nLayeredECommerceSystem.business.abstracts;

import java.util.List;

import nLayeredECommerceSystem.entities.concretes.Customer;

public interface CustomerService {

	void add(Customer customer);

	void update(Customer customer);

	void remove(Customer customer);

	void validCustomer(int id);

	List<Customer> getAll();

	Customer get(int id);

	Customer getPasswordByEmail(String email, String password);

}
