package sjq.light.expr;

import sjq.light.expr.pair.PairExpression;
import sjq.light.expr.parse.ParseExpressionException;
import sjq.light.expr.util.IncomputableException;

public abstract class ItemExpression extends BaseExpression {
    
    @Override
    public BaseExpression join(BaseExpression baseExpression) throws ParseExpressionException {
        if(baseExpression instanceof AssignmentStatement) {
            AssignmentStatement pairExpression = (AssignmentStatement)baseExpression;
            pairExpression.setLeft(this);
            return pairExpression;
        }else if(baseExpression instanceof PairExpression) {
            PairExpression pairExpression = (PairExpression)baseExpression;
            pairExpression.setLeft(this);
            return pairExpression;
        } else {
            throw new ParseExpressionException();
        }
    }

    public abstract Object eval() throws IncomputableException;

}
