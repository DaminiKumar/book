package com.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="book")
@NamedQueries({
	@NamedQuery(name = "READ_ALL_Data", query = "SELECT bk from Book bk"),
	@NamedQuery(name = "READ_ALL_BOOK_TITLE", query = "SELECT bk.title from Book bk")
})

public class Book {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String title;
	
	@Column(name="price")
	private int price;
	
	@Column(name="description")
	private String desc;

	
	public Book(String title, int price, String desc) {
		super();
		this.title = title;
		this.price = price;
		this.desc = desc;
	}
	
	
	public Book() {
		super();
	}


	public Book(int id, String title, int price, String desc) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.desc = desc;
	}


	@Override
	public String toString() {
		return "book [id=" + id + ", title=" + title + ", price=" + price + ", desc=" + desc + "]";
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
