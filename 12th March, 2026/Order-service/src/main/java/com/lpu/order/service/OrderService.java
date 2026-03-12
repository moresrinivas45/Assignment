package com.lpu.order.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.order.entity.Order;
import com.lpu.order.repository.OrderRepo;

@Service
public class OrderService {
	@Autowired
	private OrderRepo repo;
	@Autowired
	private BookFeignClient client;

	public Order create(Order order) {
		BookDTO dto = client.getBookById(order.getBookId());
		if (dto == null) {
			throw new RuntimeException("Book not found from BOOK-SERVICE");
		}

		double price = dto.getPrice();
		double total = price* order.getQuantity();
		order.setStatus("PLACED");
		order.setTotalPrice(total);
		order.setOrderDate(LocalDate.now());
		return repo.save(order);

	}

	public Order finddByID(long id) {
		return repo.findById(id).orElse(null);
	}

	public List<Order> finddAll() {
		return repo.findAll();
	}

	public Order update(long id, Order order) {
		Order o = repo.findById(id).orElse(null);
		o.setQuantity(order.getQuantity());
		o.setStatus(order.getStatus());
		return repo.save(o);
	}

	public void deleteeById(long id) {
		repo.deleteById(id);
	}

}
