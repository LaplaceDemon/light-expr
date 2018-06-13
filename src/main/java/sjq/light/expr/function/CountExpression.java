package sjq.light.expr.function;

import sjq.light.expr.ItemExpression;
import sjq.light.expr.atomic.PriorityExpression;

public class CountExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public CountExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "count < " + priorityExpression.toString() + " >";
    }
}
