package ques4;

public class Main {
    public static void main(String[]args){
        constructRef construct = Ques4::new;
        Ques4 ques=construct.message("construct reference");
    }
}