package com.api.book.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
	
	@Id
	@Column(name="Author_id")
	private int Author_id;
	@Column(name="First_Name")
	private String First_Name;
	@Column(name="Last_Name")
	private String Last_Name;
	@Column(name="Language")
	private String Language;
	
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Book book;
	
	
	

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	public Author(int author_id, String first_Name, String last_Name, String language, Book book) {
		super();
		Author_id = author_id;
		First_Name = first_Name;
		Last_Name = last_Name;
		Language = language;
		this.book = book;
	}





	public int getAuthor_id() {
		return Author_id;
	}
	public void setAuthor_id(int author_id) {
		Author_id = author_id;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}





	@Override
	public String toString() {
		return "Author [Author_id=" + Author_id + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name
				+ ", Language=" + Language + "]";
	}

	
}
