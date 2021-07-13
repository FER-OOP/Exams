/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.summer_2020_21.task2;

/**
 *
 * @author Marko Pavelić
 */
import java.util.Comparator;
import java.util.Set;

public class Smoker implements Comparable<Smoker> {

    private String name;
    private String producer;
    private Type type;
    private Set<Long> shelfSpace;
    private int minTemp;
    private int maxTemp;

    enum Type {
        BULLET, KAMADO, OFFSET
    }

    public static final Comparator<Smoker> BY_TOTAL_SHELF_SPACE = new ByTotalShelfSpaceComparator();

    public static final Comparator<Smoker> BY_MIN = (s1, s2) -> Integer.compare(s1.getMinTemp(), s2.getMinTemp());

    public static final Comparator<Smoker> BY_MIN_THAN_MAX
            = BY_MIN.thenComparing((s1, s2) -> Integer.compare(s1.getMaxTemp(), s2.getMaxTemp()));

    private static class ByTotalShelfSpaceComparator implements Comparator<Smoker> {

        @Override
        public int compare(Smoker s1, Smoker s2) {
            long totalS1 = 0;
            long totalS2 = 0;

            for (Long i : s1.getShelfSpace()) {
                totalS1 += i;
            }

            for (Long i : s2.getShelfSpace()) {
                totalS2 += i;
            }

            return Long.compare(totalS1, totalS2);
        }

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((shelfSpace == null) ? 0 : shelfSpace.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Smoker other = (Smoker) obj;
        if (shelfSpace == null) {
            if (other.shelfSpace != null) {
                return false;
            }
        } else if (!shelfSpace.equals(other.shelfSpace)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Smoker s) {
        int r = this.producer.compareTo(s.getProducer());
        if (r != 0) {
            return r;
        }
        r = this.name.compareTo(s.getName());
        if (r != 0) {
            return r;
        }
        r = Integer.valueOf(minTemp).compareTo(Integer.valueOf(s.getMinTemp()));
        if (r != 0) {
            return r;
        }
        r = Integer.valueOf(maxTemp).compareTo(Integer.valueOf(s.getMaxTemp()));
        return r;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Long> getShelfSpace() {
        return shelfSpace;
    }

    public void setShelfSpace(Set<Long> shelfSpace) {
        this.shelfSpace = shelfSpace;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

}