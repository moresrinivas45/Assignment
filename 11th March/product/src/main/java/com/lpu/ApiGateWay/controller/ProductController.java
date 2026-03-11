package com.lpu.ApiGateWay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.lpu.ApiGateWay.entity.Payment;
//import com.lpu.ApiGateWay.entity.Product;
import com.lpu.ApiGateWay.entity.Product;
import com.lpu.ApiGateWay.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;
    
    
    @GetMapping("/feign")
    public String getttt() {
    	return "feignnnnnnnnnnn";
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product p) {
        return service.addProduct(p);
    }

    @GetMapping("/all")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/restTemp")
    public String Resttemplate() {
    	return "Rest Template executed";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return "Product Deleted";
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product p) {
        return service.updateProduct(p);
    }
    
    
    @GetMapping("/findAllPayments")
    public ResponseEntity<String> find(){
    	RestTemplate rest=new RestTemplate();
    	String url="http://localhost:8888/payment/payment/all";
    	ResponseEntity<String> response=rest.exchange(url, HttpMethod.GET, null,String.class);
    	return response;
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> findd(@PathVariable int id){
    	RestTemplate rest=new RestTemplate();
    	String url="http://localhost:8888/payment/payment/"+id;
    	ResponseEntity<String> response=rest.exchange(url, HttpMethod.GET, null,String.class);
    	return response;
    }
    
    @PostMapping("/sendPayment")
    public ResponseEntity<Payment> finddd(@RequestBody Payment p){
    	RestTemplate rest=new RestTemplate();
    	HttpEntity<Payment> req=new HttpEntity<>(p);
    	
    	String url="http://localhost:8888/payment/payment/add";
    	ResponseEntity<Payment> response=rest.exchange(url, HttpMethod.POST, req,Payment.class);
    	return response;
    }
}