package nLayeredECommerceSystem.dataAccess.abstracts;

import java.util.List;

import nLayeredECommerceSystem.entities.concretes.Customer;

public interface CustomerDao {

	void add(Customer customer);

	void update(Customer customer);

	void delete(Customer customer);

	List<Customer> getAll();

	Customer getPasswordByEmail(String email, String password);

	Customer get(int id);
}
