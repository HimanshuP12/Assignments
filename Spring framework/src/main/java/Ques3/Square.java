package Ques3;

import org.springframework.stereotype.Component;

@Component
class Square implements Area{
    final double side=10.3;

    @Override
    public double calculateArea() {
        return side*side;
    }
}
