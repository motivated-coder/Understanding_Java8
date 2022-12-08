package com.skd.comparator;

import java.util.Comparator;

public class MyComaparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
