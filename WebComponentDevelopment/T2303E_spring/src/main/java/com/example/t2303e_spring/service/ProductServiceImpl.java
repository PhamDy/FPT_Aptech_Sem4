package com.example.t2303e_spring.service;

import com.example.t2303e_spring.entity.Product;
import com.example.t2303e_spring.model.request.ProductRequest;
import com.example.t2303e_spring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(ProductRequest productRequest) {
        Product product = modelMapper.map(productRequest, Product.class);
        productRepository.save(product);
    }

}
