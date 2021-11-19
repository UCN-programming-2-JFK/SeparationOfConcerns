package ordersystem;

public class OrderLine {

	private Product product;
	private int quantity;
	
	public OrderLine(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public float getLineTotal() {
		return getProduct().getPrice() * getQuantity();
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
	@Override
	public String toString() {
		return getQuantity() + " " + getProduct().toString();
	}
}