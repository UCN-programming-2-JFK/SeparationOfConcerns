package ordersystem.totalcalculators;

import java.math.BigDecimal;
import java.util.List;

import ordersystem.OrderLine;
import ordersystem.Product;
import ordersystem.interfaces.OrderTotalCalculator;

/** CheapestItemFreeCalculator will subtract one of the cheapest items in the orderlines if more than one item exists */

public class CheapestItemFreeCalculator implements OrderTotalCalculator {

	private float percentageDiscount;

	public CheapestItemFreeCalculator(float percentageDiscount) {
		super();
		this.percentageDiscount = percentageDiscount;
	}

	@Override
	public BigDecimal getTotal(List<OrderLine> orderLines) {
		BigDecimal total = new BigDecimal(0);
		for(OrderLine line : orderLines) {			
			total = total.add(line.getLineTotal());
		}
		if(orderLines.size() > 1) {
			Product cheapestItem = findCheapestProduct(orderLines);
			BigDecimal discount = cheapestItem.getPrice();
			total = total.subtract(discount);	
		}
		return total;
	}

	private Product findCheapestProduct(List<OrderLine> orderLines) {
		if(orderLines.size()== 0) {throw new IllegalArgumentException("No orderlines in list!");}

		Product cheapestSoFar = orderLines.get(0).getProduct();

		for(int productCounter = 1; productCounter < orderLines.size(); productCounter++) {
			Product currentProduct = orderLines.get(productCounter).getProduct();
			if(currentProduct.getPrice().compareTo(cheapestSoFar.getPrice()) == 1) {
				cheapestSoFar = currentProduct;
			}
		}

		return cheapestSoFar;
	}

	public float getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(float percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}
}