## 学习总结
### 相关知识

#### 深度优先搜索、广度优先搜索
> 先简化搜索的结构（二叉树、图）

- 二叉树的数据结构定义
   ```
   public class TreeNode{
       int val;
       TreeNode left;
       TreeNode right;
       public TreeNode(int val){
           this.val = val;
           this.left = null;
           this.right = null;
       }
   }
   ```
 - 搜索--遍历
    - 每个节点都要访问一次
    - 每个节点仅仅要访问一次
    - 对于节点的访问顺序不限
       - 深度优先(DFS)：depth first search
       - 广度优先(BFS)：breadth first search
       - 优先级优先(启发式搜索)
       
 - 深度优先搜索
    - 二叉树示例代码
       ```
        public void dfs(TreeNode node){
           if(visited.contains(node)){
              // already visited
              return;
           }
           visited.add(node);
           // process current node
           // logic here
           dfs(node.left);
           dfs(node.right);
        }
       ```
    - 多叉树--示例代码
       - 递归写法
          ```
           Set<TreeNode> visited = new HashSet<TreeNode>();
           
           public void dfs(TreeNode node,Set<TreeNode> visited){
              // terminator
              if(visited.contains(node)){
                 // already visited
                 return;
              }
              visited.add(node);
              // process current node here
              ...
              for(TreeNode nextNode : node.children()){
                 if(!visited.contains(nextNode)){
                    dfs(nextNode,visited);
                 }
              }
           }
          ```        
       - 非递归写法
          ```
          
          public void dfs(TreeNode root){
             if(root == null){
                return;
             }
             Set<TreeNode> visited = new HashSet<TreeNode>();
             Stack<TreeNode> stack = new Stack<TreeNode>();
             while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                visited.add(node);
                
                process(node);
                List<TreeNode> nodes = generateRelatedNodes(node);
                for(List<TreeNode> child : nodes){
                   stack.push(child);
                }
             }
             // other processing work
             ...
          }
          ```   
    - 遍历顺序--按照深度遍历，再回溯
    
 - 广度优先搜索
    - 图示例代码
       ```
       public void bfs(TreeNode root,){
          Queue<TreeNode> nodes = new LinkedList<TreeNode>();
          List<Integer> visited = new ArrayList<Integer>();
          while(!queue.isEmpty()){
             int size = queue.size();
             for(int i=0;i<size;++i){
                TreeNode node = queue.poll();
                visited.add(node.val);
                if(node.left!=null){
                   queue.add(node.left);
                }
                if(node.right!=null){
                   queue.add(node.right);
                }
             }
          }
       }
       ```
    
    - 遍历顺序--按照层次进行遍历，一层一层扩散遍历       

---

#### 贪心算法
> 贪心算法是一种在每一步选择中都才去在当前状态下最好或最优的选择
> 从而希望导致结果是全局最好或最优的算法。而与动态规划不同在于，贪心算法不能回退，动态规划会保存以前的结果，并根据以前的结果对当前进行选择，有回退功能。

> 贪心：当下做局部最优判断
> 回溯：能够回退
> 动态规划：最优判断 + 回退

- 使用贪心算法的场景
   - 最短生成路径
   - 哈夫曼编码
---

#### 二分查找
- 二分查找的前提
   1. 目标函数单调性（单调递增或者递减）
   2. 存在上下界（bounded）
   3. 能够通过索引访问（index accessible）
   
- 代码模版
   ```
      public int binarySearch(int[] arr,int target){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
           int mid = low + (high - low)/2;
           if(arr[mid] > target){
              high = mid - 1;
           }else if(arr[mid] < target){
              low = mid + 1;
           }else{
              return mid;
           }
        }
        return -1;
      }
   ```   

#### 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方   