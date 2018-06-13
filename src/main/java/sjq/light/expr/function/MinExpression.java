package sjq.light.expr.function;

import sjq.light.expr.ItemExpression;
import sjq.light.expr.atomic.PriorityExpression;

public class MinExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public MinExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "min < " + priorityExpression.toString() + " >";
    }
}
