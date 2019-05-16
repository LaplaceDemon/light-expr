package io.github.laplacedemon.light.expr.pair;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.ItemExpression;
import io.github.laplacedemon.light.expr.equation.AssignmentStatement;
import io.github.laplacedemon.light.expr.equation.EquationStatement;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.util.CalcUtil;
import io.github.laplacedemon.light.expr.util.IncomputableException;

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
