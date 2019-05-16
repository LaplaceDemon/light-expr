package io.github.laplacedemon.light.expr.sql.order;

import io.github.laplacedemon.light.expr.atomic.SymbolExpression;

public class OrderByStatement extends SymbolExpression {
	private OrderType orderType;
	private SymbolExpression symbolExpression;
	
	public OrderByStatement(SymbolExpression symbolExpression, OrderType orderType) {
		this.symbolExpression = symbolExpression;
		this.orderType = orderType;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	@Override
	public String getValue() {
		return symbolExpression.getValue();
	}

	@Override
	public String toString() {
		return orderType.toString()  + " " + symbolExpression.toString();
	}
	
}
