package sjq.light.expr.parse;

import sjq.light.expr.BaseExpression;

public class TestSplitParse {
    public static void main(String[] args) throws ParseExpressionException {
    	{
            Parser parser = new Parser("abc");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse.getClass() + ":" + parse);
        }
    	
    	{
            Parser parser = new Parser("abc , def");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse.getClass() + ":" + parse);
        }
    }
}
