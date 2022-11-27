package com.h2.testApp.controller;


import com.h2.testApp.entity.Customer;
import com.h2.testApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

            private final CustomerService customerService;

            @PostMapping(value = "/saveOrUpdate")
            public ResponseEntity<Void> saveOrUpdateCustomer(@RequestBody Customer customer){
                customerService.saveOrUpdateCustomer(customer);
                return new ResponseEntity<>(HttpStatus.OK);
            }

            @DeleteMapping(value = "/delete/{accountId}")
            public ResponseEntity<Void> deleteCustomer(@PathVariable("accountId") String accountId){
                customerService.deleteCustomer(Integer.parseInt(accountId));
                return new ResponseEntity<>(HttpStatus.OK);
            }

            @GetMapping(value = "/getAll")
            public ResponseEntity<List<Customer>> getAllCustomers(){
                List<Customer> allCustomers = customerService.getAllCustomers();
                return new ResponseEntity<>(allCustomers,HttpStatus.OK);
            }

            @GetMapping(value = "/getOne")
            public ResponseEntity<Customer> getOneCustomer(@RequestParam("accountId") String accountId){
              Customer customer =  customerService.getCustomer(Integer.parseInt(accountId));
                return ResponseEntity.ok(customer);


            }


}
