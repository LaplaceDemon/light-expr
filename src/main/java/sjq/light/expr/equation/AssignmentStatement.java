package sjq.light.expr.equation;

import sjq.light.expr.util.IncomputableException;

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
