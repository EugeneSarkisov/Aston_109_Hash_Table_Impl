package ru.aston.hash_table.util;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private static final int DEFAULT_INIT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.7f;
    private static int hashMapLoad = 0;
    private static int capacity = 0;
    private MyNode<K, V>[] data;

    public MyHashMap() {
        this.data = new MyNode[DEFAULT_INIT_CAPACITY];
        capacity = DEFAULT_INIT_CAPACITY;
    }

    @Override
    public V get(Object key) {
        int index = getIndex(hash(key));
        if (!data[index].getKey().equals(key)) {
            MyNode<K, V> current = data[index];
            while (current != null) {
                if (current.getKey().equals(key)) {
                    return current.getValue();
                } else {
                    current = current.getNext();
                }
            }
        } else {
            return data[index].getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (((float) hashMapLoad / (float) capacity) >= DEFAULT_LOAD_FACTOR) {
            resize();
        }
        int index = getIndex(hash(key));
        if (data[index] != null) {
            if (data[index].getKey().equals(key)) {
                data[index].setValue(value);
            } else {
                MyNode<K, V> head = data[index];
                MyNode<K, V> current = head;
                while (current != null) {
                    if (head.getKey().equals(key)) {
                        head.setValue(value);
                        return value;
                    } else {
                        current = current.getNext();
                    }
                }
                MyNode<K, V> myNode = new MyNode<>(hash(key), key, value, head);
                hashMapLoad++;
                data[index] = myNode;
            }
        } else {
            MyNode<K, V> myNode = new MyNode<>(hash(key), key, value, null);
            hashMapLoad++;
            data[index] = myNode;
        }
        return value;
    }

    @Override
    public V remove(Object key) {
        int index = getIndex(hash(key));
        MyNode<K, V> head = data[index];
        MyNode<K, V> current = head;
        MyNode<K, V> previous = null;
        while (current != null) {
            if (current.getKey().equals(key)) {
                if (previous == null) {
                    data[index] = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                hashMapLoad--;
                return current.getValue();
            }
            previous = current;
            current = current.getNext();
        }
        return null;
    }

    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private static int getIndex(int hash) {
        return hash & (capacity - 1);
    }

    private void resize() {
        MyNode<K, V>[] newData = new MyNode[data.length + DEFAULT_INIT_CAPACITY];
        MyNode<K, V>[] tempNodeArray = data;
        data = newData;
        capacity += DEFAULT_INIT_CAPACITY;
        hashMapLoad = 0;
        for (MyNode<K, V> datum : tempNodeArray) {
            if (datum != null) {
                MyNode<K, V> current = datum;
                while (current != null) {
                    put(current.getKey(), current.getValue());
                    current = current.getNext();
                }
            }
        }
    }

}

