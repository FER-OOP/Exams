package hr.fer.oop.triple;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class SimpleTripleTreeSet implements Iterable<Triple>{

    private Map<Triple, Object> internalMap;

    public SimpleTripleTreeSet(){
        internalMap = new TreeMap<>();
    }

    public Map<Triple, Object> getInternalMap() {
        return internalMap;
    }

    public boolean add(Triple triple){
        boolean existedBefore = internalMap.containsKey(triple);
        internalMap.put(triple, null);
        return !existedBefore;
    }

    public int size(){
        return internalMap.size();
    }

    public boolean contains(Object triple){
        return internalMap.containsKey(triple);
    }

    public boolean remove(Object triple){
        return internalMap.remove(triple, null);
    }

    @Override
    public Iterator<Triple> iterator() {
        return internalMap.keySet().iterator();
    }

}
