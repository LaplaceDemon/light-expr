package io.github.laplacedemon.light.expr.function;

import io.github.laplacedemon.light.expr.ItemExpression;
import io.github.laplacedemon.light.expr.atomic.PriorityExpression;
import io.github.laplacedemon.light.expr.util.IncomputableException;

@Deprecated
public class SinExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public SinExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "sin < " + priorityExpression.toString() + " >";
    }

    @Override
    public Object eval() throws IncomputableException {
        Number num = (Number)priorityExpression.eval();
        return Math.sin(num.doubleValue());
    }
    
}
