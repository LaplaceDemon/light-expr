package sjq.light.expr.function;

import sjq.light.expr.ItemExpression;
import sjq.light.expr.atomic.PriorityExpression;

public class SumExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public SumExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "sum < " + priorityExpression.toString() + " >";
    }
    
}
