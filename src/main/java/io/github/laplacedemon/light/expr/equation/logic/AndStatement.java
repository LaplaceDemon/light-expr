package io.github.laplacedemon.light.expr.equation.logic;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.atomic.SymbolExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.util.IncomputableException;

/**
 * @author jackie.sjq
 *
 */
public class AndStatement extends BaseExpression {
	protected BaseExpression left;
    protected BaseExpression right;
    
	public BaseExpression getLeft() {
		return left;
	}

	public void setLeft(BaseExpression left) {
		this.left = left;
	}

	public BaseExpression getRight() {
		return right;
	}

	public void setRight(BaseExpression right) {
		this.right = right;
	}

	@Override
	public BaseExpression join(BaseExpression baseExpression) throws ParseExpressionException {
		if(this.right == null) {
			this.right = baseExpression;
			return this;
		}
		
		if(baseExpression instanceof SymbolExpression) {
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
		
		this.right = this.right.join(baseExpression);
		
		return this;
	}
	
	@Override
	public Object eval() throws IncomputableException {
		return null;
	}

	@Override
	public String toString() {
		return "And [" + left + ", " + right + "]";
	}
	
}
