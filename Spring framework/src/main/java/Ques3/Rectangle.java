package Ques3;
import org.springframework.stereotype.Component;

@Component
 class Rectangle implements Area {
    double length=10.3;
      double breath=12.6 ;

    @Override
    public double calculateArea() {
        return  length*breath;
    }
}
