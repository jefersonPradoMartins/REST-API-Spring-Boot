package br.com.FatecRestAPI.FatecProjectAPI.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.FatecRestAPI.FatecProjectAPI.Entity.Customer;
import br.com.FatecRestAPI.FatecProjectAPI.Exception.ResponseGenericException;
import br.com.FatecRestAPI.FatecProjectAPI.Service.CustomerService;


@RestController
@RequestMapping (value="/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping(value = "/list")
    public ResponseEntity<Object> List() {
        List<Customer> result = customerService.getInfoCustomer();
        return ResponseEntity.ok().body(ResponseGenericException.response(result));
    
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> saveCustomer(@RequestBody Customer customer){

        Customer result = customerService.saveCustomer(customer);
        return  ResponseEntity.status(HttpStatus.CREATED).body(ResponseGenericException.response(result));
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer){

        Customer result = customerService.updateCustomer(customer);
        return  ResponseEntity.status(HttpStatus.OK).body(ResponseGenericException.response(result));
    }

    @DeleteMapping(value = "/delete/{idCustomer}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long idCustomer){
        HashMap<String,Object> result  = customerService.deleteCustomer(idCustomer);
        return ResponseEntity.status(HttpStatus.OK).body((ResponseGenericException.response(result)));

    }

    @GetMapping(value="/findCustomer/{idCustomer}")
    public ResponseEntity<Object> getCustomerById(@PathVariable Long idCustomer) {
        Optional<Customer> result = customerService.findCustomerById(idCustomer);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseGenericException.response(result));
    }
    
    

}
