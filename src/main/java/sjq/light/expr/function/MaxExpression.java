package sjq.light.expr.function;

import sjq.light.expr.ItemExpression;
import sjq.light.expr.atomic.PriorityExpression;

public class MaxExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public MaxExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "max < " + priorityExpression.toString() + " >";
    }
}
