package br.com.FatecRestAPI.FatecProjectAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.FatecRestAPI.FatecProjectAPI.Entity.Product;
import br.com.FatecRestAPI.FatecProjectAPI.Exception.ResponseGenericException;
import br.com.FatecRestAPI.FatecProjectAPI.Service.ProductService;


@RestController
@RequestMapping(value= "/api/v1/product")
public class ProductController {
    

    @Autowired
    private ProductService productService;

    @GetMapping(value="/list")
    public ResponseEntity<Object> List (){
        
        java.util.List<Product> result = productService.GetInfoProduct();
        return ResponseEntity.ok()
        .body(ResponseGenericException.response(result));
    }

    @PostMapping(value="/create")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product){
        
        Product result = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(ResponseGenericException.response(result));
    }

    @PostMapping(value="/update")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        Product result = productService.updateProduct(product);

        
        return ResponseEntity.status(HttpStatus.OK)
        .body(ResponseGenericException.response(result));
    }
    
    
}
