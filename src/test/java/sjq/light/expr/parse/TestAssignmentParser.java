package sjq.light.expr.parse;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.parse.Parser;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class TestAssignmentParser {
    public static void main(String[] args) throws ParseExpressionException, IncomputableException {
        {
            Parser parser = new Parser("x = 1 + 2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(3l);
        }
        
        {
            Parser parser = new Parser("x = 1 - 2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-1l);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(2l);
        }
        
        {
            Parser parser = new Parser("x = 1.0 / 2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(0.5);
        }
        
        {
            Parser parser = new Parser("x = 1.0 / 2 + 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(3.5);
        }
        
        {
            Parser parser = new Parser("x = 1.0 / 2 - 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-2.5);
        }
        
        {
            Parser parser = new Parser("y = 1*2*3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(6l);
        }
        
        {
            Parser parser = new Parser("y = 1*2*3*4");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(24l);
        }
        
        {
            Parser parser = new Parser("y = 1*2*3*4*5");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(120l);
        }
        
        {
            Parser parser = new Parser("y = 1*2*3*4*5 + 1*2*3*4");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(144l);
        }
        
        {
            Parser parser = new Parser("x = 1 + 2 * 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(7l);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 + 3 * 4 + 5 * 6");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(44l);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 + 3 * 4 * 5");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(62l);
        }
        
        {
            Parser parser = new Parser("x = 1 - 2 * 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-5l);
        }
        
        {
            Parser parser = new Parser("x = 1 - 2 - 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-4l);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 - 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-1l);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 - 3 * 4");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-10l);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 - 3 * 4 - 5");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-15l);
        }
        
        {
            Parser parser = new Parser("x = 1 * 2 + 3 * 4 * 5 + 6");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(68l);
        }
        
        {
            Parser parser = new Parser("x = (1 + 2) * 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(9l);
        }
        
        {
            Parser parser = new Parser("x = (1 + 2) * (3 + 4)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(21l);
        }
        
        {
            Parser parser = new Parser("x = sin(1 + 2) * cos(3 + 4)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(0.10639069220927921);
        }
        
        {
            Parser parser = new Parser("y = sin(x)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , sin < x > ]");
        }
        
        {
            Parser parser = new Parser("y = sin(x+1)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , sin < + < x , 1 > > ]");
        }
        
        {
            Parser parser = new Parser("y = sin(x+1) + 2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , + < sin < + < x , 1 > > , 2 > ]");
        }
        
        {
            Parser parser = new Parser("y = sin(x+1) + 2*3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , + < sin < + < x , 1 > > , * < 2 , 3 > > ]");
        }
        
        {
            Parser parser = new Parser("y = sin(x+1) + 2*3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , + < sin < + < x , 1 > > , * < 2 , 3 > > ]");
        }
        
        {
            Parser parser = new Parser("y = sin(x+1) + cos(2*3)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , + < sin < + < x , 1 > > , cos < * < 2 , 3 > > > ]");
        }
        
        {
            Parser parser = new Parser("y = sin(x+1)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , sin < + < x , 1 > > ]");
        }
        
        {
            Parser parser = new Parser("y = sin(sin(x))");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , sin < sin < x > > ]");
        }
        
        {
            Parser parser = new Parser("y = sin(a + cos(b))");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , sin < + < a , cos < b > > > ]");
        }
        
        
        {
            Parser parser = new Parser("y = a + sin(b)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , + < a , sin < b > > ]");
        }
        
        {
            Parser parser = new Parser("y = a * sin(b)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , * < a , sin < b > > ]");
        }
        
        {
            Parser parser = new Parser("y = a / sin(b)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , / < a , sin < b > > ]");
        }
        
        {
            Parser parser = new Parser("y = cos(sin(x))");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , cos < sin < x > > ]");
        }
        
        {
            Parser parser = new Parser("y = cos(sin(a) + b*c + sin(d*e))");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , cos < + < + < sin < a > , * < b , c > > , sin < * < d , e > > > > ]");
        }
        
        {
            Parser parser = new Parser("y = cos(sin(a)*cos(b) + b*c + sin(d*e))");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , cos < + < + < * < sin < a > , cos < b > > , * < b , c > > , sin < * < d , e > > > > ]");
        }
        
        {
            Parser parser = new Parser("y = 'a' + 'b'");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals("ab");
        }
        
        {
            Parser parser = new Parser("y = cos('a' + 'b')");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , cos < + < \"a\" , \"b\" > > ]");
        }
        
        {
            Parser parser = new Parser("y = cos('a'*12 + 'b')");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , cos < + < * < \"a\" , 12 > , \"b\" > > ]");
        }
        
        {
            Parser parser = new Parser("y = max('a','b')");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , max < [\"a\", \"b\"] > ]");
        }
        
    }
}
