package sjq.light.expr;

import sjq.light.expr.atomic.AttributeExpression;
import sjq.light.expr.atomic.SymbolExpression;
import sjq.light.expr.equation.EquationStatement;
import sjq.light.expr.equation.logic.AndStatement;
import sjq.light.expr.equation.logic.OrStatement;
import sjq.light.expr.pair.PairExpression;
import sjq.light.expr.parse.ParseExpressionException;
import sjq.light.expr.sql.as.AsStatement;
import sjq.light.expr.sql.order.OrderByStatement;
import sjq.light.expr.sql.order.OrderType;
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
    		String value = symbolExpression.getValue();
    		if(value.equals("and") || value.equals("And") || value.equals("AND")) {
    			AndStatement andStatement = new AndStatement();
    			andStatement.setLeft(this);
    			return andStatement;
    		} else if(value.equals("or") || value.equals("Or") || value.equals("OR")) {
    			OrStatement orStatement = new OrStatement();
    			orStatement.setLeft(this);
    			return orStatement;
    		} else if(value.equals("desc") || value.equals("DESC") || value.equals("Desc")) {
    			if(this instanceof SymbolExpression || this instanceof AttributeExpression) {
    				OrderByStatement orderByStatement = new OrderByStatement((SymbolExpression)this, OrderType.Desc);
    				return orderByStatement;
    			}
    		} else if(value.equals("asc") || value.equals("ASC") || value.equals("Asc")) {
    			if(this instanceof SymbolExpression || this instanceof AttributeExpression) {
    				OrderByStatement orderByStatement = new OrderByStatement((SymbolExpression)this, OrderType.Asc);
    				return orderByStatement;
    			}
    		} else if(value.equals("as") || value.equals("As") || value.equals("AS")) {
				AsStatement asStatement = new AsStatement();
				asStatement.setLeft(this);
				
				return asStatement;
    		} else {
    			CommonStatement commonState = new CommonStatement();
    			commonState.join(this);
    			commonState.join(baseExpression);
    			return commonState;
    		}
    	}
        
        throw new ParseExpressionException();
    }

    public abstract Object eval() throws IncomputableException;

}
