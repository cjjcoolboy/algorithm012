## 学习总结

栈、队列、优先队列、双端队列

#### 栈Stack
- 先入后出
- 添加、删除皆为O(1)
- 查询O(n)

#### 队列Queue
- 先入先出
- 添加、删除皆为O(1)
- 查询O(n)

#### 双端队列Deque-double ended queue
- 两端都可以进出
- 插入、删除皆为O(1)
- 查询O(n)

#### 优先队列Priority Queue
- 插入O(1)
- 取出O(logN)-按照元素的优先级取出
- 底层具体实现的数据结构较为多样和复杂：heap、bst(二叉搜索树)、treap

#### 树、二叉树、二叉搜索树
树
二叉树
二叉搜索树
- 查询O(logN)
- 插入O(logN)
- 删除O(logN) 

#### 堆、二叉堆
- 可以迅速找到一堆数中的最大或者最小值的数据结构
- 根节点最大的堆叫做大顶堆或者大根堆
- 根节点最小的堆叫做小顶堆或者小根堆
- 常见的堆
   - 二叉堆
      - 通过完全二叉树来实现（注意：不是二叉搜索树）
      - 是一棵完全树
      - 树中任意节点的值总是>=其子节点的值
      - 数组来实现，左孩子的索引为2*i+1，右孩子的索引为2*i+2，父节点的索引为floor((i-1/2))
   - 斐波拉契堆
- 常见操作(API)   
   - find-max/min: O(1)
   - delete-max/min: O(logN)
      - heapifyDown
   - insert(create): O(logN) or O(1)
      - heapifyUp
- 不同实现的比较：https://en.wikipedia.org/wiki/Heap_(data_structure) 
   - 二叉堆是堆（优先队列priority_queue）的一种常见且简单的实现；但是并不是最优的实现

#### 图
- 属性
   - Graph(V,E)
   - V - vertex:点
      1. 度 - 入度和出度
      2. 点与点之间：连通与否
   - E - edge:边
      1. 有向和无向（单行线）
      2. 权重（边长）   
- 数据结构
   - 邻接表
   - 邻接矩阵
- 常见的算法
   - BFS
   - DFS
   - 注意：visited记录重复一定要记得         
---

#### HashMap总结
- 是什么
   1. HashMap是一个用于存储Key-Value键值对的集合
   2. 最常用的两个方法：get和put
- 底层原理
   1. 数据结构（put原理）
      - 数组+链表（拉链法）：
         1. 通过hash函数计算出key所在数组的index，把value保存在数组对应的index位置上
         2. 链表用于解决index冲突，如果不同的key计算出相同的index，那么采用链表解决冲突
         3. 后插入的index冲突会放在链表的头部
      - 数组+红黑树（链表长度达到8，就会转化为红黑树）   
      - 数组：只使用数组存储数据，遇到冲突顺延往下寻找空位index保存value（开放寻址法）
   2. get原理
      - 无冲突：把输入的key做hash计算，得到index，直接在数组中取出。
      - 有冲突：把输入的key做hash计算，得到index，获取多个Entry<K,V>，对比要查找的key。   
   3. 初始长度是16，每次自动扩展或者是手动初始化时，必须是2的幂
   4. hash函数采用位运算
   5. ReHash
      - 当HashMap达到一定饱和度时候，冲突概率会变高，这时候会进行Resize
      - 影响发生Resize的因素
         1. Capacity：HashMap当前的长度
         2. LoadFactor：HashMap的负载因子，默认值为0.75f   
      - 衡量HashMap是否进行Resize的条件
         - size >= Capacity * LoadFactor  
      - resize有两步
         - 扩容：创建一个长度为原来数组的两倍的新数组
         - ReHash： 遍历原来数组，重新计算hash到新数组
      - 高并发情况下的resize会引发死循环
         - 解决：使用ConcurrentHashMap   
   6. jdk8与jdk7的不同
      - 当发生hash冲突时候，jdk7是在链表头部插入新元素，而jdk8是在尾部插入新元素   
- HashMap的遍历方式与性能分析
   - 遍历方式
      1. 使用迭代器（Iterator）EntrySet 的方式进行遍历
         ```aidl
         public void iteratorEntrySet(){
                 Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
                 while (iterator.hasNext()){
                     Map.Entry<Integer, String> entry = iterator.next();
                     log.info("key:{}",entry.getKey());
                     log.info("value:{}",entry.getValue());
                 }
             }
         ```
      2. 使用迭代器（Iterator）KeySet 的方式进行遍历
          ```aidl
                  public void iteratorEntrySet(){
                          Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
                          while (iterator.hasNext()){
                              Map.Entry<Integer, String> entry = iterator.next();
                              log.info("key:{}",entry.getKey());
                              log.info("value:{}",entry.getValue());
                          }
                      }
          ```
      3. 使用 For Each EntrySet 的方式进行遍历
          ```aidl
                  public void forLoopEntrySet(){
                          for (Map.Entry<Integer, String> entry : map.entrySet()) {
                              log.info("key:{}",entry.getKey());
                              log.info("value:{}",entry.getValue());
                          }
                      }
          ```
      4. 使用 For Each KeySet 的方式进行遍历
          ```aidl
                  public void forLoopKeySet(){
                          for (Integer key : map.keySet()) {
                              log.info("key:{}",key);
                              log.info("value:{}",map.get(key));
                          }
                      }
          ```
      5. 使用 Lambda 表达式的方式进行遍历
          ```aidl
                  public void lambda1(){
                          log.warn("lambda1..........");
                          map.forEach((key,value) -> {
                              log.info("key:{}",key);
                              log.info("value:{}",value);
                          });
                      }
             
                 public void lambda2(){
                     map.forEach((key,value) -> {
                         log.info("key:{}",key);
                         log.info("value:{}",map.get(key));
                     });
                 }
          ```
      6. 使用 Streams API 单线程的方式进行遍历
          ```aidl
                  public void streamApi(){
                          map.entrySet().stream().forEach(innerMap -> {
                              log.info("key:{}",innerMap.getKey());
                              log.info("value:{}",innerMap.getValue());
                          });
                      }
          ```
      7. 使用 Streams API 多线程的方式进行遍历
          ```aidl
                  public void parallelStreamApi(){
                          map.entrySet().parallelStream().forEach(innerMap -> {
                              log.info("key:{}",innerMap.getKey());
                              log.info("value:{}",innerMap.getValue());
                          });
                      }
          ```
   - 性能分析   
      - 通过使用JMH测试，结果发现使用lambda和并行stream遍历HashMap是比较快
      ```
        Benchmark                      Mode  Cnt  Score   Error  Units
        HashMapTest.forLoopEntrySet    avgt    5  2.020 ± 0.540   s/op
        HashMapTest.forLoopKeySet      avgt    5  2.005 ± 0.392   s/op
        HashMapTest.iteratorEntrySet   avgt    5  2.123 ± 0.496   s/op
        HashMapTest.iteratorKeySet     avgt    5  2.767 ± 6.540   s/op
        HashMapTest.lambda1            avgt    5  1.997 ± 0.343   s/op
        HashMapTest.lambda2            avgt    5  2.038 ± 0.625   s/op
        HashMapTest.parallelStreamApi  avgt    5  1.956 ± 0.256   s/op
        HashMapTest.streamApi          avgt    5  2.085 ± 0.448   s/op
      ```           
---

#### 面试做题四件套
1. clarification
   - 和面试官把题目过一遍，确认一些细节
2. possible solution --> optimal (time & space)
   - 尽可能找出最优解，时间和空间的最优解
3. code
   - 开始编码
4. test cases
   - 测试用例
 