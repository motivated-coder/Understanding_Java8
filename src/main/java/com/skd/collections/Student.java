package com.skd.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int id;
    String name;

    public static List<Student> getStudents(){
        return Arrays.asList(new Student(1,"Sumeet"),
                new Student(2,"Shiva"),
                new Student(3,"Krishna"));
    }
}
