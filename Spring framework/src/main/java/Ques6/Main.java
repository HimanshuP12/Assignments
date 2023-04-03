package Ques6;


import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("Ques6")
public class Main {


    BankImple bankImple;

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Main.class);
        BankImple bankImple1 = applicationContext.getBean(BankImple.class);

        Main obj = new Main();
        obj.setBankImple(bankImple1);
        obj.result();


    }

    public void setBankImple(BankImple bankImple) {
        this.bankImple = bankImple;
    }

    public void result() {
        System.out.println(bankImple.get_Interest_Amount(500000, 5));
    }
}
