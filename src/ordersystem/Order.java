package ordersystem;
import java.math.BigDecimal;
import java.util.List;
import ordersystem.interfaces.OrderTotalCalculator;

public class Order {
	private List<OrderLine> orderlines;
	private OrderTotalCalculator totalsCalculator;
	
	public Order(List<OrderLine> orderlines, OrderTotalCalculator totalsCalculator) {
		super();
		this.orderlines = orderlines;
		this.totalsCalculator = totalsCalculator;
	}
	public List<OrderLine> getOrderlines() {
		return orderlines;
	}
	public void setOrderlines(List<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}
	public OrderTotalCalculator getTotalsCalculator() {
		return totalsCalculator;
	}
	public void setTotalsCalculator(OrderTotalCalculator totalsCalculator) {
		this.totalsCalculator = totalsCalculator;
	}
	
	public BigDecimal getOrderTotal()
	{
		return getTotalsCalculator().getTotal(getOrderlines());
	}
}