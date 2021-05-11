package nLayeredECommerceSystem.business.abstracts;

import nLayeredECommerceSystem.entities.concretes.Customer;

public interface CustomerValidationService {

	boolean isValid(Customer customer);

}
