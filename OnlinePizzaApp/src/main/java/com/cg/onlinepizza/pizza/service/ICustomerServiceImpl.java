package com.cg.onlinepizza.pizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizza.pizza.Exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.pizza.dao.ICustomerRepository;
import com.cg.onlinepizza.pizza.dto.Customer;

/***************************************************************************************************************************
 * Class: ICustomerServiceImpl
 * Description: It is used to perform all the business logic in the service layer
 * Created By-BANHISHIKA CHANDA
 * Created Date -  15-05-2021 
 * 
 ***************************************************************************************************************************/

@Service
public class ICustomerServiceImpl implements ICustomerService {
	
	
	@Autowired
	ICustomerRepository customerRepo;

	/***************************************************************************************************************************
	 * Method: addCustomer 
	 * Description: It is used to add one customer details from customer table
	 * parameter customer: all customer details in the body of postman to customer bean and customer bean is sent as a parameter
	 * Returns Bean: It returns the customer details stored in the database
	 * Created By-BANHISHIKA CHANDA
     * Created Date -  15-05-2021 
	 * 
	 ***************************************************************************************************************************/
	@Override
	public Customer addCustomer(Customer customer) {
		Customer cust=customerRepo.save(customer);
		return cust;
	}
	
	/***************************************************************************************************************************
	 * Method: updateCustomer 
	 * Description: It is used to update one customer details from customer table if the id sent in the body matches
	 *              otherwise throw CustomerIdNotFoundException.
	 * parameter customer: all customer details in the body of postman to customer bean and customer bean is sent as a parameter
	 * Returns Bean: It returns the customer details stored in the database
	 * Created By-BANHISHIKA CHANDA
     * Created Date -  15-05-2021 
	 * 
	 ***************************************************************************************************************************/

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerIdNotFoundException {
		boolean b = customerRepo.existsById(customer.getCustomerId());
		if (!b) {
			throw new CustomerIdNotFoundException("No Customer found for this id");
		} else {
			return customerRepo.save(customer);
		}
	}
	
	/***************************************************************************************************************************
	 * Method: deleteCustomer 
	 * Description: It is used to delete one customer details from customer table if the id sent in the body matches
	 *              otherwise throw CustomerIdNotFoundException.
	 * parameter customer: The customer id to be deleted
	 * Returns : It returns the delete  message
	 * Created By-BANHISHIKA CHANDA
     * Created Date -  15-05-2021 
	 * 
	 ***************************************************************************************************************************/

	@Override
	public String deleteCustomer(int customerId) throws CustomerIdNotFoundException {
		boolean b = customerRepo.existsById(customerId);
		if (!b) {
			throw new CustomerIdNotFoundException("No Customer found for this id");
		} else {
			customerRepo.deleteById(customerId);
			return "Deleted Customer Successfully!";
		}
	}

	/***************************************************************************************************************************
	 * Method: viewCustomers
	 * Description: It is used to view all customer details from customer table
	 * Returns List: It returns the list of customer details stored in the database
	 * Created By-BANHISHIKA CHANDA
     * Created Date -  15-05-2021 
	 * 
	 ***************************************************************************************************************************/
	
	@Override
	public List<Customer> viewCustomers() {
		List<Customer> customer=customerRepo.findAll();
		return customer;
	}
	
	/***************************************************************************************************************************
	 * Method: viewCustomers
	 * Description: It is used to view one customer details from customer table which matches the customer id sent in the url 
	 *              otherwise throw CustomerIdNotFoundException.
	 * parameter customer: The customer id to be viewed
	 * Returns Customer: It returns the customer details stored in the database
	 * Created By-BANHISHIKA CHANDA
     * Created Date -  15-05-2021 
	 * 
	 ***************************************************************************************************************************/

	@Override
	public Optional<Customer> viewCustomer(int customerId) throws CustomerIdNotFoundException {
		return customerRepo.findById(customerId);
	}

}
