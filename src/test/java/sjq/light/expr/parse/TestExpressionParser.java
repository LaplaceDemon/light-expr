package sjq.light.expr.parse;

import org.junit.Test;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.parse.Parser;

public class TestExpressionParser {
    
    @Test
    public void test01() throws ParseExpressionException {
        Parser parser = new Parser("a");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("a");
    }

    @Test
    public void test02() throws ParseExpressionException {
        Parser parser = new Parser("obj.x");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("[obj, x]");
    }

    @Test
    public void test03() throws ParseExpressionException {
        Parser parser = new Parser("obj1.f1 + obj2.f2");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("+ < [obj1, f1] , [obj2, f2] >");
    }

    @Test
    public void test04() throws ParseExpressionException {
        Parser parser = new Parser("max(a, b)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("max < [a, b] >");
    }

    @Test
    public void test05() throws ParseExpressionException {
        Parser parser = new Parser("min(a, b)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("min < [a, b] >");
    }

    @Test
    public void test06() throws ParseExpressionException {
        Parser parser = new Parser("min(a+b,c)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("min < [+ < a , b >, c] >");
    }

    @Test
    public void test07() throws ParseExpressionException {
        Parser parser = new Parser("min(a+b,c,d)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("min < [+ < a , b >, c, d] >");
    }

    @Test
    public void test08() throws ParseExpressionException {
        Parser parser = new Parser("min(a+b,c,d+e)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("min < [+ < a , b >, c, + < d , e >] >");
    }

    @Test
    public void test09() throws ParseExpressionException {
        Parser parser = new Parser("min(a+b,c,sin(d+e))");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("min < [+ < a , b >, c, sin < + < d , e > >] >");
    }

    @Test
    public void test10() throws ParseExpressionException {
        Parser parser = new Parser("cos(a+b),c,sin(d+e)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("[cos < + < a , b > >, c, sin < + < d , e > >]");
    }

    @Test
    public void test11() throws ParseExpressionException {
        Parser parser = new Parser("cos(a+b),obj.f1,sin(d+e)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("[cos < + < a , b > >, [obj, f1], sin < + < d , e > >]");
    }

    @Test
    public void test12() throws ParseExpressionException {
        Parser parser = new Parser("a + b");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("+ < a , b >");
    }

    @Test
    public void test13() throws ParseExpressionException {
        Parser parser = new Parser("a + b * c");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("+ < a , * < b , c > >");
    }

    @Test
    public void test14() throws ParseExpressionException {
        Parser parser = new Parser("(a + b) * c");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
//            assert parse.toString().equals("[cos < + < a , b > >, [obj, f1], sin < + < d , e > >]");
        assert parse.toString().equals("* < + < a , b > , c >");
    }

    @Test
    public void test15() throws ParseExpressionException {
        Parser parser = new Parser("hanshu(a + b)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("hanshu < + < a , b > >");
    }

    @Test
    public void test16() throws ParseExpressionException {
        Parser parser = new Parser("hanshu(a , b)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("hanshu < [a, b] >");
    }

    @Test
    public void test17() throws ParseExpressionException {
        Parser parser = new Parser("max(a + b)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("max < + < a , b > >");
    }

    @Test
    public void test18() throws ParseExpressionException {
        Parser parser = new Parser("max(a , b)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        assert parse.toString().equals("max < [a, b] >");
    }

}
