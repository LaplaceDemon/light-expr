package sjq.light.expr.pair;

import sjq.light.expr.AssignmentStatement;
import sjq.light.expr.BaseExpression;
import sjq.light.expr.ItemExpression;
import sjq.light.expr.parse.ParseExpressionException;

public class AddExpression extends PairExpression {

    @Override
    public BaseExpression join(BaseExpression baseExpression) throws ParseExpressionException {
        BaseExpression rightExpression = this.getRight();
        if(rightExpression != null && baseExpression instanceof ItemExpression) {
            ItemExpression itemExpression = (ItemExpression)baseExpression;
            BaseExpression joinExpression = rightExpression.join(itemExpression);
            this.setRight(joinExpression);
            return this;
        }
        
        if (rightExpression != null &&
            baseExpression instanceof AddExpression
            || baseExpression instanceof SubExpression) {
            PairExpression pairExpression = (PairExpression)baseExpression;
            pairExpression.setLeft(this);
            return pairExpression;
        }

        if (rightExpression != null
            && !(rightExpression instanceof ItemExpression)
            || baseExpression instanceof MulExpression
            || baseExpression instanceof DivExpression) {
            BaseExpression joinExpression = rightExpression.join(baseExpression);
            this.setRight(joinExpression);
            return this;
        }

        if (baseExpression instanceof ItemExpression) {
            this.setRight(baseExpression);
            return this;
        } else if (baseExpression instanceof AddExpression || baseExpression instanceof SubExpression) {
            PairExpression pairExpression = (PairExpression)baseExpression;
            pairExpression.setLeft(this);
            return pairExpression;
        } else if (baseExpression instanceof MulExpression || baseExpression instanceof DivExpression) {
            PairExpression pairExpression = (PairExpression)baseExpression;
            pairExpression.setLeft(rightExpression);
            this.setRight(pairExpression);
            return this;
        } else if (baseExpression instanceof AssignmentStatement) {
            AssignmentStatement assignmentStatement = (AssignmentStatement)baseExpression;
            assignmentStatement.setLeft(this);
            return assignmentStatement;
        } else {
            throw new ParseExpressionException();
        }
    }

    @Override
    public String toString() {
        return "+ < " + left + " , " + right + " >";
    }
}
