package com.drkiettran.bookcatalog.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
	@JsonProperty("book_id")
	private String bookId;
	
	@JsonProperty("author")
	private String author;

	@JsonProperty("title")
	private String title;

	@JsonProperty("publisher")
	private String publisher;

	@JsonProperty("year")
	private int year;

	@JsonProperty("address")
	private String address;

	@JsonProperty("edition")
	private String edition;

	@JsonProperty("isbn")
	private String isbn;

	@JsonProperty("subtitle")
	private String subtitle;

	@JsonProperty("published")
	private Date published;

	@JsonProperty("pages")
	private int pages;

	@JsonProperty("description")
	private String description;

	@JsonProperty("file_location") 
	private String fileLocation;
	
	// exclude articles: a, an, the, one.
	@JsonProperty("total_words")
	private int totalWords;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
