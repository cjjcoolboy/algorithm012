## 学习总结
### 相关知识

#### 位运算
> - 位运算符
> - 算数移位与逻辑移位
> - 位运算的应用

- 为什么需要位运算
   - 机器里的数字表示方式和存储格式就是二进制
- 位运算符
   - 左移   <<    
   - 右移   >>
   - 按位或 |
   - 按位与 &
   - 按位取反 ~
   - 按位异或（相同为零不同为一） ^
- XOR-异或
   > - 异或：相同为0，不同为1.也可用“不进位加法”来理解
   > - 异或操作的一些特点：
   >    - x ^ 0 = x
   >    - x ^ 1s = ~x //注意1s=~0   
   >    - x ^ (~x) = 1s
   >    - x ^ x = 0
   >    - c = a ^ b => a ^ c = b,b ^ c = a  // 交换两个数
   >    - a ^ b ^ c = a ^(b ^ c) = (a ^ b) ^ c   //associative
- 指定位置的位运算
   - 将x最右边的n位清零：x & (~0 << n)
   - 获取x的第n位值(0或者1)：(x >> n) & 1
   - 获取x的第n位的幂值：x & (1 << n)   
   - 仅将第n位置为1：x | (1 << n)
   - 仅将第n位置为0：x & (~(1 << n))
   - 将x最高位至第n位(含)清零：x & ((1 << n) - 1)
- 实战位运算要点
   - 判断奇偶
      - x%2==1 --> (x&1)==1
      - x%2==0 --> (x&1)==0
   - x >> 1 -->  x/2
      > 即：x=x/2; -->  x=x>>1;
      > mid=(left+right)/2; --> mid=(left+right)>>1;
   - X=X&(X-1)清零最低位的1
   - X&-X=>得到最低位的1
   - X&~X=>0   
- N皇后的位运算解法 - Python
   ```
      def totalNQueens(self,n):
          if n < 1: return []
          self.count = 0
          self.DFS(n,0,0,0,0)
          return self.count
          
      def DFS(self,n,row,cols,pie,na):
          # recursion terminator
          if row >= n:
              self.count += 1
              return
          
          bits = (~(cols | pie | na)) & ((1 << n) - 1) # 得到当前所有的空位
          
          while bits:
              p = bits & -bits # 取到最低位的1
              bits = bits & (bits - 1)  # 表示在p位置上放入皇后
              self.DFS(n,row+1,cols | p,(pie | p) << 1,(na | p) >> 1)
              # 不需要revert cols,pie,na的状态        
   ```   
- N皇后的位运算解法 - Java
   ```
       class Solution{
           private int size;
           private int count;
           
           private void solve(int row,int ld,int rd){
               if(row == size){
                   count++;
                   return;
               }
               int pos = size & (~(row | ld | rd));
               while(pos != 0){
                   int p = pos & (-pos);
                   // pos &= pos - 1;
                   pos -= p;
                   solve(row | p,(ld | p) << 1,(rd | p) >> 1);
               }
           }
           
           public int totalNQueens(int n){
               count = 0;
               size = (1 << n) - 1;
               solve(0,0,0);
               return count;
           }
       }
   ```

#### 布隆过滤器
> - 一个很长的二进制向量和一系列随机映射函数。
> - 作用：布隆过滤器可以用于检索一个元素是否在一个集合中
> - 优点：空间效率和查询时间都远远超过一半的算法
> - 缺点：有一定的误识别率和删除困难

#### LRU缓存
> - 两个要素：大小、替换策略(LFU、LRU)
> - Hash Table + Double LinkedList
> - O(1)查询、O(1)修改、更新

#### 排序算法
- 初级排序
   - 冒泡排序
   - 选择排序
   - 插入排序

- 高级排序
   - 快速排序
   - 归并排序
   - 堆排序