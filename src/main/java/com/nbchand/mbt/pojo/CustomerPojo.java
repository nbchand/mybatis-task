package com.nbchand.mbt.pojo;

import com.nbchand.mbt.model.Customer;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-07-20
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerPojo {
    private Integer id;
    private String name;
    private String location;
    private String accountNumber;

    public CustomerPojo(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.location = customer.getLocation();
        this.accountNumber = customer.getAccountNumber();
    }

    public static List<CustomerPojo> entityToPojoList(List<Customer> customers) {
        return customers.stream().map(customer -> new CustomerPojo(customer)).collect(Collectors.toList());
    }
}
