package Question2;

interface myInterface{
    int methodRef(int x1,int y1);
}
public class Ques2 {
    static int multi(int x1, int y1){
        return x1*y1;
    }
    int sum(int x1, int y1){
        return x1+y1;
    }
    int sub(int x1, int y1){
        return x1-y1;
    }
    public static void main(String[]args){
        myInterface mult = Ques2::multi;
        System.out.println("Multiple = "+mult.methodRef(3,4));
        myInterface sum1 = new Ques2()::sum;
        System.out.println("Sum = "+sum1.methodRef(2,5));
        myInterface sub1 = new Ques2()::sub;
        System.out.println("Substraction = "+sub1.methodRef(7,2));
    }
}