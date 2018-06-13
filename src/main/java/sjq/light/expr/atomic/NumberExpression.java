package sjq.light.expr.atomic;

import sjq.light.expr.ItemExpression;

public class NumberExpression extends ItemExpression {
    private String value;

    NumberExpression(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }

}
