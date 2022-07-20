package com.nbchand.mbt.service.customer;

import com.nbchand.mbt.model.Customer;
import com.nbchand.mbt.pojo.CustomerPojo;
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
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Override
    public CustomerPojo save(CustomerPojo customerPojo) {
        Customer customer = Customer.builder()
                .id(customerPojo.getId())
                .name(customerPojo.getName())
                .location(customerPojo.getLocation())
                .accountNumber(customerPojo.getAccountNumber())
                .build();
        customer = customerRepo.save(customer);
        customerPojo.setId(customer.getId());
        return customerPojo;
    }

    @Override
    public CustomerPojo findById(Integer id) throws Exception {
        Customer customer = customerRepo.findById(id).orElseThrow(()-> new Exception("Invalid Customer Id"));
        return new CustomerPojo(customer);
    }

    @Override
    public List<CustomerPojo> findAll() {
        List<Customer> customers = customerRepo.findAll();
        return CustomerPojo.entityToPojoList(customers);
    }

    @Override
    public Integer delete(Integer id) throws Exception {
        Customer customer = customerRepo.findById(id).orElseThrow(()-> new Exception("Invalid Customer Id"));
        customerRepo.delete(customer);
        return customer.getId();
    }
}
