package sjq.light.expr;

public class AssignmentExpressionBuilder extends ExpressionBuilder {

    public AssignmentExpressionBuilder(char ch) {
        super(ch);
    }
    
    @Override
    public boolean append(char ch) {
        return false;
    }
    
    @Override
    public BaseExpression build() {
        return new AssignmentStatement();
    }

}
