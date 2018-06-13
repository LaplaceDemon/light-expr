package sjq.light.expr.function;

import sjq.light.expr.ItemExpression;
import sjq.light.expr.atomic.PriorityExpression;

public class SinExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public SinExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "sin < " + priorityExpression.toString() + " >";
    }
    
}
