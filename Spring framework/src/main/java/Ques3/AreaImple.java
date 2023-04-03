package Ques3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class AreaImple {

    @Autowired
    @Qualifier(value = "square")
    Area  area ;

    public double get_area(){
        return area.calculateArea();
    }
}
