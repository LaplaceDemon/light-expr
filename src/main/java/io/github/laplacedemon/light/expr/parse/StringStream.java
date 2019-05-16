package io.github.laplacedemon.light.expr.parse;

public class StringStream {
    private String expression;
    private int index;

    public StringStream(String expression) {
        this.expression = expression;
        this.index = 0;
    }

    public char next() {
        char ch = this.expression.charAt(index);
        index++;
        return ch;
    }
    
    public boolean hasNext() {
        if(index >= this.expression.length()) {
            return false;
        } else {
            return true;
        }
    }

    public void pushBack() {
        index--;
    }

}
