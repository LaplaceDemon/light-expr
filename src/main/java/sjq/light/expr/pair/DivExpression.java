package sjq.light.expr.pair;

import sjq.light.expr.BaseExpression;
import sjq.light.expr.ItemExpression;
import sjq.light.expr.equation.AssignmentStatement;
import sjq.light.expr.equation.EquationStatement;
import sjq.light.expr.parse.ParseExpressionException;
import sjq.light.expr.util.CalcUtil;
import sjq.light.expr.util.IncomputableException;

public class DivExpression extends PairExpression {
    
    @Override
    public BaseExpression join(BaseExpression baseExpression) throws ParseExpressionException {
        BaseExpression rightExpression = this.getRight();
        if(rightExpression != null && baseExpression instanceof ItemExpression) {
            ItemExpression itemExpression = (ItemExpression)baseExpression;
            BaseExpression joinExpression = rightExpression.join(itemExpression);
            this.setRight(joinExpression);
            return this;
        }
        
        if(baseExpression instanceof ItemExpression) {
            this.setRight(baseExpression);
            return this;
        } else if(baseExpression instanceof AddExpression || baseExpression instanceof SubExpression) {
            PairExpression pairExpression = (PairExpression)baseExpression;
            if(this.getRight() == null && pairExpression.getLeft() == null) {
                this.setRight(pairExpression);
                return this;
            }
            
            pairExpression.setLeft(this);
            return pairExpression;
        } else if(baseExpression instanceof MulExpression || baseExpression instanceof DivExpression) {
            PairExpression pairExpression = (PairExpression)baseExpression;
            pairExpression.setLeft(this);
            return pairExpression;
        } else if (baseExpression instanceof EquationStatement) {
        	EquationStatement equationStatement = (EquationStatement)baseExpression;
        	equationStatement.setLeft(this);
            return equationStatement;
        } else {
            throw new ParseExpressionException();
        }
    }
    
    @Override
    public String toString() {
        return "/ < " + left + " , " + right + " >";
    }

    @Override
    public Object eval() throws IncomputableException {
        return CalcUtil.div(this.left.eval(), this.right.eval());
    }
}
