package hr.fer.oop.pair;

import java.util.*;

class SimplePairHashSet implements Iterable<Pair>{

    private Map<Pair, Object> internalMap;

    public SimplePairHashSet() {
        internalMap = new HashMap<>();
    }

    public Map<Pair, Object> getInternalMap() {
        return internalMap;
    }

    public boolean add(Pair pair){
        boolean existedBefore = internalMap.containsKey(pair);
        internalMap.put(pair, null);
        return !existedBefore;
    }

    public int size(){
        return internalMap.size();
    }

    public boolean contains(Object pair){
        return internalMap.containsKey(pair);
    }

    public boolean remove(Object pair){
        return internalMap.remove(pair, null);
    }

    @Override
    public Iterator<Pair> iterator() {
        return internalMap.keySet().iterator();
    }
}
