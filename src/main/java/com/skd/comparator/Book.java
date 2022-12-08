package com.skd.comparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    int price;
    String name;

    public static List<Book> getBooks(){
        List<Book> books = Arrays.asList(new Book(200,"The Legend")
                ,new Book(300,"Jack The Ripper")
                ,new Book(250,"Ignited Minds"));

//      Collections.sort(books,new MyComaparator());
        Collections.sort(books,(obj1, obj2)->obj1.getName().compareTo(obj2.getName()));
        return books;
    }
}
