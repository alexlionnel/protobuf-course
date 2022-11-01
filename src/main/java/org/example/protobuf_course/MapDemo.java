package org.example.protobuf_course;

import org.example.protobuf_course.models.BodyStyle;
import org.example.protobuf_course.models.Car;
import org.example.protobuf_course.models.Dealer;

public class MapDemo {

    public static void main(String[] args) {
        Car car1 = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setBodyStyle(BodyStyle.COUPE)
                .setYear(2020)
                .build();

        Car car2 = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setBodyStyle(BodyStyle.SEDAN)
                .setYear(2016)
                .build();

        Dealer dealer = Dealer.newBuilder()
                .putModel(2005, car1)
                .putModel(2003, car2)
                .build();

        System.out.println(dealer.getModelOrThrow(2005).getBodyStyle());

    }
}
