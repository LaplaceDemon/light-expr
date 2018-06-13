package sjq.light.expr.pair;

import sjq.light.expr.ExpressionBuilder;

public class AddExpressionBuilder extends ExpressionBuilder {

    public AddExpressionBuilder(char ch) {
        super(ch);
    }
    
    @Override
    public boolean append(char ch) {
        return false;
    }

    @Override
    public AddExpression build() {
        return new AddExpression();
    }

}
