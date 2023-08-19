package br.com.FatecRestAPI.FatecProjectAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.FatecRestAPI.FatecProjectAPI.Entity.Customer;
import br.com.FatecRestAPI.FatecProjectAPI.Service.CustomerService;

@RestController
@RequestMapping (value="/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> List(){
        
        return customerService.getInfoCustomer();
    }
}
