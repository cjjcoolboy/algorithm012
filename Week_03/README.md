## 学习总结
### 相关知识

#### 递归Recursion
> 树的面试题解法一般都是递归
> 1. 节点的定义 
> 2. 重复性（自相似性）

- 递归-循环
- 通过函数体来进行的循环
- 代码模版
   1. recursion terminator（递归终结条件）
   2. process logic in current level（处理当前层的逻辑）
   3. drill down（下探到下一层）
   4. reverse the current level status if needed（如果有需要，可以清理当前层的状态）
   5. Java代码模版
      ```
      public void recursion(int level,int param){
          // recursion terminator
          if(level > MAX_LEVEL){
              // process result
              return;
          }
          // process logic in current level
          process(level,param);
          // drill down
          recursion(level++,newParam);
          // reverse the current level status if needed
      }
      ```
- 思维要点
   1. 不要进行人肉递归（最大误区）
   2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
   3. 数学归纳法
   4. BST --> 中序遍历是递增的
   
---
      
#### 分治、回溯
##### 分治  
> 本质就是递归

- 分治代码模版(Java)
   ```
      public T divideConquer(problem,param1,param2,...){
        // recursion terminator
        if(problem == null){
            return subResult;
        }
        // prepare data
        T data = prepareData(problem);
        List<Problem> subProblems = splitProblem(problem,data);
        // conquer subproblems
        T subResult1 = divideConquer(subProblems.get(0),p1,...);
        T subResult2 = divideConquer(subProblems.get(1),p1,...);
        T subResult3 = divideConquer(subProblems.get(2),p1,...);
        // process and generate the final result
        T result = processResult(subResult1,subResult2,subResult3,....);
        // revert the current level states
      }
   ```
##### 回溯
> 回溯采用试错的思想，通常用最简单的递归方法来实现
> 在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算       
   