package io.github.laplacedemon.light.expr.atomic;

import io.github.laplacedemon.light.expr.ItemExpression;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class NumberExpression extends ItemExpression {
    private String value;
    private boolean hasPoint = false;

    NumberExpression(String value,boolean hasPoint) {
        this.value = value;
        this.hasPoint = hasPoint;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }

    @Override
    public Object eval() throws IncomputableException {
        try {
            if (hasPoint) {
                return Double.valueOf(this.value);
            } else {
                return Long.valueOf(this.value);
            }
        } catch (Exception ex) {
            throw new IncomputableException(ex);
        }
    }

}
