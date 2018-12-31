package sjq.light.expr;

import sjq.light.expr.atomic.SymbolExpression;
import sjq.light.expr.equation.EquationStatement;
import sjq.light.expr.equation.logic.AndStatement;
import sjq.light.expr.equation.logic.OrStatement;
import sjq.light.expr.pair.PairExpression;
import sjq.light.expr.parse.ParseExpressionException;
import sjq.light.expr.util.IncomputableException;

public abstract class ItemExpression extends BaseExpression {
    
    @Override
    public BaseExpression join(BaseExpression baseExpression) throws ParseExpressionException {
        if(baseExpression instanceof EquationStatement) {
        	EquationStatement equationStatement = (EquationStatement)baseExpression;
        	equationStatement.setLeft(this);
            return equationStatement;
        } else if (baseExpression instanceof PairExpression) {
            PairExpression pairExpression = (PairExpression)baseExpression;
            pairExpression.setLeft(this);
            return pairExpression;
        } else if(baseExpression instanceof SymbolExpression) {
    		SymbolExpression symbolExpression = (SymbolExpression)baseExpression;
    		if(symbolExpression.getValue().equals("and") || symbolExpression.getValue().equals("And") || symbolExpression.getValue().equals("AND")) {
    			AndStatement andStatement = new AndStatement();
    			andStatement.setLeft(this);
    			return andStatement;
    		} else if(symbolExpression.getValue().equals("or") || symbolExpression.getValue().equals("Or") || symbolExpression.getValue().equals("OR")) {
    			OrStatement orStatement = new OrStatement();
    			orStatement.setLeft(this);
    			return orStatement;
    		}
    	}
        
        throw new ParseExpressionException();
    }

    public abstract Object eval() throws IncomputableException;

}
