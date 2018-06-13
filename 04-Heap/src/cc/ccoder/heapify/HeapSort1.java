package cc.ccoder.heapify;

public class HeapSort1 {

    /**
     * 循环的将数组arr当中的元素放入堆当中，然后依次输出堆根节点。
     *
     * @param arr 将要排序的数组
     */
    public static void sort(Comparable[] arr) {
        int length = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(length + 1);
        for (Comparable anArr : arr) {
            maxHeap.insert(anArr);
        }
        for (int i = length - 1; i >= 0; i--) {
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
