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
        if(this.func.equals("sin")  || this.func.equals("Sin") || this.func.equals("SIN")) {
            Number num = (Number)priorityExpression.eval();
            return Math.sin(num.doubleValue());
        } else if(this.func.equals("cos") || this.func.equals("Cos") || this.func.equals("COS")) {
            double doubleValue = ((Number)priorityExpression.eval()).doubleValue();
            return Math.cos(doubleValue);
        } else if(this.func.equals("count") || this.func.equals("Count") || this.func.equals("COUNT")) {
            throw new IncomputableException();
        } else if(this.func.equals("sum") || this.func.equals("Sum") || this.func.equals("SUM")) {
            throw new IncomputableException();
        } else if(this.func.equals("max") || this.func.equals("Max") || this.func.equals("MAX")) {
            throw new IncomputableException();
        } else if(this.func.equals("min") || this.func.equals("Min") || this.func.equals("MIN")) {
            throw new IncomputableException();
        }
        
        throw new IncomputableException();
    }

	public String getFunc() {
		return func;
	}

	public PriorityExpression getPriorityExpression() {
		return priorityExpression;
	}
	
    
}
