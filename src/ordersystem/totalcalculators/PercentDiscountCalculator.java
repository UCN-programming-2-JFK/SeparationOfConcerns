package ordersystem.totalcalculators;

import java.math.BigDecimal;
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
	public BigDecimal getTotal(List<OrderLine> orderLines) {
		BigDecimal total = new BigDecimal(0);
		for(OrderLine line : orderLines) {			
			total = total.add(line.getLineTotal());
		}
		BigDecimal discount = total.multiply(new BigDecimal(getPercentageDiscount()));
		return total.subtract(discount);
	}

	public float getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(float percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}
}