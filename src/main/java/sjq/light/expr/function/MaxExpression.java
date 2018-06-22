package sjq.light.expr.function;

import sjq.light.expr.ItemExpression;
import sjq.light.expr.atomic.PriorityExpression;
import sjq.light.expr.util.IncomputableException;

public class MaxExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public MaxExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "max < " + priorityExpression.toString() + " >";
    }

    @Override
    public Object eval() throws IncomputableException {
        throw new IncomputableException();
    }
}
