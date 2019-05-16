package sjq.light.expr.parse;

import org.junit.Test;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.parse.Parser;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class TestNegativeParse {
    
    @Test
    public void test01() throws ParseExpressionException, IncomputableException {
        Parser parser = new Parser("-1");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Object eval = parse.eval();
        assert eval.equals(-1L);
    }

    @Test
    public void test02() throws ParseExpressionException, IncomputableException {
        Parser parser = new Parser("-1-2");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Object eval = parse.eval();
        assert eval.equals(-3L);
    }

    @Test
    public void test03() throws ParseExpressionException, IncomputableException {
        Parser parser = new Parser("2+(-1)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Object eval = parse.eval();
        assert eval.equals(1L);
    }

    @Test
    public void test04() throws ParseExpressionException, IncomputableException {
        Parser parser = new Parser("2*-1");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Object eval = parse.eval();
        assert eval.equals(-2L);
    }

    @Test
    public void test05() throws ParseExpressionException, IncomputableException {
        Parser parser = new Parser("-1*2");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Object eval = parse.eval();
        assert eval.equals(-2L);
    }

    @Test
    public void test06() throws ParseExpressionException, IncomputableException {
        Parser parser = new Parser("-1*2");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Object eval = parse.eval();
        assert eval.equals(-2L);
    }

}
