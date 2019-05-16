package sjq.light.expr.parse;

import org.junit.Assert;
import org.junit.Test;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.parse.Parser;

public class TestLogicalExpressionParser {

    @Test
    public void test01() throws ParseExpressionException {
        Parser parser = new Parser("x == 1.0 / 2 + 3 and y == 1.0 / 3");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "And [== [ x , + < / < 1.0 , 2 > , 3 > ], == [ y , / < 1.0 , 3 > ]]");
    }

    @Test
    public void test02() throws ParseExpressionException {
        Parser parser = new Parser("x == 1.0 / 2 + 3 and y == 1.0 / 3 and z != x / 3");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "And [And [== [ x , + < / < 1.0 , 2 > , 3 > ], == [ y , / < 1.0 , 3 > ]], != [ z , / < x , 3 > ]]");
    }

    @Test
    public void test03() throws ParseExpressionException {
        Parser parser = new Parser("x == 1.0 / 2 + 3 and y == 1.0 / 3 or z != x / 3");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "Or [And [== [ x , + < / < 1.0 , 2 > , 3 > ], == [ y , / < 1.0 , 3 > ]], != [ z , / < x , 3 > ]]");
    }

    @Test
    public void test04() throws ParseExpressionException {
        Parser parser = new Parser("x == 1.0 / 2 + 3 or y == 1.0 / 3 or z != x / 3");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "Or [Or [== [ x , + < / < 1.0 , 2 > , 3 > ], == [ y , / < 1.0 , 3 > ]], != [ z , / < x , 3 > ]]");
    }

    @Test
    public void test05() throws ParseExpressionException {
        Parser parser = new Parser("x == 1.0 / 2 + 3 or y == 1.0 / 3 and z != x / 3");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "Or [== [ x , + < / < 1.0 , 2 > , 3 > ], And [== [ y , / < 1.0 , 3 > ], != [ z , / < x , 3 > ]]]");
    }

    @Test
    public void test06() throws ParseExpressionException {
        Parser parser = new Parser("x == 1.0 / 2 + 3 or y == 1.0 / 3 and z != x / 3 or y <= x ");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "Or [Or [== [ x , + < / < 1.0 , 2 > , 3 > ], And [== [ y , / < 1.0 , 3 > ], != [ z , / < x , 3 > ]]], <= [ y , x ]]");
    }

    @Test
    public void test07() throws ParseExpressionException {
        Parser parser = new Parser("x == 1.0 / 2 + 3 or y == 1.0 / 3 and z != x / 3 or y <= 3 ");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "Or [Or [== [ x , + < / < 1.0 , 2 > , 3 > ], And [== [ y , / < 1.0 , 3 > ], != [ z , / < x , 3 > ]]], <= [ y , 3 ]]");
    }

    @Test
    public void test08() throws ParseExpressionException {
        Parser parser = new Parser("x == 1.0 / 2 + 3 or y == 1.0 / 3 and z != x / 3 or y <= x + 3 ");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "Or [Or [== [ x , + < / < 1.0 , 2 > , 3 > ], And [== [ y , / < 1.0 , 3 > ], != [ z , / < x , 3 > ]]], <= [ y , + < x , 3 > ]]");
    }

    @Test
    public void test09() throws ParseExpressionException {
        Parser parser = new Parser("(x == 1.0 / 2 + 3 or y == 1.0 / 3) and z != x / 3");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "And [Or [== [ x , + < / < 1.0 , 2 > , 3 > ], == [ y , / < 1.0 , 3 > ]], != [ z , / < x , 3 > ]]");
    }

    @Test
    public void test10() throws ParseExpressionException {
        Parser parser = new Parser("(x == 1 or y == z) and (z != 1 or a==1)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "And [Or [== [ x , 1 ], == [ y , z ]], Or [!= [ z , 1 ], == [ a , 1 ]]]");
    }

    @Test
    public void test11() throws ParseExpressionException {
        Parser parser = new Parser("(x == 1 or y == z) and ((z != 1 or a==1) or a= c)");
        BaseExpression parse = parser.parse();
        System.out.println(parser.getExpression() + " ==> " + parse);
        Assert.assertEquals(parse.toString(), "And [Or [== [ x , 1 ], == [ y , z ]], Or [Or [!= [ z , 1 ], == [ a , 1 ]],  = [ a , c ]]]");
    }

}
