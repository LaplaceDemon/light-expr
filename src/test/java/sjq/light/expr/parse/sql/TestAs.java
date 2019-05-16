package sjq.light.expr.parse.sql;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.parse.Parser;

public class TestAs {
	public static void main(String[] args) throws ParseExpressionException {
		{
            Parser parser = new Parser("asdfasf as abc");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse.getClass() + ":" + parse);
        }
		{
            Parser parser = new Parser("cos(asdfasf) as abc");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse.getClass() + ":" + parse);
        }
		{
            Parser parser = new Parser("map(asdfasf) as abc");
            try {
            	BaseExpression parse = parser.parse();
            } catch (Exception ex) {
            	System.out.println(ex.getMessage());
            }
        }
	}
}
