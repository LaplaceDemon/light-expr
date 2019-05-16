package sjq.light.expr.parse;

import org.junit.Assert;
import org.junit.Test;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.parse.Parser;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class TestInequalityExpressionParser {

    @Test
    public void test01() throws ParseExpressionException {
        Parser parser = new Parser("x == 1.0 / 2 + 3");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "== [ x , + < / < 1.0 , 2 > , 3 > ]");
    }

    @Test
    public void test02() throws ParseExpressionException {
        Parser parser = new Parser("x >= 1.0 / 2 + 3");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), ">= [ x , + < / < 1.0 , 2 > , 3 > ]");
    }

    @Test
    public void test03() throws ParseExpressionException, IncomputableException {
        Parser parser = new Parser("x + 6 != 1.0 / 2 + 3");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "!= [ + < x , 6 > , + < / < 1.0 , 2 > , 3 > ]");
    }

    @Test
    public void test04() throws ParseExpressionException, IncomputableException {
        Parser parser = new Parser("sin(x + 6) > 1.0 / 2 + 3");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "> [ sin < + < x , 6 > > , + < / < 1.0 , 2 > , 3 > ]");
    }
}
