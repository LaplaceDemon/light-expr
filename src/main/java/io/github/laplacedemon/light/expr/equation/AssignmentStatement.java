package io.github.laplacedemon.light.expr.equation;

import io.github.laplacedemon.light.expr.util.IncomputableException;

public class AssignmentStatement extends EquationStatement {
	
	@Override
    public Object eval() throws IncomputableException {
        return this.right.eval();
    }
	
	@Override
    public String toString() {
        return " = [ " + left + " , " + right + " ]";
    }
    
}
