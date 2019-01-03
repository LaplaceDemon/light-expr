package sjq.light.expr.parse.sql;

import sjq.light.expr.BaseExpression;
import sjq.light.expr.parse.ParseExpressionException;
import sjq.light.expr.parse.Parser;

public class TestOrder {
	public static void main(String[] args) throws ParseExpressionException {
    	{
            Parser parser = new Parser("abc asc");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse.getClass() + ":" + parse);
        }
    	
    	{
            Parser parser = new Parser("abc desc, def asc");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse.getClass() + ":" + parse);
        }
    	
    	{
            Parser parser = new Parser("abc, def asc");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse.getClass() + ":" + parse);
        }
    }
}
