package Ques1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int x= sc.nextInt();
        int y= sc.nextInt();
        GrNo Gr = (a,b) -> a>b;
        System.out.println("greater no."+" "+Gr.greaterThan(x,y));
        Inc1 Inby1 = (c) -> ++c;
        System.out.println("no. after increment is:"+Inby1.Inc1(x));
        String s1= sc.next();
        String s2= sc.next();
        Concatination con =(d,e)-> d+e;
        System.out.println("string after concatination is:"+con.Concatination(s1,s2));
        ToUpperCase up=(g)->g.toUpperCase();
        System.out.println("string after uppercase is:"+up.UpperCase(s1));




    }
}
