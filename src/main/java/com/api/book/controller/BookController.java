package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.api.book.entities.Book;
import com.api.book.services.BookService;


@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	public BookService bookService;
	

	// get all books
	@GetMapping
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = this.bookService.getAllBooks();
		System.out.println(list);
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	// get single book by id
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	// post a book
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {

		Book b = null;
		try {
			b = bookService.addbook(book);
			System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// delete a book
	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") int id) {
	    try {
	        Book deletedBook = this.bookService.deleteBook(id);
	        return ResponseEntity.ok().body(deletedBook);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	// update a book details
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook                        
	(@RequestBody Book book, @PathVariable("id") int id) {
		try
		{
			this.bookService.updatebook(book, id);
			return ResponseEntity.ok().body(book);
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	

	/*
	 * @PostMapping("/upload-file") public ResponseEntity<String>
	 * handleUpload(@RequestParam("file") MultipartFile file) {
	 * 
	 * try { if (file.isEmpty()) { return
	 * ResponseEntity.badRequest().body("Please select a file to upload"); }
	 * 
	 * if (!file.getContentType().equals("image/jpeg")) { return
	 * ResponseEntity.badRequest().body("Upload Jpeg file Only"); }
	 * 
	 * System.out.println(file.getOriginalFilename());
	 * System.out.println(file.getSize());
	 * System.out.println(file.getContentType());
	 * 
	 * // code to file upload to folder
	 * 
	 * boolean uploadFile = fileUploadHelper.uploadFile(file);
	 * 
	 * if (uploadFile) { //return ResponseEntity.ok("file uploaded successfully");
	 * 
	 * return
	 * ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path(
	 * "/image/").path(file.getOriginalFilename()).toUriString()); } else { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Failed to upload file"); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Something went wrong"); } }
	 */
	
}
