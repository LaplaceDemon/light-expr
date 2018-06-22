package sjq.light.expr.atomic;

import sjq.light.expr.BaseExpression;
import sjq.light.expr.ItemExpression;
import sjq.light.expr.util.IncomputableException;

public class PriorityExpression extends ItemExpression {
    private BaseExpression baseExpression;
    
    PriorityExpression(BaseExpression baseExpression) {
        this.baseExpression = baseExpression;
    }
    
    @Override
    public String toString() {
        return baseExpression.toString();
    }

    @Override
    public Object eval() throws IncomputableException {
        return baseExpression.eval();
    }
}
