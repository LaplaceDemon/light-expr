package io.github.laplacedemon.light.expr.equation;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.atomic.SymbolExpression;
import io.github.laplacedemon.light.expr.equation.logic.AndStatement;
import io.github.laplacedemon.light.expr.equation.logic.OrStatement;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;

public abstract class EquationStatement extends BaseExpression {
	protected BaseExpression left;
    protected BaseExpression right;
    
    public EquationStatement() {}

    public EquationStatement(BaseExpression left, BaseExpression right) {
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
        if(baseExpression instanceof EquationStatement) {
            throw new ParseExpressionException();
        }
        
        if(this.right == null) {
            this.right = baseExpression;
        } else {
        	// 完整表达式连接and或or
        	if(baseExpression instanceof SymbolExpression) {
        		SymbolExpression symbolExpression = (SymbolExpression)baseExpression;
        		if(symbolExpression.getValue().equals("and") ||
    				symbolExpression.getValue().equals("And") ||
    				symbolExpression.getValue().equals("AND")
				) {
        			AndStatement andStatement = new AndStatement();
        			andStatement.setLeft(this);
        			return andStatement;
        		} else if(symbolExpression.getValue().equals("or") ||
        				symbolExpression.getValue().equals("Or") ||
        				symbolExpression.getValue().equals("OR")) {
        			OrStatement orStatement = new OrStatement();
        			orStatement.setLeft(this);
        			return orStatement;
        		}
        	}
        	
            BaseExpression joinExpression = this.right.join(baseExpression);
            this.right = joinExpression;
        }
        
        return this;
    }
    

}
