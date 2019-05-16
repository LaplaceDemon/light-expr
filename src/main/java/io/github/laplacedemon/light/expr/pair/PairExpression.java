package io.github.laplacedemon.light.expr.pair;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public abstract class PairExpression extends BaseExpression {
    protected BaseExpression left;
    protected BaseExpression right;

    public PairExpression() {}

    public PairExpression(BaseExpression left, BaseExpression right) {
        super();
        this.left = left;
        this.right = right;
    }

    public void setLeft(BaseExpression left) {
        this.left = left;
    }

    public void setRight(BaseExpression right) {
        this.right = right;
    }

    public BaseExpression getLeft() {
        return left;
    }

    public BaseExpression getRight() {
        return right;
    }

    @Override
    public BaseExpression join(BaseExpression baseExpression) throws ParseExpressionException {
        this.setRight(baseExpression);
        return this;
    }
    
    @Override
    public String toString() {
        return "[ " + left + " , " + right + " ]";
    }

    public abstract Object eval() throws IncomputableException;

}
