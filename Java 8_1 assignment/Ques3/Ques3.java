package Ques3;

interface myInterface{

     default void show(){
        System.out.println("hi all");
    }
}
interface myInterface1{
    default void show(){
        System.out.println("parent1");
    }

}
interface myInterface2{

    default void show(){
        System.out.println("parent2");
    }

}
public class Ques3 implements myInterface2,myInterface1 {

    public void show() {

        System.out.println("child");
        myInterface2.super.show();
    }


    public static void main(String args[]) {
        Ques3 obj = new Ques3();
        obj.show();


    }
}
