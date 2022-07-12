package com.sourav.sorting;

import java.util.*;

public class Sort {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            final Student student = new Student("sourav" + i, "prem" + (5 - i), 3.75 + i);
            students.add(student);
        }
        Collections.sort(students);
        for (int i = 0; i < 5; i++) {
            final Student s = students.get(i);
            System.out.println("First Name: " + s.getFirstName() + " Last Name: " + s.getLastName() + " CGPA : " + s.getCGPA());
        }
    }
}
