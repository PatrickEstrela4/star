package com.patricksoftwarestar.star.service;

import com.patricksoftwarestar.star.dto.ProductDTO;
import com.patricksoftwarestar.star.model.Product;
import com.patricksoftwarestar.star.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(ProductDTO productDTO){
        var productModel = new Product();
        BeanUtils.copyProperties(productDTO, productModel);
        return productRepository.save(productModel);
    }
}
