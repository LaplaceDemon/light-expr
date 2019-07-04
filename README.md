# light-expr
解析表达式抽象语法树

Maven：
```xml
<dependency>
    <groupId>io.github.laplacedemon</groupId>
    <artifactId>light-expr</artifactId>
    <version>0.1.0</version>
</dependency>
```


解析表达式

```java
// 表达式
String expression = "x = a + b + c*d + sin(e) + max(e,f)";

// 构建解析器
Parser parser = new Parser(expression);

// 开始解析，得到结果
BaseExpression be = parser.parse();

// 打印
System.out.println(be);

```

打印结果：
```
 = [ x , + < + < + < + < a , b > , * < c , d > > , sin < e > > , max < [e, f] > > ]
```

这是一个抽象语法树的打印结果，它表示表达式是这样一个树形结构：
```
  ______ = ______
 /               \
x           _____ + _____
           /             \
       _ + _             max( )
      /     \                |
     +     sin( )           e,f
   /   \       |
  +     *      e
 / \   / \
a   b c   d
```


## 更多用例：

<pre>
x = 1 + 2 ==>  = [ x , + < 1 , 2 > ]
x = 1 - 2 ==>  = [ x , - < 1 , 2 > ]
x = 1 * 2 ==>  = [ x , * < 1 , 2 > ]
x = 1 / 2 ==>  = [ x , / < 1 , 2 > ]

x = 1 / 2 + 3 ==>  = [ x , + < / < 1 , 2 > , 3 > ]
x = 1 / 2 - 3 ==>  = [ x , - < / < 1 , 2 > , 3 > ]

y = 1*2*3 ==>  = [ y , * < * < 1 , 2 > , 3 > ]
y = 1*2*3*4 ==>  = [ y , * < * < * < 1 , 2 > , 3 > , 4 > ]
y = 1*2*3*4*5 ==>  = [ y , * < * < * < * < 1 , 2 > , 3 > , 4 > , 5 > ]
y = 1*2*3*4*5 + 1*2*3*4 ==>  = [ y , + < * < * < * < * < 1 , 2 > , 3 > , 4 > , 5 > , * < * < * < 1 , 2 > , 3 > , 4 > > ]

x = 1 + 2 * 3 ==>  = [ x , + < 1 , * < 2 , 3 > > ]
x = 1 * 2 + 3 * 4 + 5 * 6 ==>  = [ x , + < + < * < 1 , 2 > , * < 3 , 4 > > , * < 5 , 6 > > ]
x = 1 * 2 + 3 * 4 * 5 ==>  = [ x , + < * < 1 , 2 > , * < * < 3 , 4 > , 5 > > ]

x = 1 - 2 ==>  = [ x , - < 1 , 2 > ]
x = 1 - 2 * 3 ==>  = [ x , - < 1 , * < 2 , 3 > > ]
x = 1 - 2 - 3 ==>  = [ x , - < - < 1 , 2 > , 3 > ]
x = 1 * 2 - 3 ==>  = [ x , - < * < 1 , 2 > , 3 > ]
x = 1 * 2 - 3 * 4 ==>  = [ x , - < * < 1 , 2 > , * < 3 , 4 > > ]
x = 1 * 2 - 3 * 4 - 5 ==>  = [ x , - < - < * < 1 , 2 > , * < 3 , 4 > > , 5 > ]
x = 1 * 2 + 3 * 4 * 5 ==>  = [ x , + < * < 1 , 2 > , * < * < 3 , 4 > , 5 > > ]
x = 1 * 2 + 3 * 4 * 5 + 6 ==>  = [ x , + < + < * < 1 , 2 > , * < * < 3 , 4 > , 5 > > , 6 > ]

x = (1 + 2) * 3 ==>  = [ x , * < + < 1 , 2 > , 3 > ]
x = (1 + 2) * (3 + 4) ==>  = [ x , * < + < 1 , 2 > , + < 3 , 4 > > ]
x = sin(1 + 2) * cos(3 + 4) ==>  = [ x , * < sin < + < 1 , 2 > > , cos < + < 3 , 4 > > > ]

y = sin(x) ==>  = [ y , sin < x > ]
y = sin(x+1) ==>  = [ y , sin < + < x , 1 > > ]
y = sin(x+1) + 2 ==>  = [ y , + < sin < + < x , 1 > > , 2 > ]
y = sin(x+1) + 2*3 ==>  = [ y , + < sin < + < x , 1 > > , * < 2 , 3 > > ]
y = sin(x+1) + 2*3 ==>  = [ y , + < sin < + < x , 1 > > , * < 2 , 3 > > ]
y = sin(x+1) + cos(2*3) ==>  = [ y , + < sin < + < x , 1 > > , cos < * < 2 , 3 > > > ]
y = sin(x+1) ==>  = [ y , sin < + < x , 1 > > ]

y = sin(sin(x)) ==>  = [ y , sin < sin < x > > ]
y = sin(a + cos(b)) ==>  = [ y , sin < + < a , cos < b > > > ]

y = a + sin(b) ==>  = [ y , + < a , sin < b > > ]
y = a * sin(b) ==>  = [ y , * < a , sin < b > > ]
y = a / sin(b) ==>  = [ y , / < a , sin < b > > ]

y = cos(sin(x)) ==>  = [ y , cos < sin < x > > ]
y = cos(sin(a) + b*c + sin(d*e)) ==>  = [ y , cos < + < + < sin < a > , * < b , c > > , sin < * < d , e > > > > ]
y = cos(sin(a)*cos(b) + b*c + sin(d*e)) ==>  = [ y , cos < + < + < * < sin < a > , cos < b > > , * < b , c > > , sin < * < d , e > > > > ]

y = 'a' + 'b' ==>  = [ y , + < 'a' , 'b' > ]
y = cos('a' + 'b') ==>  = [ y , cos < + < 'a' , 'b' > > ]
y = cos('a'*12 + 'b') ==>  = [ y , cos < + < * < 'a' , 12 > , 'b' > > ]

a ==> a

obj.x ==> [obj, x]
obj1.f1 + obj2.f2 ==> + < [obj1, f1] , [obj2, f2] >

max(a, b) ==> max < [a, b] >
min(a, b) ==> min < [a, b] >
min(a+b,c) ==> min < [+ < a , b >, c] >
min(a+b,c,d) ==> min < [+ < a , b >, c, d] >
min(a+b,c,d+e) ==> min < [+ < a , b >, c, + < d , e >] >
min(a+b,c,sin(d+e)) ==> min < [+ < a , b >, c, sin < + < d , e > >] >

cos(a+b),c,sin(d+e) ==> [cos < + < a , b > >, c, sin < + < d , e > >]
cos(a+b),obj.f1,sin(d+e) ==> [cos < + < a , b > >, [obj, f1], sin < + < d , e > >]
</pre>
