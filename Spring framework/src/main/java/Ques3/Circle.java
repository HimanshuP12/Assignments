package Ques3;

import org.springframework.stereotype.Component;

@Component
class Circle implements Area {
    final double radius=10.3;

    @Override
    public double calculateArea() {
        return  3.14*radius*radius;
    }
}
