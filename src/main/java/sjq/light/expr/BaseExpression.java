package sjq.light.expr;

import sjq.light.expr.parse.ParseExpressionException;
import sjq.light.expr.util.IncomputableException;

public abstract class BaseExpression {
    
    public abstract BaseExpression join(BaseExpression baseExpression) throws ParseExpressionException;
    
    public abstract Object eval() throws IncomputableException;

}
