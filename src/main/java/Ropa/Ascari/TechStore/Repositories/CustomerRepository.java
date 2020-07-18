package Ropa.Ascari.TechStore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import Ropa.Ascari.TechStore.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>,CustomerRepositoryCustom  {
	

}
 