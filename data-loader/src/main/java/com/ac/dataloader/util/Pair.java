package com.ac.dataloader.util;

public class Pair<K, V> {

    private K k;
    private V v;

    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getKey(){
        return this.k;
    }

    public void setValue(K k) {
        this.k = k;
    }

    public V getValue() {
        return this.v;
    }

    public void setSecondValue(V v) {
        this.v = v;
    }

}
