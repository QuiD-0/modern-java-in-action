package functional;

import java.util.Iterator;

public class CustomIterator {
    public static void main(String[] args) {
        RandomIterator randomIterator = new RandomIterator();
        for (int i = 0; i < 10; i++) {
            System.out.println(randomIterator.next());
        }
    }

    static class RandomIterator implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return (int) (Math.random() * 100);
        }
    }
}
