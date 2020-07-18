package Ropa.Ascari.TechStore.Services;

import java.util.List;
import Ropa.Ascari.TechStore.Entities.*;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import Ropa.Ascari.TechStore.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public  class CustomerService {
	
	@Autowired
	protected CustomerRepository repo;
		
	public Customer addCus(Customer customer) {
		return repo.save(customer);	
	}

	public List<Customer> getAll() {
		return repo.findAll();
	}
	
	@Transactional
	public Customer getSingle(String username) {
		Customer response =  repo.FindByUsername(username);
		return response;	
	}
	
	
	public Customer updateCus(String username, Customer info) {
		Customer response =  repo.FindByUsername(username);
		if(!response.equals(null)){
			response.setFirstname(info.getFirstname());
			response.setLastname(info.getLastname());
			response.setUsername(info.getUsername());
			response.setPassword(info.getPassword());
			response.setEmail(info.getEmail());	
		   }
		 return repo.save(response);
	}
	
	//@Transactional
	public boolean deleteCus(String username) {
		Customer response = repo.FindByUsername(username);
		if(!response.equals(null))
	    {
			repo.delete(response);
		}
		return true;	
	}
	
	//@Transactional
	public boolean deleteAll() {
		for (Customer element : repo.findAll()) 
		    {
				repo.delete(element);
			}
		return true;
	 }
}
