package cc.ccoder.selection;

import cc.ccoder.SortTestHelper;

import java.util.Comparator;

/**
 * <p>Selection Sort</p>
 *
 * @author chencong
 * @email www.ccoder.cc | cong.ccoder@gmail.com
 * @date SelectionSort.java v1.0  2020/10/8 17:53
 */
public class SelectionSort {

    /**
     * 不进行实例化
     */
    private SelectionSort() {

    }

    public static void sort(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            //寻找[i,n)区间内最小值元素
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                //在剩余待排序数组中找到最小元素
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    /**
     * 交换函数
     *
     * @param array 数组
     * @param i     待交换下标
     * @param j     待交换下标
     */
    private static void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer array[] = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort(SelectionSort.class, array);
    }
}
