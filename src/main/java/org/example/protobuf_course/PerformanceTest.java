package org.example.protobuf_course;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import org.example.protobuf_course.json.JPerson;
import org.example.protobuf_course.models.Person;

import java.io.IOException;

public class PerformanceTest {

    public static void main(String[] args) {
        // json
        JPerson person = new JPerson();
        person.setName("sam");
        person.setAge(10);
        ObjectMapper mapper = new ObjectMapper();
        Runnable jsonRunnable = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(person);
                JPerson person1 = mapper.readValue(bytes, JPerson.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        // protobuf
        Person sam = Person.newBuilder().setName("sam").setAge(10).build();
        Runnable protoRunnable = () -> {
            try {
                byte[] bytes = sam.toByteArray();
                Person sam1 = Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        };

        runPerformanceTest(jsonRunnable, "JSON");
        runPerformanceTest(protoRunnable, "PROTO");

    }

    private static void runPerformanceTest(Runnable runnable, String method) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            runnable.run();
        }
        long time2 = System.currentTimeMillis();

        System.out.println(method + " : " + (time2 - time1) + " ms");
    }
}
