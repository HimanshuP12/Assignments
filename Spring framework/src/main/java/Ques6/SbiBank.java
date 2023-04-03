package Ques6;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SbiBank implements Bank{
    @Override
    public double InterestRate(int amount,int time) {
        return (6.81*amount*time)/100;
    }
}
