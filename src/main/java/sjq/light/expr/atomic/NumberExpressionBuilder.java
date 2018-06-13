package sjq.light.expr.atomic;

import sjq.light.expr.ExpressionBuilder;

public class NumberExpressionBuilder extends ExpressionBuilder {
    private boolean hasEnd = false;

    public NumberExpressionBuilder(char c) {
        super(c);
    }
    
    @Override
    public boolean append(char ch) {
        if ('0' <= ch && ch <= '9' || ch == '.') {
            super.append(ch);
            return true;
        } else {
            hasEnd = true;
            return false;
        }
    }
    
    public NumberExpression build() {
        String value = super.value();
        NumberExpression numberExpression = new NumberExpression(value);
        return numberExpression;
    }

    public boolean hasEnd() {
        return hasEnd;
    }
    

}
