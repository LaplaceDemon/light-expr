package io.github.laplacedemon.light.expr.equation;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class ComparisonStatement extends EquationStatement {
	private EquationType equationType;
	
	public ComparisonStatement(EquationType equationType) {
		this.equationType = equationType;
	}
	
	public ComparisonStatement(EquationType equationType, BaseExpression left, BaseExpression right) {
        this(equationType);
        this.left = left;
        this.right = right;
    }

    public EquationType getEquationType() {
		return equationType;
	}
    
    @Override
    public String toString() {
        return this.equationType.getName() + " [ " + left + " , " + right + " ]";
    }

    @Override
    public Object eval() throws IncomputableException {
    	return null;
    }
	
}
