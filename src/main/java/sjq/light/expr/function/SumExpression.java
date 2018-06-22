package sjq.light.expr.function;

import sjq.light.expr.ItemExpression;
import sjq.light.expr.atomic.PriorityExpression;
import sjq.light.expr.util.IncomputableException;

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
