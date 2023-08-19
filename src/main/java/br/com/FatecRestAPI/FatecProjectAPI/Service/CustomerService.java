package br.com.FatecRestAPI.FatecProjectAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.FatecRestAPI.FatecProjectAPI.Entity.Customer;
import br.com.FatecRestAPI.FatecProjectAPI.Repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getInfoCustomer(){

        return customerRepository.findAll();
    }

}
