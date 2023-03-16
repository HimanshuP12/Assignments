package Ques11;

public class Ques11 {
    public static void main(String[] args)
    {
        record student(String name, int age, int id){
            static int counter=0;
            static void increase(){
                counter++;
            }
            student{
                increase();
            }
        };
        student sc=new student("Himanshu Panchal",22,1);
        student st=new student("sandy sharma",23,2);
        System.out.println(sc.equals(st));
        System.out.println("counter="+student.counter);
    }
}