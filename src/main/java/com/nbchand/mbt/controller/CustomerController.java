package com.nbchand.mbt.controller;

import com.nbchand.mbt.pojo.CustomerPojo;
import com.nbchand.mbt.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-07-20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<CustomerPojo> saveCustomer(@RequestBody CustomerPojo customerPojo) {
        return ResponseEntity.ok(customerService.save(customerPojo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerPojo> findBankById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerPojo>> findAllBank() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteBankById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(customerService.delete(id));
    }
}
