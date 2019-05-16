package sjq.light.expr.parse;

import org.junit.Assert;
import org.junit.Test;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.parse.Parser;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class TestSplitParse {
    
    @Test
    public void test01() throws ParseExpressionException, IncomputableException {
        Parser parser = new Parser("abc");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse.getClass() + ":" + parse);
        Assert.assertEquals(parse.getClass(), io.github.laplacedemon.light.expr.atomic.SymbolExpression.class);
        Assert.assertEquals(parse.toString(), "abc");
    }

    @Test
    public void test02() throws ParseExpressionException, IncomputableException {
        Parser parser = new Parser("abc , def");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse.getClass() + ":" + parse);
        Assert.assertEquals(parse.getClass(), io.github.laplacedemon.light.expr.atomic.TupleExpression.class);
        Assert.assertEquals(parse.toString(), "[abc, def]");
    }
}
