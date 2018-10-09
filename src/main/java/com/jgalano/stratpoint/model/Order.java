package com.jgalano.stratpoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="orders")
@Table(name="orders")
public class Order extends Auditable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="transaction_id")
	private String transactionId;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ordered_by")
	private User orderedBy;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="shop_id")
	private Shop shop;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Product product;

	public Order() {
	}

	public Order(String transactionId, String status, User orderedBy, Shop shop, Product product) {
		super();
		this.transactionId = transactionId;
		this.status = status;
		this.orderedBy = orderedBy;
		this.shop = shop;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getOrderedBy() {
		return orderedBy;
	}

	public void setOrderedBy(User orderedBy) {
		this.orderedBy = orderedBy;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
