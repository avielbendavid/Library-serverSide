package library.core.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import library.core.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	boolean existsByName(String name);

}
