package sjq.light.expr.pair;

import sjq.light.expr.ExpressionBuilder;

public class SubExpressionBuilder extends ExpressionBuilder {

    public SubExpressionBuilder(char ch) {
        super(ch);
    }
    
    @Override
    public SubExpression build() {
        return new SubExpression();
    }
    
    @Override
    public boolean append(char ch) {
        return false;
    }

}
