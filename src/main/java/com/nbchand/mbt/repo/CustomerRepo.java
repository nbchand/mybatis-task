package com.nbchand.mbt.repo;

import com.nbchand.mbt.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-07-20
 */
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
