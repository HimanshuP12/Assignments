package Ques1;
import java.sql.SQLOutput;
import java.util.*;

interface consumer<A>{
    void accept(A m);
}
interface predicate<A>{
    boolean show(int x, int y);

    }
interface Supplier<A>{
    A show();
}
interface Function{
    int show(String a);
}
public class Ques1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        consumer<String> c = (m) -> {
            System.out.println("no return type :" + m);
        };
        c.accept("Himanshu");

        int x = sc.nextInt();
        int y = sc.nextInt();
        predicate<String> s = (a, b) -> {
            if (a > b) {
                return true;
            }
            return false;
        };
        System.out.println(s.show(x, y));

        int s1 = sc.nextInt();
        Supplier<Integer> su = () -> {
            return s1;
        };
        System.out.println(su.show());

        Function fn = (m) -> {
            if (m != " ") {
                return 1;
            } else {
                return 0;
            }
        };
        System.out.println(fn.show(""));
    }


}





