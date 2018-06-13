package cc.ccoder.shiftDown;

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
     * 输出堆的根节点，值最大的元素
     *
     * @return 返回堆中值最大的元素
     */
    public T extractMax() {
        /*首先判断堆中应该还存在元素*/
        assert (count > 0);

        /*取出根节点元素*/
        T result = data[1];
        /*将根节点和最后一个结点交换，然后堆空间减少一个==> 等同于将根节点删除*/
        swap(1, count);
        /*一定要先除去最后一个元素 count--*/
        count--;
        /*最重要的操作，继续保证数组是一个二叉树*/
        shiftDown(1);
        return result;

    }

    /**
     * 判断结点i位置元素是永远不小于子节点。
     *
     * @param i 将要往下移动的结点索引
     */
    private void shiftDown(int i) {
        /*如果还有子节点就继续循环，在二叉树当中2*i为当前节点的左孩子节点*/
        while (2 * i <= count) {
            int j = 2 * i;
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                /*如果存在右孩子节点(j+1) 并且右孩子节点(j+1)大于左孩子结点(j),那么就j++*/
                j++;
                /*总保证data[j]是data[j]和data[j+1]当中最大的那一个*/
            }
            if (data[i].compareTo(data[j]) >= 0) {
                break;
                /*如果当前节点已经大于左孩子结点和右孩子节点中最大的那一个(当前节点大于其两个子节点)*/
            }
            /*交换子节点和父节点的值*/
            swap(i, j);
            /*继续交换*/
            i = j;
        }
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

        int N = 5;
        int M = 100;
        for (int i = 0; i < N; i++) {
            maxHeap.insert((int) (Math.random() * M));
        }
        System.out.println(maxHeap.size());
        int size = maxHeap.size();
        for (int i = 0; i < size; i++) {
            System.out.print(maxHeap.extractMax() + " ");
        }
    }
}
