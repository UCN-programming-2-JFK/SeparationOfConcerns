package ordersystem.interfaces;

import java.util.List;

import ordersystem.OrderLine;

public interface OrderTotalCalculatorStrategy {
	float getTotal(List<OrderLine> orderLines); 
}