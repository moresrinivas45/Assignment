package com.lpu.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.book.entity.Book;
import com.lpu.book.repository.BookRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo repo;

	public Book create(com.lpu.book.entity.Book book) {
		return repo.save(book);
	}

	public Book finddById(long id) {
		return repo.findById(id).orElse(null);
	}

	public List<Book> finddAll() {
		return repo.findAll();
	}

	public Book update(long id, Book book) {
		Book b = repo.findById(id).orElse(null);
		b.setAuthor(book.getAuthor());
		b.setCategory(book.getCategory());
		b.setIsbn(book.getIsbn());
		b.setPrice(book.getPrice());
		b.setQuantity(book.getQuantity());
		b.setTitle(book.getTitle());
		return repo.save(b);
	}

	public void deleteByyID(long id) {
		repo.deleteById(id);
	}

}
