package cc.ccoder.heapify;

public class MaxHeap<T extends Comparable> {

    private T[] data;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        data = (T[]) new Comparable[capacity + 1];
    }

    public MaxHeap(T[] arr) {
        int n = arr.length;
        data = (T[]) new Comparable[n + 1];
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;
        capacity = n;
        /*上面构造了一个空间为arr.length大小的数组*/
        /*下面对这个数组进行构造成二叉树，二叉堆*/
        /*这里这个count/2 为 每次找最后一个只有叶子结点的根节点 */
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }

    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int size() {
        return this.count;
    }

    public void insert(T item) {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    public T extract() {
        assert count > 0;
        T result = data[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return result;
    }

    private void shiftDown(int i) {
        while (2 * i <= count) {
            int j = 2 * i;
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            if (data[i].compareTo(data[j]) > 0) {
                break;
            }
            swap(i, j);
            i = j;
        }
    }

    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void swap(int k, int i) {
        T item = data[k];
        data[k] = data[i];
        data[i] = item;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        maxHeap.insert(10);
        maxHeap.insert(2);
        maxHeap.insert(14);
        System.out.println(maxHeap.size());
        int size = maxHeap.size();
        for (int i = 0; i < size; i++) {
            System.out.print(maxHeap.extract() + " ");
        }
    }

}
