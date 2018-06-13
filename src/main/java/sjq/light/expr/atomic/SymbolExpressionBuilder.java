package sjq.light.expr.atomic;

import java.util.LinkedList;
import java.util.List;

import sjq.light.expr.ExpressionBuilder;

public class SymbolExpressionBuilder extends ExpressionBuilder {
    
    static enum Type {
        Symbol,Attribute
    }
    
    private boolean hasEnd = false;
    private Type type;
    private List<String> symbolList;
    private StringBuilder sb;

    public SymbolExpressionBuilder(char c) {
        super();
        type = Type.Symbol;
        sb = new StringBuilder();
        sb.append(c);
    }

    @Override
    public boolean append(char ch) {
        if ('a' <= ch && ch <= 'z' ||
            'A' <= ch && ch <= 'Z' ||
            '0' <= ch && ch <= '9' ||
            ch == '_' ||
            ch == '$'
        ) {
            sb.append(ch);
            return true;
        } else if ('.' == ch) {
            type = Type.Attribute;
            
            if(symbolList == null) {
                symbolList = new LinkedList<>();
            }
            
            String string = sb.toString();
            symbolList.add(string);
            sb.delete(0, sb.length());
            
            return true;
        } else {
            hasEnd = true;
            return false;
        }
    }
    
    public SymbolExpression build() {
        String value = sb.toString();
        if (type == Type.Symbol) {
            SymbolExpression symbolExpression = new SymbolExpression(value);
            return symbolExpression;
        } else if (type == Type.Attribute) {
            // 最后buffer中的数据add到list
            String string = sb.toString();
            symbolList.add(string);
            AttributeExpression attributeExpression = new AttributeExpression(symbolList);
            return attributeExpression;
        } else {
            // 不可能出现
            return null;
        }
        
    }

    public boolean hasEnd() {
        return hasEnd;
    }
    
}


