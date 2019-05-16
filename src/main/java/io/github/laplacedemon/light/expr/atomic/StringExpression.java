package io.github.laplacedemon.light.expr.atomic;

import io.github.laplacedemon.light.expr.ItemExpression;
import io.github.laplacedemon.light.expr.util.IncomputableException;

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
        StringBuilder sb = new StringBuilder(value.length() + 2);
        sb.append("\"");
        sb.append(value);
        sb.append("\"");
        return sb.toString();
    }

    @Override
    public Object eval() throws IncomputableException {
        return value;
    }
}
