package com.lpu.ApiGateWay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.lpu.ApiGateWay.entity.Payment;
import com.lpu.ApiGateWay.service.PaymentService;
import com.lpu.ApiGateWay.service.ProductFeignClientService;
import com.netflix.discovery.converters.Auto;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private ProductFeignClientService clientService;
	
	@GetMapping("/feignPayment")
	public String getProductInPayment() {
		return clientService.getttt();
	}
	
	

    @Autowired
    private PaymentService service;
    @GetMapping("/get")
    public ResponseEntity<String> gett(){
    	RestTemplate rest=new RestTemplate();
    	String url="http://localhost:8888/product/product/restTemp";
    	ResponseEntity<String> response=rest.exchange(url, HttpMethod.GET, null, String.class);
    	return response;
    	
    }
    @PostMapping("/add")
    public Payment addPayment(@RequestBody Payment p) {
        return service.savePayment(p);
    }

    @GetMapping("/all")
    public List<Payment> getAllPayments() {
    	System.err.println("hiiiiiiiiiiiiiiiiiiii");
        return service.getAllPayments();
    }
    
    @GetMapping("/{id}")
    public Payment getById(@PathVariable int id) {
    	return service.findbyId(id);
    }
    
    

    @DeleteMapping("/delete/{id}")
    public String deletePayment(@PathVariable int id) {
        service.deletePayment(id);
        return "Payment Deleted";
    }

    @PutMapping("/update")
    public Payment updatePayment(@RequestBody Payment p) {
        return service.updatePayment(p);
    }
}