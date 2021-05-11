package nLayeredECommerceSystem.simulatedDatabase;

import java.util.ArrayList;
import java.util.List;

import nLayeredECommerceSystem.entities.concretes.Customer;

public class SimulatedDatabase {
	
	static List<Customer> customersRecords = new ArrayList<Customer>();
	static List<Customer> customersList = new ArrayList<Customer>();
	
	static Customer customer1 = new Customer(1, "Ahmet Berkay", "Yýlmaz", "ahmetbekay26@ahmet.com", "951753");

	static Customer customer2 = new Customer(2, "Görkem", "Öcal", "görkem26@görkem.com", "159753");

	static Customer customer3 = new Customer(3, "Mustafa Berk", "Akgül", "mustafaberk26@mustafa.com", "753951");
	
	
	public static List<Customer> GetCustomerRecordsList(){
		

		customersRecords.add(customer1);
		customersRecords.add(customer2);
		customersRecords.add(customer3);
	

		return customersRecords;
	}
	
	public static List<Customer>  GetCustomerList() {
		
		customersList.add(customer1);
		customersList.add(customer2);
		customersList.add(customer3);
		
		return customersList;
	}
}
