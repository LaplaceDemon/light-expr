package io.github.laplacedemon.light.expr.function;

import io.github.laplacedemon.light.expr.ItemExpression;
import io.github.laplacedemon.light.expr.atomic.PriorityExpression;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class MinExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public MinExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "min < " + priorityExpression.toString() + " >";
    }

    @Override
    public Object eval() throws IncomputableException {
        throw new IncomputableException();
    }
}
