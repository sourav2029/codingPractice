package com.sourav.sorting;

import lombok.Data;


@Data
public class Student implements Comparable<Student> {
    //    how to use getters and setters
    private final String firstName;
    private final String lastName;
    private final Double CGPA;

    @Override
    public int compareTo(Student o) {
        return firstName.compareTo(o.getFirstName()); // increasing order of name
//        return -1 * firstName.compareTo(o.firstName); //decreasing order of name
//        return  Double.compare(CGPA, o.CGPA); //increasing order of name
//        return  -1*Double.compare(CGPA, o.CGPA); //decreasing order of name

    }
}
