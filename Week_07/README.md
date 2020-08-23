## 学习总结
### 相关知识

#### 字典树
> Trie树

   - 字典树的数据结构
      > 树形结构，典型应用是用于统计和排序大量的字符串(但不限于字符串)
      ，所以经常被搜索引擎用于文本词频统计
      - 优点：最大限度地减少无所谓的字符串比较，查询效率比哈希表高
   - 字典树的核心思想
      - 空间换时间（利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的）
   - 字典树的基本性质
      - 结点本身不存完整单词
      - 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串
      - 每个结点的所有子结点路径代表的字符都不相同
      
#### 实现Trie（前缀树）
   - java版实现
      - 创建TrieNode结点
          ```
             class TrieNode{
                 // R links to node children
                 private TrieNode[] links;
                 private final int R = 26;
                 private boolean isEnd;
                 
                 public TrieNode(){
                     links = new TrieNode[R];
                 }
                 
                 public boolean containsKey(char ch){
                     return links[ch - 'a'] != null;
                 }
                 
                 public TrieNode get(char ch){
                     return links[ch - 'a'];
                 }
                 
                 public void put(char ch, TrieNode node){
                     links[ch - 'a'] = node;
                 }
                 
                 public void setEnd(){
                     isEnd = true;
                 }
                 
                 public boolean isEnd(){
                     return isEnd;
                 }
             }
          ```
      - 向Trie树中插入键
          ```
              class Trie{
                  private TrieNode root;
                  
                  public Trie(){
                      root = new TrieNode();
                  }
                  
                  // Insert a word into the trie.
                  public void insert(String word){
                      TrieNode node = root;
                      for(int i=0;i<word.length();++i){
                          char currentChar = word.charAt(i);
                          if(!node.containsKey(currentChar)){
                              node.put(currentChar,new TrieNode());
                          }
                          node = node.get(currentChar);
                      }
                      node.setEnd();
                  }
              }
          ``` 
      - 向trie树中查找单词
          ```
              class Trie{
                  // Insert a word into the trie.
                  ...
                  
                  // search a prefix or whole key in trie and
                  // return the node where search ends
                  private TrieNode searchPrefix(String word){
                      TrieNode node = root;
                      for(int i=0;i<word.length();++i){
                          char curLetter = word.charAt(i);
                          if(node.containsKey(curLetter)){
                              node = node.get(curLetter);
                          }else{
                              return null;
                          }
                      }
                      return node;
                  }
                  
                  // returns if the word is in the trie.
                  public boolean search(String word){
                      TrieNode node = searchPrefix(word);
                      return node != null && node.isEnd();
                  }
              }
          ```     
   - python实现
       ```
           class Trie(object):
           
               def __init__(self):
                 self.root = {}
                 self.end_of_word = "#"
                 
               def insert(self,word):
                 node = self.root
                 for char in word:
                   node = node.setdefault(char,{})
                 node[self.end_of_word] = self.end_of_word
                 
               def search(self,word):
                 node = self.root
                 for char in word:
                   if char not in node:
                     return False
                   node = node[char]
                 return self.end_of_word in node
                 
               def startsWith(self,prefix):
                 node = self.root
                 for char in word:
                   if char not in node:
                     return False
                   node = node[char]
                 return True                
       ```       
#### 并查集（Disjoint Set）     
- 使用场景
   - 组团、配对问题
   - Group or not ?
- 基本操作
   - makeSet(s): 建立一个新的并查集，其中包含s个单元素集合。
   - unionSet(x,y): 把元素x和元素y所在的集合合并，要求x和y所在的集合不相交，如果相交则不合并。
   - find(x): 找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。
- 代码实现
   - java实现
      ```
          class UnionFind{
              private int count = 0;
              private int[] parent;
              
              public UnionFind(int n){
                  count = n;
                  parent = new int[n];
                  for(int i=0;i<n;++i){
                      parent[i] = i;
                  }
              }
              
              public int find(int p){
                  while(p != parent[p]){
                      parent[p] = parent[parent[p]];
                      p = parent[p];
                  }
                  return p;
              }
              
              public void union(int p,int q){
                  int rootP = find(p);
                  int rootQ = find(q);
                  if(rootP == rootQ){
                      return;
                  }
                  parent[rootP] = rootQ;
                  count--;
              }
          }
      ```   
   - python实现
      ```
          def init(p):
            # for i=0....n:p[i]=i;
            p = [i for i in range(n)]
            
          def union(self,p,i,j):
            p1 = self.parent(p,i)
            p2 = self.parent(p,j)
            p[p1] = p2
            
          def parent(self,p,i):
            root = i;
            while p[root] != root:
              root = p[root]
            while p[i] != i: #路径压缩？
              x = i;i = p[i];p[x] = root
            return root        
      ```   
#### 高级搜索
> - 剪枝
> - 双向BFS
> - 启发式搜索(A*)

   - 初级搜索
      1. 朴素搜索
      2. 优化方式：不重复（fibonacci）、剪枝（生成括号问题）
      3. 搜索方向：
         - DFS
         - BFS
         - 双向搜索
         - 启发式搜索
   - 剪枝
      > 去掉重复解或者次优解、无用解   
      - 八皇后问题 
      - 数独问题
         - 优秀代码（Python）
            ```
               class Solution:
                   def solveSudoku(self,board: List[List[str]]) -> None:
                       # 行剩余可用数字
                       row = [set(range(1,10)) for _ in range(9)]
                       # 列剩余可用数字
                       col = [set(range(1,10)) for _ in range(9)]
                       # 块剩余可用数字
                       block = [set(range(1,10)) for _ in range(9)]
                       
                       # 收集需填数位置
                       empty = []
                       for i in range(9):
                           for j in range(9):
                               # 更新可用数字
                               if board[i][j] != '.':
                                   val = int(board[i][j])
                                   row[i].remove(val)
                                   col[j].remove(val)
                                   block[(i // 3)*3 + j // 3].remove(val)
                               else:
                                   empty.append((i,j))
                                   
                       def backtrack(iter=0):
                           # 处理完empty代表找到了答案
                           if iter == len(empty):     
                               return True
                           i,j = empty[iter]
                           b = (i // 3)*3 + j // 3
                           for val in row[i] & col[j] & block[b]:
                               row[i].remove(val)
                               col[j].remove(val) 
                               block[b].remove(val)
                               board[i][j] = str(val)
                               if backtrack(iter+1):
                                   return True
                               # 回溯
                               row[i].add(val)
                               col[j].add(val)
                               block[b].add(val)
                           return False
                           
                       backtrack()                        
            ```  
   - 双向BFS         

