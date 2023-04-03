package Ques1;

import Ques1.BubbleSort;
import Ques1.MergeSort;

public class Sorting {

    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();
        MergeSort mergeSort= new MergeSort();

        int[] array ={9,1,12,3,7,26,10};

        int[] result = bubbleSort.sort1(array);
        for (int i:result){
            System.out.print(i+" ");
        }
    }
}
