package com.lpu.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("BOOK-SERVICE")
public interface BookFeignClient {
	@GetMapping("/api/books/{id}")
	public BookDTO getBookById(@PathVariable long id);

}
