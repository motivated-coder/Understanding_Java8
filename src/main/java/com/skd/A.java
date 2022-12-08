package com.skd;

import com.skd.collections.AadharID;
import com.skd.collections.Student;
import com.skd.comparator.MyComaparator;
import com.skd.functionalinterface.B;
import com.skd.comparator.Book;
import com.skd.functionalinterface.Employee;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class A{

    public static void main(String[] args) {
        System.out.println("-----example of Functional Interface-----");

        B b1 = () -> System.out.println("Invoking abstract method of B, since B has only 1 abstract method it is functional " +
                "interface");
        b1.show();

        System.out.println("-----example of comparator-----");

        List<Book> books= Book.getBooks();
        System.out.println(books);

        System.out.println("-----example of ForEach...It takes consumer as argument-----");

        books.forEach(book -> System.out.println(book.getName()));

        System.out.println("-----example of Predicate-----");

        Predicate<Integer> predicate = p -> p%2==0;

        books.forEach(book -> System.out.println(predicate.test(book.getPrice())));

        books.stream().filter(b -> b.getPrice()%2==0).forEach(p -> System.out.println(p.getPrice()));

        System.out.println("-----example of Supplier-----");

        Supplier<Integer> supplier = () -> 5;
        Integer i = (Integer) Arrays.asList().stream().findAny().orElseGet(supplier);

        System.out.println(i);

        System.out.println("-----example of Collections sort-----");

        List<String> names = Student.getStudents()
                .stream().map(s-> s.getName())
                .collect(Collectors.toList());

        // Using predefined method of Collections
        Collections.sort(names);
        System.out.println(names);

        Collections.reverse(names);
        System.out.println(names);

        // Using sorted method
        names.stream().sorted().forEach(s -> System.out.println(s));
        names.stream().sorted((s1,s2) -> s1.compareTo(s2)).forEach(s -> System.out.println(s));
        names.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));

        List<Student> students =Student.getStudents();

        Collections.sort(students, (s1,s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println(students);

        Collections.sort(students, (s1,s2) -> (s1.getId() - s2.getId()));
        System.out.println(students);

        students.stream().sorted((s1,s2) -> (s1.getId() - s2.getId())).forEach(s -> System.out.println(s));
        students.stream().sorted((s1,s2) -> s1.getName().compareTo(s2.getName())).forEach(s -> System.out.println(s));
        students.stream().sorted(Comparator.comparing(student -> student.getId())).forEach(s -> System.out.println(s));
        students.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);

        System.out.println("-----example of Map sort-----");

        //Example of Map of key type primitive
        List<Map.Entry<Integer,String>> entries = AadharID.getAadharDetailsAsListEntry();
        Collections.sort(entries,(e1,e2) -> e1.getValue().compareTo(e2.getValue()));
        System.out.println("Entries after sort "+entries);
        Collections.sort(entries,(e1,e2) -> e1.getKey() -e2.getKey());
        System.out.println("Entries after sort "+entries);

        AadharID.getAadharDetails().entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        AadharID.getAadharDetails().entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        //Example of Map of key type Object
        Map<Book,Integer> bookMap = new TreeMap<>(new MyComaparator());
        Book.getBooks().stream().forEach(book -> bookMap.put(book,book.getPrice()));
        System.out.println("printing bookMap sorted by Name"+bookMap);

        Map<Book,Integer> bookMap2 = new TreeMap<>((o1,o2) -> o2.getPrice() - o1.getPrice());
        Book.getBooks().stream().forEach(book -> bookMap2.put(book,book.getPrice()));
        System.out.println("printing bookMap sorted by Price"+bookMap2);

        System.out.println("-----example of map and flatMap-----");
        List<String> employeeNames = Employee.getEmployees().stream().map(emp -> emp.getName()).sorted((n1,n2) -> n1.compareTo(n2)).collect(Collectors.toList());
        System.out.println("example of map "+employeeNames);

        List e = Employee.getEmployees().stream().flatMap(emp -> emp.getPhoneNumbers().stream()).collect(Collectors.toList());
        System.out.println("example of flatMap "+e);

        System.out.println("-----example of Optional-----");

        Employee employee = new Employee(1,"Ram","Creator",null);
        Optional o = Optional.empty();
        System.out.println("Optional.empty() returns "+o);

        Optional optionalPhoneNumber = Optional.ofNullable(employee.getPhoneNumbers());
        System.out.println("Optional.ofNullable "+optionalPhoneNumber);

    //    Optional phoneNumber = Optional.of(employee.getPhoneNumbers());
    //    System.out.println("Optional.of "+phoneNumber);

        System.out.println(optionalPhoneNumber.orElse(Arrays.asList("3456")));
        System.out.println(optionalPhoneNumber.orElseGet(() -> Arrays.asList("4567")));

        System.out.println("-----example of Reduce-----");

        List<Integer> integers = Arrays.asList(1,4,77,33,75,58,43);

        System.out.println("-------sum of list of integers----");

        Integer sum = integers.stream().reduce(0,(i1,i2)-> (i1+i2));

        System.out.println("Sum is "+sum);

        Integer max = integers.stream().reduce(0,(i1,i2)-> i1>i2?i1:i2);

        System.out.println("Max. no is "+max);

        Integer maxByMethodRef = integers.stream().reduce(Integer::max).get();

        System.out.println("Max. no is "+maxByMethodRef);

    }
}





















