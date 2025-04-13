package ru.aston.hash_table.run;

import ru.aston.hash_table.util.MyHashMap;
import ru.aston.hash_table.util.MyMap;


public class Runner {
    public static void main(String[] args) {
        MyMap<String, Integer> myMap = new MyHashMap<>();
        myMap.put("Value", 1);
        myMap.put("String", 2);
        myMap.put("Strin", 3);
        myMap.put("Stri", 4);
        myMap.put("Str", 5);
        myMap.put("St", 6);
        myMap.put("Valu", 8);
        myMap.put("Val", 9);
        myMap.put("Va", 10);
        myMap.put("V", 11);
        myMap.put("Abcdefg", 12);
        myMap.put("Abcdef", 13);
        myMap.put("Abcde", 14);
        myMap.put("Abcd", 15);
        myMap.put("Abc", 16);
        myMap.put("Ab", 17);
        myMap.remove("Va");
        myMap.remove("V");
    }
}
