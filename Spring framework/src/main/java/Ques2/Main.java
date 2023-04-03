package Ques2;

public class Main {
    public static void main(String[] args) {

        int[] array ={9,1,12,3,7,26,10};

        SortingImple sortingImple = new SortingImple(new MergeSort());
        int[] result = sortingImple.result(array);
        for (int i:result){
            System.out.print(i+" ");
        }
    }
}
