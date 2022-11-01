package org.example.protobuf_course;

import org.example.protobuf_course.models.Television;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibilityTest {

    public static void main(String[] args) throws IOException {

        /*Television television = Television.newBuilder()
                .setBrand("sony")
                .setYear(2015)
                .build();

        Path path = Paths.get("tv-v1");
        Files.write(path, television.toByteArray());*/


        Path path = Paths.get("tv-v1");
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(Television.parseFrom(bytes));
    }
}
