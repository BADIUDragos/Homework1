/*
 * Copyright (c) 2006-2019 Henri Tremblay.
 */
package interview.questions.question2;

public class Person {
    private final int age;
    private final String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + " has " + age + " years old";
    }
}
