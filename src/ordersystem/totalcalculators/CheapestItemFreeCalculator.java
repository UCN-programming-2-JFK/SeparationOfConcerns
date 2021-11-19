package ordersystem.totalcalculators;

import java.util.List;
import ordersystem.OrderLine;
import ordersystem.Product;
import ordersystem.interfaces.OrderTotalCalculator;

/** CheapestItemFreeCalculator will subtract one of the cheapest items in the orderlines if more than one item exists */

public class CheapestItemFreeCalculator implements OrderTotalCalculator {

	@Override
	public float getTotal(List<OrderLine> orderLines) {
		float total = 0;
		for(OrderLine line : orderLines) {			
			total += line.getLineTotal();
		}
		if(orderLines.size() > 1) {
			Product cheapestItem = findCheapestProduct(orderLines);
			float discount = cheapestItem.getPrice();
			total = total - discount;	
		}
		return total;
	}

	private Product findCheapestProduct(List<OrderLine> orderLines) {
		if(orderLines.size()== 0) {throw new IllegalArgumentException("No orderlines in list!");}

		Product cheapestSoFar = orderLines.get(0).getProduct();

		for(int productCounter = 1; productCounter < orderLines.size(); productCounter++) {
			Product currentProduct = orderLines.get(productCounter).getProduct();
			if(currentProduct.getPrice() < cheapestSoFar.getPrice()) {
				cheapestSoFar = currentProduct;
			}
		}

		return cheapestSoFar;
	}
}