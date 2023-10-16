package com.mindtree.entity;

import java.util.Objects;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="productId")
public class Book  extends Product{
  
	
	private String genre;
	private String author;
	private String publication;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int productId, String productName, float price, String category) {
		super(productId, productName, price, category);
		// TODO Auto-generated constructor stub
	}
	public Book(String genre, String author, String publications) {
		super();
		this.genre = genre;
		this.author = author;
		this.publication = publications;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(author, genre, publication);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(genre, other.genre)
				&& Objects.equals(publication, other.publication);
	}
	@Override
	public String toString() {
		return "Book [genre=" + genre + ", author=" + author + ", publication=" + publication + "]";
	}
	@Override
	public int compareTo(Product that) {
		// TODO Auto-generated method stub
		return (int) (this.getPrice()-that.getPrice());
	}
	
}
