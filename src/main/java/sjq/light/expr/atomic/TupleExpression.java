package sjq.light.expr.atomic;

import java.util.List;

import sjq.light.expr.BaseExpression;
import sjq.light.expr.ItemExpression;

public class TupleExpression extends ItemExpression {
    private List<BaseExpression> expressionList;

    public TupleExpression(List<BaseExpression> expressionList) {
        this.expressionList = expressionList;
    }
    
    @Override
    public String toString() {
        return expressionList.toString();
    }
}
