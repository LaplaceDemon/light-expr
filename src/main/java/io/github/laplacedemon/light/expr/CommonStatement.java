package io.github.laplacedemon.light.expr;

import java.util.LinkedList;

import io.github.laplacedemon.light.expr.atomic.PriorityExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class CommonStatement extends BaseExpression {
	private LinkedList<BaseExpression> listExpression;

	public CommonStatement() {
		this.listExpression = new LinkedList<>();
	}
	
	@Override
	public BaseExpression join(BaseExpression baseExpression) throws ParseExpressionException {
		if(baseExpression instanceof PriorityExpression && this.listExpression.size() > 0) {
			BaseExpression lastBaseExpression = this.listExpression.getLast();
			BaseExpression joinExpression = lastBaseExpression.join(baseExpression);
			this.listExpression.removeLast();
			this.listExpression.add(joinExpression);
		} else {
			this.listExpression.add(baseExpression);
		}
		
		return this;
	}

	@Override
	public Object eval() throws IncomputableException {
		return null;
	}

	@Override
	public String toString() {
		return "[" + listExpression + "]";
	}

	public int size() {
		return this.listExpression.size();
	}

	public BaseExpression getIndex(int i) {
		return this.listExpression.get(i);
	}
	
}
