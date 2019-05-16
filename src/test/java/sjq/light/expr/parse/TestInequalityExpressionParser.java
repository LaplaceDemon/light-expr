package sjq.light.expr.parse;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.parse.Parser;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class TestInequalityExpressionParser {
	public static void main(String[] args) throws ParseExpressionException, IncomputableException {
		{
            Parser parser = new Parser("x == 1.0 / 2 + 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
		
		{
            Parser parser = new Parser("x >= 1.0 / 2 + 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
		
		{
            Parser parser = new Parser("x + 6 != 1.0 / 2 + 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
		
		{
            Parser parser = new Parser("sin(x + 6) > 1.0 / 2 + 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
	}
}
