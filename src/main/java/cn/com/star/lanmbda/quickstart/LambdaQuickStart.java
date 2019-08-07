package cn.com.star.lanmbda.quickstart;

/**
 * This is a simple lambda demo
 * lambda 是JDK1.8的新特性，它的简单表达如下：
 * 1：{parameters}-> expression (表达式方式)
 * 2：{parameters}-> {statements;} (语句块)
 * <p>
 * Lambda 的重要特性
 * <ul>
 *   <li> 可选类型声明: 不需要声明参数类型， 编译器会统一识别参数类型
 *   <li> 可选的参数圆括号：一个参数无需定义圆括号但是多个参数是需要定义圆括号
 *   <li> 可选的大括号： 如果主体只包含一个语句，就不需要使用大括号
 *   <li> 可选的返回关键字： 如果主体只有一个表达式返回值则编译器会自动返回值
 * </ul>
 */
public class LambdaQuickStart {
    public static void main(String[] args) {
        LambdaQuickStart lambdaQuickStart = new LambdaQuickStart();
        //不需要参数类型, 没有return和{}
        MathOperation sum = (int a, int b) -> a + b;
        //类型声明
        MathOperation minus = (int a, int b) -> a - b;
        //如果存在大括号需要return 并且需要结束；
        MathOperation multiple = (a, b) -> a * b;
        //operate
        System.out.println(lambdaQuickStart.operate(10, 5, sum));
        System.out.println(lambdaQuickStart.operate(25, 10, minus));
        System.out.println(lambdaQuickStart.operate(35, 25, multiple));
    }

    private int operate(int i, int j, MathOperation mathOperation) {
        return mathOperation.operation(i, j);
    }
}
