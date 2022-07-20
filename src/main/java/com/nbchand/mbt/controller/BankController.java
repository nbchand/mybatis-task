package com.nbchand.mbt.controller;

import com.nbchand.mbt.pojo.BankRequest;
import com.nbchand.mbt.pojo.BankResponse;
import com.nbchand.mbt.service.bank.BankService;
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
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;

    @PostMapping("/save")
    public ResponseEntity<BankRequest> saveBank(@RequestBody BankRequest bankRequest) {
        return ResponseEntity.ok(bankService.save(bankRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankResponse> findBankById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(bankService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<BankResponse>> findAllBank() {
        return ResponseEntity.ok(bankService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteBankById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(bankService.delete(id));
    }
}
