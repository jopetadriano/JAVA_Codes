package com.h2.testApp.service;

import com.h2.testApp.dao.CustomerDao;
import com.h2.testApp.entity.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerDao customerDao;

    public void saveOrUpdateCustomer(Customer customer){
        log.info("Inserting Customer object");
        customerDao.save(customer);

    }
    public List<Customer> getAllCustomers(){
        log.info("Finding all Customer objects");
        return customerDao.findAll();
    }
    public Customer getCustomer(int accountId){
        log.info("Finding specific Customer info by account id-{}", accountId);
        return customerDao.findById(accountId).orElse(null);
    }
    public void deleteCustomer(int accountId){
        log.info("Deleting Customer info by account Id");
        customerDao.deleteById(accountId);
    }
}
