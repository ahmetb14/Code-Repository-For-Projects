package nLayeredECommerceSystem.core;

import nLayeredECommerceSystem.entities.concretes.Customer;

public interface ValidationService {

	void login(Customer customer);

	void register(Customer customer);

}
