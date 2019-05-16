package io.github.laplacedemon.light.expr.function;

import io.github.laplacedemon.light.expr.ItemExpression;
import io.github.laplacedemon.light.expr.atomic.PriorityExpression;
import io.github.laplacedemon.light.expr.util.IncomputableException;

@Deprecated
public class SumExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public SumExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "sum < " + priorityExpression.toString() + " >";
    }

    @Override
    public Object eval() throws IncomputableException {
        throw new IncomputableException();
    }
    
}
