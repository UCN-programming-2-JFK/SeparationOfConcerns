package ordersystem;

import java.util.ArrayList;
import java.util.List;

import ordersystem.interfaces.Order;
import ordersystem.interfaces.OrderTotalCalculator;
import ordersystem.totalcalculators.DefaultCalculator;

public class ConcreteOrder implements Order {
	private List<OrderLine> orderlines = new ArrayList<OrderLine>();
	private OrderTotalCalculator totalsCalculator;
	
	public ConcreteOrder(OrderTotalCalculator totalsCalculator) {
		super();
		this.totalsCalculator = totalsCalculator;
	}
	
	public ConcreteOrder() {this(new DefaultCalculator());}

	
	public List<OrderLine> getOrderlines() {
		return orderlines;
	}
	public void addProducts(Product product, int quantity) {
		addOrderLine(new OrderLine(product, quantity));
	}
	public void addOrderLine(OrderLine orderline) {
		this.orderlines.add(orderline);
	}
	public OrderTotalCalculator getTotalsCalculator() {
		return totalsCalculator;
	}
	public void setTotalsCalculator(OrderTotalCalculator totalsCalculator) {
		this.totalsCalculator = totalsCalculator;
	}
	
	public float getOrderTotal()
	{
		return getTotalsCalculator().getTotal(getOrderlines());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(OrderLine line : getOrderlines()) {
			sb.append(line.toString() + "\n");
		}
		sb.append("Order total: $" + getOrderTotal() + "\n");
		return sb.toString();
	}
}