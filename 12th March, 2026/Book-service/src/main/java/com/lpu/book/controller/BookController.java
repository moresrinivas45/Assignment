package com.lpu.book.controller;

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

import com.lpu.book.entity.Book;
import com.lpu.book.service.BookService;
@RequestMapping("/api/books")
@RestController
public class BookController {
	@Autowired
	private BookService service;
	@PostMapping
	public ResponseEntity<Book> save(@RequestBody Book book){
		return ResponseEntity.ok(service.create(book));
	}
	@GetMapping("/{id}")
	public ResponseEntity<Book> findByID(@PathVariable long id){
		return ResponseEntity.ok(service.finddById(id));
	}
	@GetMapping
	public ResponseEntity<List<Book>> findAll(){
		return ResponseEntity.ok(service.finddAll());
	}
	@PutMapping("/{id}")
	public ResponseEntity<Book> updatee(@PathVariable long id,@RequestBody Book book){
		return ResponseEntity.ok(service.update(id, book));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		service.deleteByyID(id);
		return ResponseEntity.ok("Deleted Book by id :"+id);
	}
	

}
