package Ropa.Ascari.TechStore.Repositories;
import Ropa.Ascari.TechStore.Entities.Customer;

public interface CustomerRepositoryCustom {
	
	Customer FindByUsername(String username);
}
