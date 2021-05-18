package com.cg.onlinepizza.pizza.service;
import java.util.List;
import java.util.Optional;
import com.cg.onlinepizza.pizza.Exceptions.CustomerIdNotFoundException;
import com.cg.onlinepizza.pizza.dto.Customer;

/***************************************************************************************************************************
 * Interface: ICustomerService
 * Description: It is specified all the business logic in the service layer
 * Created By-BANHISHIKA CHANDA
 * Created Date -  15-05-2021 
 * 
 ***************************************************************************************************************************/

public interface ICustomerService {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer customer) throws CustomerIdNotFoundException;

	String deleteCustomer(int customerId) throws CustomerIdNotFoundException;

	List<Customer> viewCustomers();

	Optional<Customer> viewCustomer(int customerId) throws CustomerIdNotFoundException;
}
