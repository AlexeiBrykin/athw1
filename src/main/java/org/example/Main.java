package org.example;

import hw1.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Vasyan");
        student.addGrade(3);
        student.addGrade(4);
        System.out.println(student.toString());
    }
}