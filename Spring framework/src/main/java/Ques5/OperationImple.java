package Ques5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationImple {



    public OperationImple( Operation operation) {

        this.operation = operation;
    }


    @Autowired
    Operation operation;


    public int calculate(int a,int b){

        return (operation.operation(a,b));
    }
}
