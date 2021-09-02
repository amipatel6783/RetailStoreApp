package com.retailstore.model;

import com.retailstore.enumeration.ProductTypes;

public class Product {
	
	private int productCode;
	private String productName;
	private double productPrice;
	private ProductTypes productType;
	
	
	public Product(int productCode, String productName, double productPrice, ProductTypes productType) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productType = productType;
	}


	public int getProductCode() {
		return productCode;
	}


	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public ProductTypes getProductType() {
		return productType;
	}


	public void setProductType(ProductTypes productType) {
		this.productType = productType;
	}


	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productType=" + productType + "]";
	}
	
	
	

}
