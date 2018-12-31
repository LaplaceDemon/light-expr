package sjq.light.expr;

import sjq.light.expr.parse.ParseExpressionException;

public abstract class ExpressionBuilder {
    private StringBuilder sb = new StringBuilder();
    
    public ExpressionBuilder() {
    }
    
    public ExpressionBuilder(char ch) {
        this.sb.append(ch);
    }
    
    public boolean append(char ch) {
        this.sb.append(ch);
        return true;
    }
    
    public String value() {
        return this.sb.toString();
    }
    
    public abstract BaseExpression build() throws ParseExpressionException;
}
