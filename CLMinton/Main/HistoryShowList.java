package main;

public class HistoryShowList {

	String ID;
    String product;
    Integer price;
    Integer quantity;
    Integer total;
    
	public HistoryShowList(String iD, String product, Integer price, Integer quantity, Integer total) {
		super();
		ID = iD;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
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
