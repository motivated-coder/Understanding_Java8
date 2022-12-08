package com.skd.functionalinterface;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    int id;
    String name;
    String department;
    List<String> phoneNumbers;

    public static List<Employee> getEmployees(){
        return Arrays.asList(new Employee(1,"Sumeet","Development",Arrays.asList("1234","5678")),
                new Employee(1,"Archana","Devops",Arrays.asList("1589","1987")),
                        new Employee(1,"Rahul","Testing",Arrays.asList("9832","7748")));
    }
}
