package Ques5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Main.class);
        OperationImple operationImple = applicationContext.getBean(OperationImple.class);

        System.out.println(operationImple.calculate(10,7));
    }
}
