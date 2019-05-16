package sjq.light.expr.parse;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.parse.Parser;

public class TestLogicalExpressionParser {
	public static void main(String[] args) throws ParseExpressionException {
		/*
		{
            Parser parser = new Parser("x == 1.0 / 2 + 3 and y == 1.0 / 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
		
		{
            Parser parser = new Parser("x == 1.0 / 2 + 3 and y == 1.0 / 3 and z != x / 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
        
		{
            Parser parser = new Parser("x == 1.0 / 2 + 3 and y == 1.0 / 3 or z != x / 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
		
		{
            Parser parser = new Parser("x == 1.0 / 2 + 3 or y == 1.0 / 3 or z != x / 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
       
       
		{
            Parser parser = new Parser("x == 1.0 / 2 + 3 or y == 1.0 / 3 and z != x / 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
       
		
		{
            Parser parser = new Parser("x == 1.0 / 2 + 3 or y == 1.0 / 3 and z != x / 3 or y <= x ");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
		
		{
            Parser parser = new Parser("x == 1.0 / 2 + 3 or y == 1.0 / 3 and z != x / 3 or y <= 3 ");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
		
		{
            Parser parser = new Parser("x == 1.0 / 2 + 3 or y == 1.0 / 3 and z != x / 3 or y <= x + 3 ");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
		*/
		
		{
            Parser parser = new Parser("(x == 1.0 / 2 + 3 or y == 1.0 / 3) and z != x / 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
		
		{
            Parser parser = new Parser("(x == 1 or y == z) and (z != 1 or a==1)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
		
		{
            Parser parser = new Parser("(x == 1 or y == z) and ((z != 1 or a==1) or a= c)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
//            Object eval = parse.eval();
//            assert eval.equals(3.5);
        }
		
	}
}
