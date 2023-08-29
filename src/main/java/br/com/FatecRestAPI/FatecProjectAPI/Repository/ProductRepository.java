package br.com.FatecRestAPI.FatecProjectAPI.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.FatecRestAPI.FatecProjectAPI.Entity.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {
    
}