package sjq.light.expr.function;

import sjq.light.expr.ItemExpression;
import sjq.light.expr.atomic.PriorityExpression;
import sjq.light.expr.util.IncomputableException;

public class CosExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public CosExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "cos < " + priorityExpression.toString() + " >";
    }

    @Override
    public Object eval() throws IncomputableException {
        double doubleValue = ((Number)priorityExpression.eval()).doubleValue();
        return Math.cos(doubleValue);
    }
    
}
