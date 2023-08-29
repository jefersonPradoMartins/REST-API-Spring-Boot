package br.com.FatecRestAPI.FatecProjectAPI.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.FatecRestAPI.FatecProjectAPI.Entity.Product;
import br.com.FatecRestAPI.FatecProjectAPI.Repository.ProductRepository;

@Service
public class ProductService  {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> GetInfoProduct(){

        return productRepository.findAll();
    }

    public Product saveProduct(Product product){
        if(ValidadeProduct(product)){
            return  productRepository.saveAndFlush(product);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O preço do produto é obrigatorio");
        }
    }


    public HashMap<String,Object> deleteProduct(Long idProduct){
        Optional<Product> product = Optional.ofNullable(productRepository.findById(idProduct))
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    productRepository.delete(product.get());

    HashMap<String,Object> result = new HashMap<>();
    result.put("result", "Produto "+product.get().getNameProduct()+" Excluido com sucesso");
    return result;

    }

    public Optional<Product> findProductById(Long idProduct){
        return Optional.ofNullable(productRepository.findById(idProduct)
        .orElseThrow(()-> new ResponseStatusException(
            HttpStatus.NOT_FOUND,"Cliente não encontrado")));
    }

    public Product updateProduct(Product product){
        if(ValidadeProduct(product)){
            if(findProductById(product.getIdProduct()) != null){
                return productRepository.saveAndFlush(product);
            }else{
                return null;
            }
        }
     else {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
        "Produto não encontrado");
    }
}

    public Boolean ValidadeProduct(Product product){
        if(product.getCostPriceProduct().compareTo(BigDecimal.valueOf(0))>= 0 ){
            return true;
        }else{
            return false;
        }
    }
    
}
