package ordersystem;

import java.math.BigDecimal;

public class OrderLine {

	private Product product;
	private int quantity;
	
	public OrderLine(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public BigDecimal getLineTotal() {
		return getProduct().getPrice().multiply(new BigDecimal(getQuantity()));
	}
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	} 
}
