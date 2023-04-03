package Ques4;

import org.springframework.stereotype.Component;

@Component
public class Cube implements Number{
    @Override
    public int calculate(int a) {
        return a*a*a;
    }
}
