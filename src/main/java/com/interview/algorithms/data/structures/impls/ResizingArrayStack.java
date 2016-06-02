package com.interview.algorithms.data.structures.impls;

/**
 * @author: Vincent
 * @since:9:41 PM, 9/5/16
 */
public class ResizingArrayStack<T> extends FixedCapacityStack<T> {
    private static final int DEFAULT_SIZE = 16;

    public ResizingArrayStack() {
        super(DEFAULT_SIZE);
    }

    protected void resize(){
        T[] copy = (T[]) new Object[size() * 2];

        for(int i = 0; i <= size(); i++){
            copy[i] = values[i];
        }

        values = copy;
    }

    @Override
    public void push(T item) {
        if(counter >= values.length){
            resize();
        }

        super.push(item);
    }
}
