package sjq.light.expr.atomic;

import sjq.light.expr.ItemExpression;

public class StringExpression extends ItemExpression {
    private String value;

    StringExpression(String value) {
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
