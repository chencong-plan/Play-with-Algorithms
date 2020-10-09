### Selection Sort

对已知数组进行选择排序。

首选在未排序的数组中找到最小(最大)的元素，将其放在数组的起始位置；

再从剩余未排序的元素中继续寻找最小(最大)的元素，将其放在已排序序列的末尾。

依次类推，直到所有元素均排序完成。

![image-20201008175936206](http://ccoder-image.oss-cn-shanghai.aliyuncs.com/2020-10-08-095937.png)

```java
//Selection Sort
public static void sort(int[] array, int n) {
    for (int i = 0; i < n; i++) {
        //寻找[i,n)区间内最小值元素
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            //在剩余待排序数组中找到最小元素
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        swap(array, i, minIndex);
    }
}

//Swap 交换函数
/**
 * 交换函数
 * @param array 数组
 * @param i 待交换下标
 * @param j 待交换下标
 */
private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

```

上面已经完成了对数组(整型)进行排序，可以将其修改成泛型支持其他类型的排序。

另外对于测试各个排序算法的性能，会需要生成指定长度的数组，在此创建测试辅助类。





### 辅助测试

- 随机生成指定长度、范围数组`Integer[] generateRandomArray(int n, int rangeL, int rangeR)`
- 判断数组是否有序 `static boolean isSorted(Comparable[] array)`我这里使用从小打到顺序
- 反射调用排序算法，判断其排序是否成功，计算排序时间 `void testSort(Class<?> clazz, Comparable[] array)`
- 打印数组 `void printArray(Object[] array)` 针对少量数据可以调用，数据量上去了不要将数组打印出来。

```java
package cc.ccoder;

import java.lang.reflect.Method;

/**
 * <p></p>
 *
 * @author chencong
 * @email www.ccoder.cc | cong.ccoder@gmail.com
 * @date SortTestHelper.java v1.0  2020/10/8 18:26
 */
public class SortTestHelper {

    private SortTestHelper(){

    }

    /**
     * 生成有n个元素的数组，每个元素的范围是[rangL,rangR]区间
     *
     * @param n      数组大小长度
     * @param rangeL 数组左区间
     * @param rangeR 数组右区间
     * @return 生成的数组
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        // 判断数组区间是否合法
        assert rangeL <= rangeR;
        assert n >= 0;
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            //随机产生一个[rangL,rangR]之间的元素，填入数组当中
            array[i] = (int) (Math.random() * ((rangeR - rangeL) + 1)) + rangeL;
        }
        return array;
    }

    /**
     * 打印输出指定数组
     *
     * @param array 将要进行打印的数组
     */
    public static void printArray(Object[] array) {
        for (Object o : array) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    /**
     * 判断指定数组是否有序 array[i-1] < array[i]
     *
     * @param array 将要进行判断的数组
     * @return 返回是否有序
     */
    public static boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 测试clazz所对应的排序算法排序数组array所得到正确性和算法运行时间
     *
     * @param clazz 将要使用的排序算法
     * @param array 将要进行排序的数组
     */
    public static void testSort(Class<?> clazz, Comparable[] array) {
        try {
            Method sortMethod = clazz.getMethod("sort", Comparable[].class);
            // 参数只有一个，就是将要排序的数组
            Object[] params = new Object[]{array};
            // 开始计数
            Long beginTime = System.currentTimeMillis();
            //调用排序算法
            sortMethod.invoke(null, params);
            //结束计数
            Long endTime = System.currentTimeMillis();
            //判断是否正确排序
            assert isSorted(array);
            //共用时
            System.out.println(clazz.getSimpleName() + " : " + (endTime - beginTime) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

对数组`[9, 8, 3, 6, 7, 4, 31, 2, 1]`进行排序，上面提到了我将每一次排序的结果进行打印.

```
[9, 8, 3, 6, 7, 4, 31, 2, 1]  // 原始数据 9为起始位置，剩余数据中寻找最小值1，与9的位置替换，得到的结果
[1, 8, 3, 6, 7, 4, 31, 2, 9]  // 8 为起始位置，在剩余数据中寻找到最小值2,与8位置替换，得到的结果
[1, 2, 3, 6, 7, 4, 31, 8, 9]  
[1, 2, 3, 6, 7, 4, 31, 8, 9]
[1, 2, 3, 4, 7, 6, 31, 8, 9]
[1, 2, 3, 4, 6, 7, 31, 8, 9]
[1, 2, 3, 4, 6, 7, 31, 8, 9]
[1, 2, 3, 4, 6, 7, 8, 31, 9]
[1, 2, 3, 4, 6, 7, 8, 9, 31]
[1, 2, 3, 4, 6, 7, 8, 9, 31]  // 遍历整个数组之后，得到的结果
```

起始位置`minIndex`遍历整个数组之后就可以完成`SelectionSort`选择排序。

根据上面的结果来计算，外层循环移动确定`minIndex`为`O(n)`，在每一循环内还需要寻找`[i,n)`之间的最小值也是`O(n-1)`，因此时间复杂度为`O(n(n-1)) ≈ O(n²)`。

