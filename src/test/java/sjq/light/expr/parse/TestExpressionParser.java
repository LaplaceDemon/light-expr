package sjq.light.expr.parse;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.parse.Parser;

public class TestExpressionParser {
    public static void main(String[] args) throws ParseExpressionException {
        {
            Parser parser = new Parser("a");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals("a");
        }                                                                                                                                                                                                                              
        
        {
            Parser parser = new Parser("obj.x");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals("[obj, x]");
        }
        
        {
            Parser parser = new Parser("obj1.f1 + obj2.f2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals("+ < [obj1, f1] , [obj2, f2] >");
        }
        
        {
            Parser parser = new Parser("max(a, b)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals("max < [a, b] >");
        }
        
        {
            Parser parser = new Parser("min(a, b)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals("min < [a, b] >");
        }
        
        {
            Parser parser = new Parser("min(a+b,c)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals("min < [+ < a , b >, c] >");
        }
        
        {
            Parser parser = new Parser("min(a+b,c,d)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals("min < [+ < a , b >, c, d] >");
        }
        
        {
            Parser parser = new Parser("min(a+b,c,d+e)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals("min < [+ < a , b >, c, + < d , e >] >");
        }
        
        {
            Parser parser = new Parser("min(a+b,c,sin(d+e))");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals("min < [+ < a , b >, c, sin < + < d , e > >] >");
        }
        
        {
            Parser parser = new Parser("cos(a+b),c,sin(d+e)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals("[cos < + < a , b > >, c, sin < + < d , e > >]");
        }
        
        {
            Parser parser = new Parser("cos(a+b),obj.f1,sin(d+e)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals("[cos < + < a , b > >, [obj, f1], sin < + < d , e > >]");
        }
        
    }
}
