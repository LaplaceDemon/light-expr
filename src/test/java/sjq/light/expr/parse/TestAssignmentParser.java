package sjq.light.expr.parse;

import sjq.light.expr.BaseExpression;

public class TestAssignmentParser {
    public static void main(String[] args) throws ParseExpressionException {
        {
            Parser parser = new Parser("x = 1 + 2");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 - 2");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 / 2");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 / 2 + 3");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 / 2 - 3");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = 1*2*3");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = 1*2*3*4");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = 1*2*3*4*5");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = 1*2*3*4*5 + 1*2*3*4");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 + 2 * 3");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 + 3 * 4 + 5 * 6");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 + 3 * 4 * 5");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 - 2");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 - 2 * 3");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 - 2 - 3");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 - 3");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 - 3 * 4");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 - 3 * 4 - 5");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 + 3 * 4 * 5");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 + 3 * 4 * 5 + 6");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = (1 + 2) * 3");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = (1 + 2) * (3 + 4)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("x = sin(1 + 2) * cos(3 + 4)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = sin(x)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = sin(x+1)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = sin(x+1) + 2");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = sin(x+1) + 2*3");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = sin(x+1) + 2*3");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = sin(x+1) + cos(2*3)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = sin(x+1)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = sin(sin(x))");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = sin(a + cos(b))");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        
        {
            Parser parser = new Parser("y = a + sin(b)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = a * sin(b)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = a / sin(b)");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = cos(sin(x))");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = cos(sin(a) + b*c + sin(d*e))");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = cos(sin(a)*cos(b) + b*c + sin(d*e))");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = 'a' + 'b'");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = cos('a' + 'b')");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        {
            Parser parser = new Parser("y = cos('a'*12 + 'b')");
            BaseExpression parse = parser.parse();
            System.out.println(parse);
        }
        
        
        
    }
}
