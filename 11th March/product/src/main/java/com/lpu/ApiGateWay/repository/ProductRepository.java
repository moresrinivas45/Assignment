package com.lpu.ApiGateWay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.ApiGateWay.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}