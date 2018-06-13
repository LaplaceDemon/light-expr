package sjq.light.expr;

import sjq.light.expr.parse.ParseExpressionException;

public class BaseExpression {
    
    public BaseExpression join(BaseExpression baseExpression) throws ParseExpressionException {
        return new BaseExpression();
    }
}
