package cc.ccoder.maxHeapBasic;

public class MaxHeap<T> {

    private T[] data;
    private int count;


    /**
     * 初始化堆空间，对空间为capacity，使用数组大小为[capacity+1]，数组初始位置0索引不使用。
     *
     * @param capacity 堆空间
     */
    public MaxHeap(int capacity) {
        data = (T[]) new Object[capacity + 1];
        this.count = 0;
    }

    /**
     * 堆大小
     *
     * @return 堆中元素个数
     */
    public int size() {
        return this.count;
    }

    /**
     * 判断堆是否为空
     *
     * @return 判断堆是否为空，如果堆中元素格式count==0，则堆为空
     */
    public boolean isEmpty() {
        return this.count == 0;
    }


    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        System.out.println(maxHeap.size());
        System.out.println(maxHeap.isEmpty());
        /*
         * 0 堆空间为100 但是堆中并没有元素
         * true  堆为空
         * */
    }
}
