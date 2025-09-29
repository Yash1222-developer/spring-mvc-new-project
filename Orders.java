package com.online.shopping.portal.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_order")
public class Orders {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
    private int orderId;
	
	@Column(name = "pro_oder_id", nullable = false)
    private int productId;
	
	@Column(name = "order_quan", nullable = false)
    private int quantity;
	
	@Column(name = "order_to_price", nullable = false)
    private double totalPrice;
	
	@Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;
	
	@Column(name = "status", nullable = false)
	private String status;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Orders(int orderId, int productId, int quantity, double totalPrice, LocalDateTime orderDate, String status) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.status = status;
	}

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
