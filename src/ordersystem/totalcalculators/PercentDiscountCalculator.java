package ordersystem.totalcalculators;

import java.util.List;
import ordersystem.OrderLine;
import ordersystem.interfaces.OrderTotalCalculator;

/** DefaultCalculator sums up the line total of all order lines and subtracts the discount */

public class PercentDiscountCalculator implements OrderTotalCalculator {

	private float percentageDiscount;
	
	public PercentDiscountCalculator(float percentageDiscount) {
		super();
		this.percentageDiscount = percentageDiscount;
	}

	@Override
	public float getTotal(List<OrderLine> orderLines) {
		float total = 0;
		for(OrderLine line : orderLines) {			
			total += line.getLineTotal();
		}
		float discount = total * getPercentageDiscount();
		return total - discount;
	}

	public float getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(float percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}
}