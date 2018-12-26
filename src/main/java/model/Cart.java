package model;

public class Cart {
		
	private int id,quantity,productid;
	private String username,saddress, baddress ;
	
	private Product product;
	
	
	
	   @Override
	public String toString() {
		return "Cart [id=" + id + ", quantity=" + quantity + ", productid=" + productid + ", username=" + username
				+ ", saddress=" + saddress + ", baddress=" + baddress + ", product=" + product + "]";
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getBaddress() {
		return baddress;
	}
	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}
	
	

}
