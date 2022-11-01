package org.example.protobuf_course;

import org.example.protobuf_course.models.Person;

public class DefaultValueDemo {

    public static void main(String[] args) {
        Person person = Person.newBuilder().build();

        System.out.println(person.getAddress().getCity());
        System.out.println(person.hasAddress());
    }
}
