package Ques4;

import org.springframework.stereotype.Component;

@Component
public class SquareRoot implements Number{
    @Override
    public int calculate(int a) {
        return (int) Math.sqrt(a);
    }
}
