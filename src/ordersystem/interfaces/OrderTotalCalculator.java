package ordersystem.interfaces;

import java.math.BigDecimal;
import java.util.List;

import ordersystem.OrderLine;

public interface OrderTotalCalculator {
	BigDecimal getTotal(List<OrderLine> orderLines); 
}