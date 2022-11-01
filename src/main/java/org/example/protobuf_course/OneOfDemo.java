package org.example.protobuf_course;

import org.example.protobuf_course.models.Credentials;
import org.example.protobuf_course.models.EmailCredentials;
import org.example.protobuf_course.models.PhoneOTP;

public class OneOfDemo {

    public static void main(String[] args) {
        EmailCredentials emailCredentials = EmailCredentials.newBuilder()
                .setEmail("vvv@gmail.com")
                .setPassword("123")
                .build();

        PhoneOTP phoneOTP = PhoneOTP.newBuilder()
                .setNumber(123156789)
                .setCode(123)
                .build();

        Credentials credentials = Credentials.newBuilder()
                .setEmailMode(emailCredentials)
                .setPhoneMode(phoneOTP) // le phone mode va écraser l'email mode à cause du oneOf
                .build();

        login(credentials);
    }

    private static void login(Credentials credentials) {
        System.out.println(credentials.getPhoneMode());

        System.out.println(credentials.hasPhoneMode());
        System.out.println(credentials.hasEmailMode());

        System.out.println(credentials.getModeCase());
    }
}
