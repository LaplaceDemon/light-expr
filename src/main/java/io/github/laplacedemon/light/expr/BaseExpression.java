package io.github.laplacedemon.light.expr;

import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public abstract class BaseExpression {
    
    public abstract BaseExpression join(BaseExpression baseExpression) throws ParseExpressionException;
    
    public abstract Object eval() throws IncomputableException;

}
