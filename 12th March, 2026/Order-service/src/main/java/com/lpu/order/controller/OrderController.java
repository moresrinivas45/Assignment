package com.lpu.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.order.entity.Order;
import com.lpu.order.service.BookFeignClient;
import com.lpu.order.service.OrderService;

@RequestMapping("/api/orders")
@RestController
public class OrderController {
	@Autowired
	private OrderService service;

	@PostMapping
	public ResponseEntity<Order> save(@RequestBody Order order) {
		return ResponseEntity.ok(service.create(order));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable long id) {
		return ResponseEntity.ok(service.finddByID(id));
	}

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		return ResponseEntity.ok(service.finddAll());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Order> update(@PathVariable long id, @RequestBody Order order) {
		return ResponseEntity.ok(service.update(id, order));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		return ResponseEntity.ok("Deleted Order By id" + id);
	}

}
