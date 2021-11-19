package ordersystem.totalcalculators;

import java.math.BigDecimal;
import java.util.List;

import ordersystem.OrderLine;
import ordersystem.interfaces.OrderTotalCalculator;

/** DefaultCalculator sums up the line total of all order lines */

public class DefaultCalculator implements OrderTotalCalculator {

	@Override
	public BigDecimal getTotal(List<OrderLine> orderLines) {
		BigDecimal total = new BigDecimal(0);
		for(OrderLine line : orderLines) {			
			total = total.add(line.getLineTotal());
		}
		return total;
	}
}