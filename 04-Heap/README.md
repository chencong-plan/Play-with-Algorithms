## 堆和优先队列 Heap And Priority Queue

### 优先队列
+ 普通队列
> 先进先出，后进后出
+ 优先队列
> 出队顺序和入队顺序无关，和优先级相关

### 为什么使用优先队列？
> 在1000000个元素当中取出前100个，类似于在N个元素中选取前M个元素
+ 排序 NlogN
+ 优先队列 NlogM
当N越大时，两个的差别越大。

### 优先队列的实现方式

---|出队|入队
- | :-: | -: 
普通数组|O(1)|O(n)
顺序数组|O(n)|O(1)
堆|O(lgn)|O(lgn)

Name | Academy | score 
- | :-: | -: 
Harry Potter | Gryffindor| 90 
Hermione Granger | Gryffindor | 100 
Draco Malfoy | Slytherin | 90

| 参数 |详细解释|备注| 
| - | - | 
| -l | use a long listing format |以长列表方式显示（显示出文件/文件夹详细信息） | 
| -t | sort by modification time |按照修改时间排序（默认最近被修改的文件/文件夹排在最前面） | 
|-r | reverse order while sorting |逆序排列|