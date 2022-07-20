package com.nbchand.mbt.repo;

import com.nbchand.mbt.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-07-20
 */
public interface BankRepo extends JpaRepository<Bank, Integer> {
}
