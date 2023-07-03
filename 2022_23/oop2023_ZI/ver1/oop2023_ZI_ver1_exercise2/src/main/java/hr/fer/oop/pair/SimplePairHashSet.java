package hr.fer.oop.pair;

import java.util.*;

class SimplePairHashSet implements Iterable<Pair>{
    private Map<Pair, Object> internalMap;

    public Map<Pair, Object> getInternalMap() {
        return internalMap;
    }

}
