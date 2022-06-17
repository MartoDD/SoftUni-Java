package IteratorsAndComparators.Exercise._4_Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    List<Integer> lake;

    public Lake(List<Integer> lake) {
        this.lake = lake;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index=0;
            boolean skippedOnce=false;
            @Override
            public boolean hasNext() {
                return index<lake.size();
            }

            @Override
            public Integer next() {
                int currentIndex=index;
                index+=2;
                if (index>=lake.size() &&!skippedOnce){
                    skippedOnce=true;
                    index=1;
                }
                return lake.get(currentIndex);
            }
        };
    }
}
