package com.api.book.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.Dao.BookRepository;
import com.api.book.entities.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> findAll = (List<Book>) this.bookRepository.findAll();
		return findAll;
	}

	public Book getBookById(int id) {

		Book book = null;
		try {

			book = this.bookRepository.findBookById(id);
			return book;
		} catch (Exception e) {
			System.out.println("Error in getBookById: " + e.getMessage());
			return null;
		}

	}

	public Book addbook(Book book) {
		try {
			Book result = bookRepository.save(book);
			return result;
		} catch (Exception e) {
			System.out.println("Error in addBook: " + e.getMessage());
			return null;
		}
	}
		
	public Book deleteBook(int id) {
	    try {
	        Book deletedBook = bookRepository.findById(id).orElse(null);
	        if (deletedBook != null) {
	            bookRepository.deleteById(id);
	            return deletedBook;
	        } else {
	            return null;
	        }
	    } catch (Exception e) {
	        System.out.println("Error in deleteBook: " + e.getMessage());
	        return null;
	    }
	}
	
	 public void updatebook(Book book, int id)
	 {
		 try {
			 	book.setId(id);
				bookRepository.save(book);
			} catch (Exception e) {
				System.out.println("Error in updateBook: " + e.getMessage());
				}
	 }
}
