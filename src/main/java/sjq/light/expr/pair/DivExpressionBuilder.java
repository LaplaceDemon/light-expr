package sjq.light.expr.pair;

import sjq.light.expr.ExpressionBuilder;

public class DivExpressionBuilder extends ExpressionBuilder {
    public DivExpressionBuilder(char ch) {
        super(ch);
    }
    
    @Override
    public boolean append(char ch) {
        return false;
    }

    @Override
    public DivExpression build() {
        return new DivExpression();
    }
}
