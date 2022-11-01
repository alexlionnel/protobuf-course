package org.example.protobuf_course;

import org.example.protobuf_course.models.Address;
import org.example.protobuf_course.models.Car;
import org.example.protobuf_course.models.Person;

import java.util.List;

public class CompositionDemo {

    public static void main(String[] args) {
        Address address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("main street")
                .setCity("Rennes")
                .build();

        Car car1 = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2020)
                .build();

        Car car2 = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(2016)
                .build();

        Person person = Person.newBuilder()
                .setName("sam")
                .setAge(10)
                .setAddress(address)
                .addAllCar(List.of(car1, car2))
                .build();

        System.out.println(person);
    }
}
