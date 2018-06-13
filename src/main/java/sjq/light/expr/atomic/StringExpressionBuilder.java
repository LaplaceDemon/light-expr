package sjq.light.expr.atomic;

import sjq.light.expr.ExpressionBuilder;

public class StringExpressionBuilder extends ExpressionBuilder {
    private boolean single;
    private boolean closed;

    public StringExpressionBuilder(char c) {
        super(c);
        if(c == '\'') {
            single = true;
        } else if (c == '"') {
            single = false;
        }
        
        closed = false;
    }
    
    @Override
    public boolean append(char ch) {
        if(closed) {
            return false;
        }
        
        super.append(ch);
        
        if(single) {
            if(ch == '\'') {
                closed = true;
            }
        } else {
            if(ch == '"') {
                closed = true;
            }
        }
        
        return true;
    }
    
    public StringExpression build() {
        String value = super.value();
        StringExpression stringExpression = new StringExpression(value);
        return stringExpression;
    }

}
