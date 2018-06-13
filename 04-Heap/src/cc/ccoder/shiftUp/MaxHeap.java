package cc.ccoder.shiftUp;

public class MaxHeap<T extends Comparable> {

    protected T[] data;
    protected int count;
    protected int capacity;


    /**
     * 初始化堆空间，对空间为capacity，使用数组大小为[capacity+1]，数组初始位置0索引不使用。
     *
     * @param capacity 堆空间
     */
    public MaxHeap(int capacity) {
        data = (T[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
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


    /**
     * 插入元素到堆当中来。
     *
     * @param item 将插入的元素
     */
    public void insert(T item) {
        /*首先需要判断插入元素时，堆大空间是否充足，空间数组是否存在越界*/
        assert count + 1 <= capacity;
        data[count + 1] = item;
        /*堆中元素加一*/
        count++;
        /*判断count位置的元素是否满足最大堆的性质*/
        shiftUp(count);
    }

    /**
     * 最大堆的插入元素的核心思想。
     *
     * @param k 插入元素的索引
     */
    private void shiftUp(int k) {
        /*最大堆性质：当前元素一定比他的父节点小，同时父节点和子节点的索引为2倍关系(从上至下、从左至右存储在data数组中)*/
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    /**
     * 交换数组中两个元素
     *
     * @param k 父节点
     * @param i 子节点
     */
    private void swap(int k, int i) {
        T item = data[k];
        data[k] = data[i];
        data[i] = item;
    }


    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);

        int N  = 31;
        int M = 100;
        for (int i = 0; i < N; i++) {
            maxHeap.insert((int) (Math.random()*M));
        }
        System.out.println(maxHeap.size());
    }
}
