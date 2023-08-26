package br.com.FatecRestAPI.FatecProjectAPI.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.FatecRestAPI.FatecProjectAPI.Entity.Customer;
import br.com.FatecRestAPI.FatecProjectAPI.Repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getInfoCustomer() {

        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {

        if (ValidateCustomer(customer)) {
            return customerRepository.saveAndFlush(customer);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "A renda mensal é obrigatoria e deve ser maior que zero!");
        }

    }

    public Boolean ValidateCustomer(Customer customer) {
        if (customer.getMonthtlyIncomeCustomer() != null &&
                customer.getMonthtlyIncomeCustomer().compareTo(BigDecimal.valueOf(0)) >= 0 &&
                customer.getPasswordCustomer() != null &&
                !customer.getPasswordCustomer().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public HashMap<String,Object> deleteCustomer(Long idCustomer){
        Optional<Customer> customer=  Optional.ofNullable(customerRepository.findById(idCustomer))
        .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
         "Cliente não encontrado"));

         customerRepository.delete(customer.get());
         HashMap<String,Object> result = new HashMap<>();
         result.put("result","Cliente "+customer.get().getFirtNameCustomer()+"" + customer.get().getLastNameCustomer() + "Excluido com sucesso");
         return result;
    }

    public Optional<Customer> findCustomerById(Long idCustomer){
        return Optional.ofNullable(customerRepository.findById(idCustomer)
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")));
    }

       public Customer updateCustomer(Customer customer) {

        if (ValidateCustomer(customer)) {
            if(findCustomerById(customer.getIdCustomer())!=null){
                    return customerRepository.saveAndFlush(customer);
            }else{
                return null;
            }
            
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "A renda mensal é obrigatoria e deve ser maior que zero!");
        }

    }

}
