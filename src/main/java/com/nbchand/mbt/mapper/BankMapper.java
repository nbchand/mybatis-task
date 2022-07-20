package com.nbchand.mbt.mapper;

import com.nbchand.mbt.pojo.BankResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-07-20
 */
@Mapper
public interface BankMapper {
    BankResponse findBankById(Integer id);
    List<BankResponse> findAllBank();
}
