package com.pro.green.product.vo;

import java.sql.Date;

public class ProductVO {
	
	private String productId;
	private String group;
	private String productName;
	private int price;
	private int discount;
	private int productMileage;
	private int salesSum;
	private String discountYN;
	private Date productDate;
	
	public ProductVO() {
		
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getProductMileage() {
		return productMileage;
	}
	public void setProductMileage(int productMileage) {
		this.productMileage = productMileage;
	}
	public int getSalesSum() {
		return salesSum;
	}
	public void setSalesSum(int salesSum) {
		this.salesSum = salesSum;
	}
	public String getDiscountYN() {
		return discountYN;
	}
	public void setDiscountYN(String discountYN) {
		this.discountYN = discountYN;
	}
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
}
