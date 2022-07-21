package com.nbchand.mbt.service.bank;

import com.nbchand.mbt.mapper.BankMapper;
import com.nbchand.mbt.model.Bank;
import com.nbchand.mbt.model.Customer;
import com.nbchand.mbt.pojo.BankRequest;
import com.nbchand.mbt.pojo.BankResponse;
import com.nbchand.mbt.repo.BankRepo;
import com.nbchand.mbt.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-07-20
 */
@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepo bankRepo;
    private final CustomerRepo customerRepo;
    private final BankMapper bankMapper;

    @Override
    public BankRequest save(BankRequest bankRequest) {
        List<Customer> customerList = customerRepo.findAllById(bankRequest.getCustomers());
        Bank bank = Bank.builder()
                .id(bankRequest.getId())
                .name(bankRequest.getName())
                .location(bankRequest.getLocation())
                .customers(customerList)
                .build();
        bank = bankRepo.save(bank);
        bankRequest.setId(bank.getId());
        return bankRequest;
    }

    @Override
    public BankResponse findById(Integer id) throws Exception {
        return bankMapper.findBankById(id);
    }

    @Override
    public List<BankResponse> findAll() {
        return bankMapper.findAllBank();
    }

    @Override
    public Integer delete(Integer id) throws Exception {
        Bank bank = bankRepo.findById(id).orElseThrow(()-> new Exception("Invalid Bank id"));
        bankRepo.delete(bank);
        return bank.getId();
    }

    @Override
    public BankResponse findByIdAnnotation(Integer id) {
        return bankMapper.findBankByIdAnnotation(id);
    }

    @Override
    public List<BankResponse> findAllAnnotation() {
        return bankMapper.findAllBankAnnotation();
    }
}
