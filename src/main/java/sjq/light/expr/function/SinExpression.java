package sjq.light.expr.function;

import sjq.light.expr.ItemExpression;
import sjq.light.expr.atomic.PriorityExpression;
import sjq.light.expr.util.IncomputableException;

public class SinExpression extends ItemExpression {
    private PriorityExpression priorityExpression;
    
    public SinExpression(PriorityExpression priorityExpression) {
        this.priorityExpression = priorityExpression;
    }
    
    @Override
    public String toString() {
        return "sin < " + priorityExpression.toString() + " >";
    }

    @Override
    public Object eval() throws IncomputableException {
        Number num = (Number)priorityExpression.eval();
        return Math.sin(num.doubleValue());
    }
    
}
