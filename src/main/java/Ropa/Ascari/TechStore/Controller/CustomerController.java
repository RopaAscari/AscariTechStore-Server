package Ropa.Ascari.TechStore.Controller;

import Ropa.Ascari.TechStore.Entities.*;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import Ropa.Ascari.TechStore.Services.CustomerService;


@EnableWebMvc
@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
public class CustomerController {	

@Autowired
protected CustomerService service;

	@PostMapping("")
	public Customer creatcusacc(@Valid @RequestBody Customer data){
		return service.addCus(data);
	}
	
	@GetMapping("")
	public List<Customer> getAll() {
		return service.getAll();
		}
	
	@GetMapping("/{username}")
	public Customer getOne(@PathVariable("username") String username) {
		
		Customer data = service.getSingle(username);
		if(data == null)
		{
			throw new ResourceNotFoundException();
		}
		return data;
	}
	
	@PutMapping("/{username}")
	public Customer Update(@PathVariable("username") String username, Customer info)
	{
		return service.updateCus(username, info);
	}
	
	@DeleteMapping("/{username}")
	public ResponseEntity<?> Delete(@PathVariable("username") String id) {
		if(service.deleteCus(id))
		    return ResponseEntity.status(200).body(true);
		else
			return ResponseEntity.status(400).body(false);
	  }
	
	@DeleteMapping("")
	public ResponseEntity<?> DeleteAll() {
		if(service.deleteAll() == true)
		    return ResponseEntity.status(200).body(true);
		else
			return ResponseEntity.status(400).body(false);
	  }
  }

