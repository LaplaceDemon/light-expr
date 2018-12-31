package sjq.light.expr.equation;

import sjq.light.expr.BaseExpression;
import sjq.light.expr.ExpressionBuilder;

/**
 * 方程表达式构建器（包括 =  ==  !=  >  >=  <  <=）
 * @author jackie.sjq
 *
 */
public class EquationExpressionBuilder extends ExpressionBuilder {
	private EquationType equationType;
	
    public EquationExpressionBuilder(char ch) {
        super(ch);
        if(ch == '=') {
        	this.equationType = EquationType.Assign;
        } else if(ch == '>') {
        	this.equationType = EquationType.Gt;
        } else if(ch == '<') {
        	this.equationType = EquationType.Lt;
        } else if (ch == '!') {
        	this.equationType = EquationType.Not;
        }
    }
    
    @Override
    public boolean append(char ch) {
    	if(equationType.equals(EquationType.Assign) && ch == '=') {
    		equationType = EquationType.Eq;
    		return true;
    	} else if(equationType.equals(EquationType.Gt) && ch == '=') {
    		equationType = EquationType.Ge;
    		return true;
    	} else if(equationType.equals(EquationType.Lt) && ch == '=') {
    		equationType = EquationType.Le;
    		return true;
    	} else if(equationType.equals(EquationType.Not) && ch == '=') {
    		equationType = EquationType.Nq;
    		return true;
    	}
    	
        return false;
    }
    
    @Override
    public BaseExpression build() {
    	if(equationType.equals(EquationType.Assign)) {
    		return new AssignmentStatement();
    	} else {
    		return new ComparisonStatement(equationType);
    	}
    }

}
