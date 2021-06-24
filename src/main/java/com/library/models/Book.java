package com.library.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books", schema = "library")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String author;
	private String publisher;
	private String language;
	private int pages;
	private int count;
	private String isbn10;
	private String isbn13;
	
	public Book() {
		super();
	}
	public Book(int id, String title, String author, String publisher, String language, int pages, int count,
			String isbn10, String isbn13) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.language = language;
		this.pages = pages;
		this.count = count;
		this.isbn10 = isbn10;
		this.isbn13 = isbn13;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getIsbn10() {
		return isbn10;
	}
	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, count, id, isbn10, isbn13, language, pages, publisher, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && count == other.count && id == other.id
				&& Objects.equals(isbn10, other.isbn10) && Objects.equals(isbn13, other.isbn13)
				&& Objects.equals(language, other.language) && pages == other.pages
				&& Objects.equals(publisher, other.publisher) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", language="
				+ language + ", pages=" + pages + ", count=" + count + ", isbn10=" + isbn10 + ", isbn13=" + isbn13
				+ "]";
	}
}
