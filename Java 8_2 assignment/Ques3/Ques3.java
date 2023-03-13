package Ques3;

import java.util.Arrays;
import java.util.List;

public class Ques3 {
    public static void main(String[]args){
        List<Integer> aList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,15);
        int sum = aList.stream()
                .filter(a->a>5)
                .reduce(0,(total,a)->(total+a));
        System.out.println("Sum of all numbers greater than 5 = "+sum);
    }
}
