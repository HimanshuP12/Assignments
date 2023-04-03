package Ques5;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Addition implements Operation{
    @Override
    public int operation(int a,int b) {
        return a+b;
    }
}
