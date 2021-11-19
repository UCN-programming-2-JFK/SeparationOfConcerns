package ordersystem.interfaces;

import java.util.List;

import ordersystem.OrderLine;

public interface OrderTotalCalculator {
	float getTotal(List<OrderLine> orderLines); 
}