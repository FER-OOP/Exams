package hr.fer.oop.pair;

import java.util.Objects;

class Pair<A, B> {

    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof Pair<?, ?>) {
            Pair<?, ?> otherPair = (Pair) other;
            if ((Objects.equals(this.first, otherPair.second) && Objects.equals(this.second,otherPair.first))) {
                return true;
            }
            if ((Objects.equals(this.first, otherPair.first) && Objects.equals(this.second,otherPair.second))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return first.hashCode() + second.hashCode();
    }
}
