package com.nbchand.mbt.service.bank;

import com.nbchand.mbt.pojo.BankRequest;
import com.nbchand.mbt.pojo.BankResponse;
import com.nbchand.mbt.service.GenericService;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-07-20
 */
public interface BankService extends GenericService<BankRequest, BankResponse> {
    BankResponse findByIdAnnotation(Integer id);
    List<BankResponse> findAllAnnotation();
}
