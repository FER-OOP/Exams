package hr.fer.oop.triple;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class SimpleTripleTreeSet implements Iterable<Triple>{
    private Map<Triple, Object> internalMap;

    public Map<Triple, Object> getInternalMap() {
        return internalMap;
    }
}
