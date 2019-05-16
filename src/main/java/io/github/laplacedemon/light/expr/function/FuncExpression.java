package io.github.laplacedemon.light.expr.function;

import io.github.laplacedemon.light.expr.ItemExpression;
import io.github.laplacedemon.light.expr.atomic.PriorityExpression;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class FuncExpression extends ItemExpression {
	private String func;
	private PriorityExpression priorityExpression;
    
    public FuncExpression(String func, PriorityExpression priorityExpression) {
    	this.func = func;
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return  this.func + " < " + priorityExpression.toString() + " >";
    }

    @Override
    public Object eval() throws IncomputableException {
    	return null;
    }

	public String getFunc() {
		return func;
	}

	public PriorityExpression getPriorityExpression() {
		return priorityExpression;
	}
	
    
}
