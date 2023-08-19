package br.com.FatecRestAPI.FatecProjectAPI.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.FatecRestAPI.FatecProjectAPI.Entity.Customer;

public interface CustomerRepository extends JpaRepository <Customer, Long> {
    
}
