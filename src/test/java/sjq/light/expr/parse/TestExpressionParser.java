package sjq.light.expr.parse;

import sjq.light.expr.BaseExpression;

public class TestExpressionParser {
    public static void main(String[] args) throws ParseExpressionException {
        {
            Parser parser = new Parser("a");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }                                                                                                                                                                                                                              
        
        {
            Parser parser = new Parser("obj.x");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("obj1.f1 + obj2.f2");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("max(a, b)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("min(a, b)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("min(a+b,c)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("min(a+b,c,d)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("min(a+b,c,d+e)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("min(a+b,c,sin(d+e))");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("cos(a+b),c,sin(d+e)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("cos(a+b),obj.f1,sin(d+e)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
    }
}
