package Ropa.Ascari.TechStore.Repositories;
import Ropa.Ascari.TechStore.Entities.Customer;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional(readOnly = true)
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Customer FindByUsername(String username) {
    	  TypedQuery<Customer> query = entityManager.createQuery(
    		        "SELECT u FROM Customer u WHERE u.username = :username", Customer.class);
    		    return query.setParameter("username", username).getSingleResult();
    }
}