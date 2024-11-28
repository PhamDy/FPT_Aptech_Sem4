package com.example.t2303e_spring.controller;

import com.example.t2303e_spring.model.request.ProductRequest;
import com.example.t2303e_spring.model.response.ProductResponse;
import com.example.t2303e_spring.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceImpl productService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.findAll().stream()
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping
    public void saveProducts(@RequestBody ProductRequest productRequest) {
        productService.save(productRequest);
    }

}
