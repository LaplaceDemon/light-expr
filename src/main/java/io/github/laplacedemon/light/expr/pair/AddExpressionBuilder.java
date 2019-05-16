package io.github.laplacedemon.light.expr.pair;

import io.github.laplacedemon.light.expr.ExpressionBuilder;

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
