package sjq.light.expr.function;

import sjq.light.expr.ItemExpression;
import sjq.light.expr.atomic.PriorityExpression;
import sjq.light.expr.util.IncomputableException;

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
