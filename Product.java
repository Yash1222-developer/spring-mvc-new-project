package com.online.shopping.portal.entity;

import javax.persistence.*;
import javax.persistence.Transient;

@Entity
@Table(name="tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int productId;

    @Column(name = "pro_nm", nullable = false)
    private String productName;

    @Column(name = "pro_desc", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "pro_sto", nullable = false)
    private int stock;

    @Column(name = "pro_img", nullable = false)
    private String imagePath;

    @Column(name = "pro_status", nullable = false)
    private String status;

    // --- NEW Fields for Cart ---
    @Transient
    private int quantity;

    @Transient
    private double total;

    // --- Getters & Setters ---
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    // --- Constructors ---
    public Product() { super(); }

    public Product(int productId, String productName, String description, double price, int stock, String imagePath, String status) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.imagePath = imagePath;
        this.status = status;
    }
}
