package com.grpc.playground.sec01;

import com.grpc.playground.models.sec01.PersonOuterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {

    private static final Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String[] args) {
        var person = PersonOuterClass.Person.newBuilder()
                .setName("Vishal")
                .setAge(30)
                .build();

        log.info("{}", person);
    }
}
