import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Deseription LRU缓存机制
 * leetcode--146
 **/
public class LRUCache {

    private Map<Integer,Integer> lruLinkedMap;
    private int length;

    public LRUCache(int capacity) {
        lruLinkedMap = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true);
        length = capacity;
    }

    public int get(int key) {
        if(lruLinkedMap.containsKey(key)){
            int value = lruLinkedMap.get(key);
            lruLinkedMap.remove(key);
            lruLinkedMap.put(key,value);
        }
        return lruLinkedMap.get(key)==null?-1:lruLinkedMap.get(key);
    }

    public void put(int key, int value) {
        if(lruLinkedMap.containsKey(key)){
            lruLinkedMap.put(key,value);
        }else{
            if(lruLinkedMap.size() >= length){
                for(Integer removeKey:lruLinkedMap.keySet()){
                    lruLinkedMap.remove(removeKey);
                    break;
                }
            }
            lruLinkedMap.put(key,value);
        }
    }
}
