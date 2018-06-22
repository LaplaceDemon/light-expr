package sjq.light.expr.parse;

import sjq.light.expr.BaseExpression;
import sjq.light.expr.util.IncomputableException;

public class TestNegativeParse {
    public static void main(String[] args) throws ParseExpressionException, IncomputableException {
        {
            Parser parser = new Parser("-1");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-1l);
        }
        
        {
            Parser parser = new Parser("-1-2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-3l);
        }
        
        {
            Parser parser = new Parser("2+(-1)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(1l);
        }
        
        {
            Parser parser = new Parser("2*-1");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-2l);
        }
        
        {
            Parser parser = new Parser("-1*2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-2l);
        }
        
        {
            Parser parser = new Parser("-1*2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-2l);
        }
        
    }
}
