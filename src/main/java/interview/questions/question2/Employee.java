/*
 * Copyright (c) 2006-2019 Henri Tremblay.
 */
package interview.questions.question2;

public class Employee extends Person {
    private final String role;

    public Employee(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }
}
