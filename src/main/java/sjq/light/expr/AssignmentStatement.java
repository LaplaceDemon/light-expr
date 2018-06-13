package sjq.light.expr;

import sjq.light.expr.parse.ParseExpressionException;

public class AssignmentStatement extends BaseExpression {
    protected BaseExpression left;
    protected BaseExpression right;

    public AssignmentStatement() {}

    public AssignmentStatement(BaseExpression left, BaseExpression right) {
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
        if(baseExpression instanceof AssignmentStatement) {
            throw new ParseExpressionException();
        }
        
        if(this.right == null) {
            this.right = baseExpression;
        } else {
            BaseExpression joinExpression = this.right.join(baseExpression);
            this.right = joinExpression;
        }
        
        return this;
    }
    
    @Override
    public String toString() {
        return " = [ " + left + " , " + right + " ]";
    }
    
}
