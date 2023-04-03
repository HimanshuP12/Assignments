package Ques2;

public class SortingImple {

    private Sorting sorting;

    public SortingImple(Sorting sorting) {
        this.sorting = sorting;
    }

    public int[] result(int a[]){
        sorting.sort(a);
        return a;
    }
}
