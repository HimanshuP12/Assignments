package Ques3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class Main{
    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Main.class);
        AreaImple areaImple = applicationContext.getBean(AreaImple.class);
        System.out.println(areaImple.get_area());

    }







}
