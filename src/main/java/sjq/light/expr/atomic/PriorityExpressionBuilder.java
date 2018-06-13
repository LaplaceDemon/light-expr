package sjq.light.expr.atomic;

import sjq.light.expr.BaseExpression;
import sjq.light.expr.ExpressionBuilder;
import sjq.light.expr.parse.ParseExpressionException;
import sjq.light.expr.parse.Parser;

public class PriorityExpressionBuilder extends ExpressionBuilder {
    private boolean closed = false;
    private int num = 0;

    public PriorityExpressionBuilder(char ch) {
        super();
    }

    @Override
    public boolean append(char ch) {
        
        if(closed) {
            return false;
        } 
        
        if(num == 0) {
            if(ch == ')') {
                this.closed = true;
                return true;
            }
        }
        
        if(ch == '(') {
            num++;
        } else if (ch == ')') {
            num--;
        }
        
        
        super.append(ch);
        return true;
    }
    
    public PriorityExpression build() throws ParseExpressionException {
        String value = super.value();
        Parser parser = new Parser(value);
        BaseExpression baseExpression = parser.parse();
        PriorityExpression priorityExpression = new PriorityExpression(baseExpression);
        return priorityExpression;
    }

}
