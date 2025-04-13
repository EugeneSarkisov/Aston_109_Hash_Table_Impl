package ru.aston.hash_table.util;

import java.util.Objects;

public class MyNode<K, V> {
    private final int hash;
    private  K key;
    private  V value;
    private MyNode<K, V> next;

    public MyNode(int hash, K key, V value, MyNode<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int getHash() {
        return hash;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public MyNode<K, V> getNext() {
        return next;
    }

    public void setNext(MyNode<K, V> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyNode<?, ?> node = (MyNode<?, ?>) o;
        return hash == node.hash && Objects.equals(key, node.key) && Objects.equals(value, node.value) && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }



}
