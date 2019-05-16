package io.github.laplacedemon.light.expr.function;

import io.github.laplacedemon.light.expr.ItemExpression;
import io.github.laplacedemon.light.expr.atomic.PriorityExpression;
import io.github.laplacedemon.light.expr.util.IncomputableException;

@Deprecated
public class CosExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public CosExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "cos < " + priorityExpression.toString() + " >";
    }

    @Override
    public Object eval() throws IncomputableException {
        double doubleValue = ((Number)priorityExpression.eval()).doubleValue();
        return Math.cos(doubleValue);
    }
    
}
