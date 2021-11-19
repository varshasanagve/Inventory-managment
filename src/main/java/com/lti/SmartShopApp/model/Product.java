package com.lti.SmartShopApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="name", nullable = false)
	private String name;
	@Column(name = "category", nullable = false)
	private String category;
	@Column(name="quantity", nullable = false)
	private long qantity;
	@Column(name="unitprice", nullable = false)
	private long unitprice;
	@Column(name="totalprice", nullable = true)
	private long totalprice;
	@Column(name="rating", nullable = false)
	private long rating;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getQantity() {
		return qantity;
	}
	public void setQantity(long qantity) {
		this.qantity = qantity;
	}
	public long getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(long unitprice) {
		this.unitprice = unitprice;
	}
	public long getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(long totalprice) {
		this.totalprice = totalprice;
	}
	public long getRating() {
		return rating;
	}
	public void setRating(long rating) {
		this.rating = rating;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", qantity=" + qantity
				+ ", unitprice=" + unitprice + ", totalprice=" + totalprice + ", rating=" + rating + "]";
	}
	
	
	


}
