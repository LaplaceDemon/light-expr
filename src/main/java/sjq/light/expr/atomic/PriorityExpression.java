package sjq.light.expr.atomic;

import sjq.light.expr.BaseExpression;
import sjq.light.expr.ItemExpression;

public class PriorityExpression extends ItemExpression {
    private BaseExpression baseExpression;
    
    PriorityExpression(BaseExpression baseExpression) {
        this.baseExpression = baseExpression;
    }
    
    @Override
    public String toString() {
        return baseExpression.toString();
    }
}
