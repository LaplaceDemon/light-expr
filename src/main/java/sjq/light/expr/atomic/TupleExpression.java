package sjq.light.expr.atomic;

import java.util.ArrayList;
import java.util.List;

import sjq.light.expr.BaseExpression;
import sjq.light.expr.ItemExpression;
import sjq.light.expr.util.IncomputableException;

public class TupleExpression extends ItemExpression {
    private List<BaseExpression> expressionList;

    public TupleExpression(List<BaseExpression> expressionList) {
        this.expressionList = expressionList;
    }
    
    @Override
    public String toString() {
        return expressionList.toString();
    }

    @Override
    public Object eval() throws IncomputableException {
        List<Object> results = new ArrayList<>(expressionList.size());
        for(BaseExpression expression:expressionList) {
            Object eval = expression.eval();
            results.add(eval);
        }
        
        return results;
    }

    public int countExpressionList() {
		return expressionList.size();
	}
    
	public List<BaseExpression> getExpressionList() {
		return expressionList;
	}
    
}
