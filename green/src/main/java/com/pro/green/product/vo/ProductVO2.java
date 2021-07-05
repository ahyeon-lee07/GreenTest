package com.pro.green.product.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("productVO")
public class ProductVO2 {

	// 상품 관련
	private String productId;
	private String p_group;
	private String productName;
	private int price;
	private int discount;
	private int productMileage;
	private int salesSum;
	private String discountYN;
	private Date productDate;
	private String showYN;

	// 상품 옵션 관련
	private String product_optionId;
	private String option;
	private int stock;

	// 이미지 관려
	private String ImageId;
	private String imgType;
	private String imgURL;

	public ProductVO2() {

	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getP_group() {
		return p_group;
	}

	public void setP_group(String p_group) {
		this.p_group = p_group;
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

	public String getShowYN() {
		return showYN;
	}

	public void setShowYN(String showYN) {
		this.showYN = showYN;
	}

	public String getProduct_optionId() {
		return product_optionId;
	}

	public void setProduct_optionId(String product_optionId) {
		this.product_optionId = product_optionId;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImageId() {
		return ImageId;
	}

	public void setImageId(String imageId) {
		ImageId = imageId;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

}
