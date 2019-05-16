package sjq.light.expr.parse;

import org.junit.Test;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.parse.ParseExpressionException;
import io.github.laplacedemon.light.expr.parse.Parser;
import io.github.laplacedemon.light.expr.util.IncomputableException;

public class TestAssignmentParser {
        @Test
        public void test01() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1 + 2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(3L);
        }
        
        @Test
        public void test02() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1 - 2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-1L);
        }
        
        @Test
        public void test03() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1 * 2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(2L);
        }
        
        @Test
        public void test04() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1.0 / 2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(0.5);
        }
        
        @Test
        public void test05() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1.0 / 2 + 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(3.5);
        }
        
        @Test
        public void test06() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1.0 / 2 - 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-2.5);
        }
        
        @Test
        public void test07() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("y = 1*2*3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(6L);
        }
        
        @Test
        public void test08() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("y = 1*2*3*4");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(24L);
        }
        
        @Test
        public void test09() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("y = 1*2*3*4*5");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(120L);
        }
        
        @Test
        public void test10() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("y = 1*2*3*4*5 + 1*2*3*4");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(144L);
        }
        
        @Test
        public void test11() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1 + 2 * 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(7L);
        }
        
        @Test
        public void test12() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1 * 2 + 3 * 4 + 5 * 6");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(44L);
        }
        
        @Test
        public void test13() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1 * 2 + 3 * 4 * 5");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(62L);
        }
        
        @Test
        public void test14() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1 - 2 * 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-5L);
        }
        
        @Test
        public void test15() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1 - 2 - 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-4L);
        }
        
        @Test
        public void test16() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1 * 2 - 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-1L);
        }
        
        @Test
        public void test17() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1 * 2 - 3 * 4");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-10L);
        }
        
        @Test
        public void test18() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1 * 2 - 3 * 4 - 5");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(-15L);
        }
        
        @Test
        public void test19() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = 1 * 2 + 3 * 4 * 5 + 6");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(68L);
        }
        
        @Test
        public void test20() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = (1 + 2) * 3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(9L);
        }
        
        @Test
        public void test21() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = (1 + 2) * (3 + 4)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(21L);
        }
        
        @Test
        public void test22() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("x = sin(1 + 2) * cos(3 + 4)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals(0.10639069220927921);
        }
        
        @Test
        public void test23() throws ParseExpressionException {
            Parser parser = new Parser("y = sin(x)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , sin < x > ]");
        }
        
        @Test
        public void test24() throws ParseExpressionException {
            Parser parser = new Parser("y = sin(x+1)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , sin < + < x , 1 > > ]");
        }
        
        @Test
        public void test25() throws ParseExpressionException {
            Parser parser = new Parser("y = sin(x+1) + 2");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , + < sin < + < x , 1 > > , 2 > ]");
        }
        
        @Test
        public void test26() throws ParseExpressionException {
            Parser parser = new Parser("y = sin(x+1) + 2*3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , + < sin < + < x , 1 > > , * < 2 , 3 > > ]");
        }
        
        @Test
        public void test27() throws ParseExpressionException {
            Parser parser = new Parser("y = sin(x+1) + 2*3");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , + < sin < + < x , 1 > > , * < 2 , 3 > > ]");
        }
        
        @Test
        public void test28() throws ParseExpressionException {
            Parser parser = new Parser("y = sin(x+1) + cos(2*3)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , + < sin < + < x , 1 > > , cos < * < 2 , 3 > > > ]");
        }
        
        @Test
        public void test29() throws ParseExpressionException {
            Parser parser = new Parser("y = sin(x+1)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , sin < + < x , 1 > > ]");
        }
        
        @Test
        public void test30() throws ParseExpressionException {
            Parser parser = new Parser("y = sin(sin(x))");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , sin < sin < x > > ]");
        }
        
        @Test
        public void test31() throws ParseExpressionException {
            Parser parser = new Parser("y = sin(a + cos(b))");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , sin < + < a , cos < b > > > ]");
        }
        
        
        @Test
        public void test32() throws ParseExpressionException {
            Parser parser = new Parser("y = a + sin(b)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , + < a , sin < b > > ]");
        }
        
        @Test
        public void test33() throws ParseExpressionException {
            Parser parser = new Parser("y = a * sin(b)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , * < a , sin < b > > ]");
        }
        
        @Test
        public void test34() throws ParseExpressionException {
            Parser parser = new Parser("y = a / sin(b)");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , / < a , sin < b > > ]");
        }
        
        @Test
        public void test35() throws ParseExpressionException {
            Parser parser = new Parser("y = cos(sin(x))");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , cos < sin < x > > ]");
        }
        
        @Test
        public void test36() throws ParseExpressionException {
            Parser parser = new Parser("y = cos(sin(a) + b*c + sin(d*e))");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , cos < + < + < sin < a > , * < b , c > > , sin < * < d , e > > > > ]");
        }
        
        @Test
        public void test37() throws ParseExpressionException {
            Parser parser = new Parser("y = cos(sin(a)*cos(b) + b*c + sin(d*e))");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , cos < + < + < * < sin < a > , cos < b > > , * < b , c > > , sin < * < d , e > > > > ]");
        }
        
        @Test
        public void test38() throws ParseExpressionException, IncomputableException {
            Parser parser = new Parser("y = 'a' + 'b'");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            Object eval = parse.eval();
            assert eval.equals("ab");
        }
        
        @Test
        public void test39() throws ParseExpressionException {
            Parser parser = new Parser("y = cos('a' + 'b')");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , cos < + < \"a\" , \"b\" > > ]");
        }
        
        @Test
        public void test40() throws ParseExpressionException {
            Parser parser = new Parser("y = cos('a'*12 + 'b')");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , cos < + < * < \"a\" , 12 > , \"b\" > > ]");
        }
        
        @Test
        public void test41() throws ParseExpressionException {
            Parser parser = new Parser("y = max('a','b')");
            BaseExpression parse = parser.parse();
            System.out.println(parser.getExpression() + " ==> " + parse);
            assert parse.toString().equals(" = [ y , max < [\"a\", \"b\"] > ]");
        }
        
}
