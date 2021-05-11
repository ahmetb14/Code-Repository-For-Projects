package nLayeredECommerceSystem.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import nLayeredECommerceSystem.dataAccess.abstracts.CustomerDao;
import nLayeredECommerceSystem.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao {

	List<Customer> customers = new ArrayList<Customer>();

	public HibernateCustomerDao(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public void add(Customer customer) {

		customers.add(customer);
		System.out.println("> Hibernate Sistemi ile Eklendi! : " + customer.getFirstName());

	}

	@Override
	public void update(Customer customer) {

		Customer customerToUpdate = get(customer.getId());
		customerToUpdate.setFirstName(customer.getFirstName());
		customerToUpdate.setLastName(customer.getLastName());
		System.out.println("> Hibernate Sistemi ile Güncellendi! : " + customer.getFirstName());

	}

	@Override
	public void delete(Customer customer) {

		customers.removeIf(obj -> obj.getId() == customer.getId());
		System.out.println("> Hibernate Sistemi ile Silindi! : " + customer.getFirstName());

	}

	@Override
	public List<Customer> getAll() {
		return customers;
	}

	@Override
	public Customer getPasswordByEmail(String email, String password) {
		for (Customer customer : customers) {

			if (customer.getEmail() == email && customer.getPassword() == password) {

				return customer;
			}

		}

		return null;

	}

	@Override
	public Customer get(int id) {

		for (Customer customer : customers) {

			if (customer.getId() == id) {

				return customer;

			}

		}

		return null;

	}

}
