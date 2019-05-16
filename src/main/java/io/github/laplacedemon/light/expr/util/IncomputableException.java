package io.github.laplacedemon.light.expr.util;

public class IncomputableException extends Exception {
    private static final long serialVersionUID = -479980175407835826L;
    
    public IncomputableException() {
    }

    public IncomputableException(Exception ex) {
        super(ex);
    }

}