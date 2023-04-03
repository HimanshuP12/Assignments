package Ques6;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BoiBank implements Bank{
    @Override
    public double InterestRate(int amount, int time) {
        return (7.4*amount*time)/100;
    }
}
