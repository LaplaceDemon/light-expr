package io.github.laplacedemon.light.expr.parse;

import java.util.LinkedList;
import java.util.List;

import io.github.laplacedemon.light.expr.BaseExpression;
import io.github.laplacedemon.light.expr.ExpressionBuilder;
import io.github.laplacedemon.light.expr.atomic.NumberExpressionBuilder;
import io.github.laplacedemon.light.expr.atomic.PriorityExpressionBuilder;
import io.github.laplacedemon.light.expr.atomic.StringExpressionBuilder;
import io.github.laplacedemon.light.expr.atomic.SymbolExpressionBuilder;
import io.github.laplacedemon.light.expr.atomic.TupleExpression;
import io.github.laplacedemon.light.expr.equation.EquationExpressionBuilder;
import io.github.laplacedemon.light.expr.pair.AddExpressionBuilder;
import io.github.laplacedemon.light.expr.pair.DivExpressionBuilder;
import io.github.laplacedemon.light.expr.pair.MulExpressionBuilder;
import io.github.laplacedemon.light.expr.pair.SubExpressionBuilder;

public class Parser {
    private String expression;
    private StringStream exprStream;

    public Parser(String expression) {
        this.expression = expression;
        this.exprStream = new StringStream(expression);
        this.expressionList = new LinkedList<>();
    }

    public String getExpression() {
        return expression;
    }

    private BaseExpression lastExpression = null;
    private List<BaseExpression> expressionList = null;
    private ExpressionBuilder curExpressionBuilder = null;

    public BaseExpression parse() throws ParseExpressionException {
        {
            // 之后的字符处理
            while (exprStream.hasNext()) {
                char ch = exprStream.next();
//                System.out.print(ch + " --> ");

                boolean append;
                if (this.curExpressionBuilder != null) {
                    append = this.curExpressionBuilder.append(ch);
                } else {
                    append = createExpressionBuilderByFirstChar(ch);
                }

                if (!append) {
                    if (curExpressionBuilder != null) {
                        BaseExpression newExpression = curExpressionBuilder.build();
                        curExpressionBuilder = null;
                        if (lastExpression != null) {
                            lastExpression = lastExpression.join(newExpression);
                        } else {
                            lastExpression = newExpression;
                        }
                    }

                    // 添加不成功，处理未决的字符。
                    if (ch == ' ') {
                        continue;
                    } else {
                        createExpressionBuilderByFirstChar(ch);
                    }
                }
            }
        }
        
        // 最后处理
        if(curExpressionBuilder != null) {
            BaseExpression newExpression = curExpressionBuilder.build();
            curExpressionBuilder = null;
            if (lastExpression != null) {
                lastExpression = lastExpression.join(newExpression);
            } else {
                lastExpression = newExpression;
            }
        }
        
        if(this.expressionList.size() > 0) {
            this.expressionList.add(this.lastExpression);
            this.lastExpression = new TupleExpression(this.expressionList);
        }
        
        return lastExpression;
    }

    public boolean createExpressionBuilderByFirstChar(char ch) {
        if ('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z') {
            this.curExpressionBuilder = new SymbolExpressionBuilder(ch);
        } else if ('0' <= ch && ch <= '9') {
            this.curExpressionBuilder = new NumberExpressionBuilder(ch);
        } else if (ch == '=' || ch == '>' || ch == '<' || ch == '!') {
            curExpressionBuilder = new EquationExpressionBuilder(ch);
        } else if (ch == '+') {
            curExpressionBuilder = new AddExpressionBuilder(ch);
        } else if (ch == '-') {
            curExpressionBuilder = new SubExpressionBuilder(ch);
        } else if (ch == '*') {
            curExpressionBuilder = new MulExpressionBuilder(ch);
        } else if (ch == '/') {
            curExpressionBuilder = new DivExpressionBuilder(ch);
        } else if(ch == '(') {
            curExpressionBuilder = new PriorityExpressionBuilder(ch);
        } else if(ch == '\'' || ch == '"') {
            curExpressionBuilder = new StringExpressionBuilder(ch);
        } else if(ch == ',') {
            this.expressionList.add(this.lastExpression);
            this.lastExpression = null;
        } else {
//        	System.out.println("???");
        }
        
        return true;
    }

}
