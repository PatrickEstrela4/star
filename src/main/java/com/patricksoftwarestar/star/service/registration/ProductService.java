package com.patricksoftwarestar.star.service.registration;

import com.patricksoftwarestar.star.dto.ProductDTO;
import com.patricksoftwarestar.star.model.Product;
import com.patricksoftwarestar.star.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService extends RegistrationService{

    @Autowired
    ProductRepository productRepository;

    public Product save(ProductDTO productDTO){
        var product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(UUID id) {
        return productRepository.findById(id);
    }

    public void deleteById(UUID id) {
        productRepository.deleteById(id);
    }
}
