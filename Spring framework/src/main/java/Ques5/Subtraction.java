package Ques5;


import org.springframework.stereotype.Component;

@Component
public class Subtraction implements Operation{
    @Override
    public int operation(int num1, int num2) {
        return num1-num2;
    }
}
