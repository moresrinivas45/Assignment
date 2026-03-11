package com.lpu.ApiGateWay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.ApiGateWay.entity.Product;
import com.lpu.ApiGateWay.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product addProduct(Product p) {
        return repo.save(p);
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public Product updateProduct(Product p) {
        return repo.save(p);
    }
}