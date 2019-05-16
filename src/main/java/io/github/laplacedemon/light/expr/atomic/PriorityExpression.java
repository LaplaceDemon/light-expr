package io.github.laplacedemon.light.expr.atomic;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.ItemExpression;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class PriorityExpression extends ItemExpression {
    private BaseExpression baseExpression;
    
    PriorityExpression(BaseExpression baseExpression) {
        this.baseExpression = baseExpression;
    }
    
    @Override
    public String toString() {
        return baseExpression.toString();
    }

    @Override
    public Object eval() throws IncomputableException {
        return baseExpression.eval();
    }

	public BaseExpression getBaseExpression() {
		return baseExpression;
	}
    
}
