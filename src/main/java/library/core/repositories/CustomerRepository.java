package library.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import library.core.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
public boolean existsByIdAndBooksId(Integer customerId,Integer bookId);	
public boolean existsByEmailAndPassword(String email,String password);
public boolean existsByEmail(String email);
public Optional<Customer> findByEmailAndPassword(String email,String password);

}
