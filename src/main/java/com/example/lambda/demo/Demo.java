package com.example.lambda.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    public interface Printable {
        void print();
    }

    public void testPrintable() {
        Printable printable = () -> System.out.println("aaa");
        printable.print();
    }

    public static void main(String[] args) {
        Stream.of(1, 4, 6).filter(bInteger -> bInteger > 3);

        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
// 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();

        IntStream intStream = Stream.of(1,2,3,4,5,7).mapToInt(integer -> integer);
        Runnable runnable=()-> System.out.print("hello lambda");
        runnable.run();
        LambdaUse(s->System.out.println(s),"Hello world.");
        // 测试功能型
        // 平方
        Integer aInteger = new Integer(12);
        String string = "outerline";
        Function<Integer, Integer> function = a -> {
            return a * a;
        };
        System.out.println("功能型接口  :" + function.apply(aInteger));
        // 测试供给型接口
        // 生成一个随机数
        Supplier<Integer> supplier = () -> {
            Random random = new Random();
            return random.nextInt(45);
        };
        System.out.println("供给型接口  " + supplier.get());
        // 断言式接口
        // 判断一个数是否大于0
        Predicate<Integer> predicate = a -> {
            return a > 0;
        };
        System.out.println("断言式接口  " + predicate.test(18));
        // 消费性接口
        // 输出输入的参数
        Consumer<String> consumer = a -> {
            System.out.println("消费性接口内部  " + a.length() + "  " + string);
        };
        System.out.println("调用消费性接口");
        consumer.accept("xiaofeixingjiekoucanshu");

        List<String> list = new ArrayList<>();
        list.stream().filter((String s) -> {
            return s.length() < 10;
        }).map(str -> str.length()).forEach(str2 -> System.out.println(str2));

        /**
         * 测试内部类与lambda表达式的词法作用域上的差别
         */
        Demo test = new Demo();
        System.out.println("测试lambda和内部类的词法作用域");
        test.print();
    }
    @FunctionalInterface
    interface ILambdaTest1{
        void print(String s);
        default void print(){
            LambdaUse(s->System.out.print(s),"Hello world.");
        }
    }

    public static void LambdaUse(ILambdaTest1 lambda,String string){
            lambda.print(string);
        }

    public void print() {
        Consumer<String> consumer = str -> {
            System.out.println(str + "  " + this);
        };
        Consumer<String> consumer2 = new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println(t + "  " + this);
            }

            @Override
            public String toString() {
                return "inner class ";
            }
        };

        consumer.accept("lambda");
        consumer2.accept("anonymous Class");
    }

}
