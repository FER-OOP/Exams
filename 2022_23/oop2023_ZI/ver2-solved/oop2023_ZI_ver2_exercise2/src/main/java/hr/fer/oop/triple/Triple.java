package hr.fer.oop.triple;

import java.util.*;

class Triple implements Comparable<Triple> {

    private String first;
    private String second;

    private String third;

    public Triple(String first, String second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public String getThird() {
        return third;
    }
    @Override
    public int compareTo(Triple o) {
        if (this.equals(o)) {
            return 0;
        }
        List<String> thisArray = Arrays.asList(this.first, this.second, this.third);
        List<String> otherArray = Arrays.asList(o.first, o.second, o.third);
               
        Collections.sort(thisArray);
        Collections.sort(otherArray);
        
        for (int i = 0; i < thisArray.size(); i++) {
            int r = thisArray.get(i).compareTo(otherArray.get(i));
            
            if (r != 0)
                return r;
        }
        
        return 0;
    }
}
