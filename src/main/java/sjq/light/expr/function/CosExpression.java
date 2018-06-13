package sjq.light.expr.function;

import sjq.light.expr.ItemExpression;
import sjq.light.expr.atomic.PriorityExpression;

public class CosExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public CosExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "cos < " + priorityExpression.toString() + " >";
    }
    
}
