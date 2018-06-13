package sjq.light.expr.pair;

import sjq.light.expr.ExpressionBuilder;

public class MulExpressionBuilder extends ExpressionBuilder {
    public MulExpressionBuilder(char ch) {
        super(ch);
    }
    
    @Override
    public boolean append(char ch) {
        return false;
    }

    @Override
    public MulExpression build() {
        return new MulExpression();
    }
}
