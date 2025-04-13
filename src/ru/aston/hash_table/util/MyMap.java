package ru.aston.hash_table.util;

public interface MyMap<K, V> {
    V get(Object key);
    V put(K key, V value);
    V remove(Object key);
}
