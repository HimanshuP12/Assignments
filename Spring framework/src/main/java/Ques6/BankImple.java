package Ques6;
import org.springframework.stereotype.Component;

@Component
public class BankImple {

    Bank bank;

    public BankImple(Bank bank) {
        this.bank = bank;
    }

    public  double get_Interest_Amount(int amount,int time){
        return bank.InterestRate(amount,time);
    }
}
