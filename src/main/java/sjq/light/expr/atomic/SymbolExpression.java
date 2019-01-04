package sjq.light.expr.atomic;

import sjq.light.expr.BaseExpression;
import sjq.light.expr.ItemExpression;
import sjq.light.expr.function.CosExpression;
import sjq.light.expr.function.CountExpression;
import sjq.light.expr.function.FuncExpression;
import sjq.light.expr.function.MaxExpression;
import sjq.light.expr.function.MinExpression;
import sjq.light.expr.function.SinExpression;
import sjq.light.expr.function.SumExpression;
import sjq.light.expr.parse.ParseExpressionException;
import sjq.light.expr.util.IncomputableException;

public class SymbolExpression extends ItemExpression {
    private String value;
    
    public SymbolExpression() {}
    
    public SymbolExpression(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    @Override
    public BaseExpression join(BaseExpression baseExpression) throws ParseExpressionException {
        if(baseExpression instanceof PriorityExpression) {
            PriorityExpression priorityExpression = (PriorityExpression)baseExpression;
            if(this.value.equals("sin")  || this.value.equals("Sin") || this.value.equals("SIN")) {
                return new SinExpression(priorityExpression);
            } else if(this.value.equals("cos") || this.value.equals("Cos") || this.value.equals("COS")) {
                return new CosExpression(priorityExpression);
            } else if(this.value.equals("count") || this.value.equals("Count") || this.value.equals("COUNT")) {
                return new CountExpression(priorityExpression);
            } else if(this.value.equals("sum") || this.value.equals("Sum") || this.value.equals("SUM")) {
                return new SumExpression(priorityExpression);
            } else if(this.value.equals("max") || this.value.equals("Max") || this.value.equals("MAX")) {
                return new MaxExpression(priorityExpression);
            } else if(this.value.equals("min") || this.value.equals("Min") || this.value.equals("MIN")) {
                return new MinExpression(priorityExpression);
            } else {
//                throw new ParseExpressionException(this.value  + " functions are not supported");
            	return new FuncExpression(this.value, priorityExpression);
            }
        } else {
            return super.join(baseExpression);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public Object eval() throws IncomputableException {
        throw new IncomputableException();
    }

}
