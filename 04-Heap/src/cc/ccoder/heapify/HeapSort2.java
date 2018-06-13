package cc.ccoder.heapify;

public class HeapSort2 {

    public static void sort(Comparable[] arr){
        int length = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);
        for (int i = 0; i < length - 1; i++) {
            arr[i] = maxHeap.extract();
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1,3,4,9,4,2,1,0,6,4,8,23,11,3};
        sort(arr);
        for (Integer item : arr) {
            System.out.print(item+" ");
        }
    }
}
