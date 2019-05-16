package io.github.laplacedemon.light.expr.atomic;

import java.util.List;

public class AttributeExpression extends SymbolExpression {

    private List<String> symbolList;
    
//    private AttributeExpression(String value) {
//        super(value);
//    }
    
    AttributeExpression(List<String> symbolList) {
        super("");
        this.symbolList = symbolList;
    }
    
    @Override
    public String toString() {
        return this.symbolList.toString();
    }
    
}

