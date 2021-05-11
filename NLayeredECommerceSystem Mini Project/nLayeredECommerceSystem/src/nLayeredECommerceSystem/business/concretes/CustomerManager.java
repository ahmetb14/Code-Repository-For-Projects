package nLayeredECommerceSystem.business.concretes;

import java.util.List;

import nLayeredECommerceSystem.business.abstracts.CustomerService;
import nLayeredECommerceSystem.dataAccess.abstracts.CustomerDao;
import nLayeredECommerceSystem.entities.concretes.Customer;

public class CustomerManager implements CustomerService {

	private CustomerDao customerDao;

	public CustomerManager(CustomerDao customerDao) {

		super();
		this.customerDao = customerDao;

	}

	public CustomerManager() {

	}

	@Override
	public void add(Customer customer) {

		customerDao.add(customer);

	}

	@Override
	public void update(Customer customer) {

		customerDao.update(customer);

	}

	@Override
	public void remove(Customer customer) {

		customerDao.delete(customer);

	}

	@Override
	public void validCustomer(int id) {

		System.out.println("> Müþteri Doðrulandý!, > Sisteme Eriþim Ýzini Verildi!");

	}

	@Override
	public List<Customer> getAll() {

		return customerDao.getAll();

	}

	@Override
	public Customer get(int id) {

		return customerDao.get(id);
	}

	@Override
	public Customer getPasswordByEmail(String email, String password) {

		return customerDao.getPasswordByEmail(email, password);

	}

}
