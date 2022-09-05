import org.w3c.dom.ls.LSOutput;

import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance=Calculator::new;
    BinaryOperator<Integer> plus = (x,y) -> x+y;
    BinaryOperator<Integer> minus = (x,y) -> x-y;
    BinaryOperator<Integer> multiply = (x,y) -> x* y;
    BinaryOperator<Integer> devide = (x,y) ->{
        if(y==0){
            System.out.println("На ноль делить нельзя");
            return 0;
        }else{
            return x/y;
        }
    };

    UnaryOperator<Integer> pow = x-> x* x;
    UnaryOperator<Integer> abs = x->x>0? x : x* (-1);

    Predicate<Integer> isPositive = x-> x>0;

    Consumer<Integer> println = System.out::println;

    public static void main(String[] args) {
        Calculator calc=Calculator.instance.get();
        int a=calc.plus.apply(1,2);
        int b=calc.minus.apply(1,1);
        int c=calc.devide.apply(a,b);
        calc.println.accept(c);

    }
}
