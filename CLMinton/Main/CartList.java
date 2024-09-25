package main;

public class CartList {
	
	String productID;
	String name;
	String brand;
	Integer price;
	Integer quantity;
	Integer total;
	
	public CartList(String productID, String name, String brand, Integer price, Integer quantity, Integer total) {
		super();
		this.productID = productID;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	

}
