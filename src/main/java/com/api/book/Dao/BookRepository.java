package com.api.book.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.api.book.entities.Book;


public interface BookRepository extends JpaRepository<Book, Integer>{
	
	//Custom finder methods
	public Book findBookById(int id);
}
