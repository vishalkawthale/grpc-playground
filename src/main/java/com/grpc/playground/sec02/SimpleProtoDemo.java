package com.grpc.playground.sec02;

import com.grpc.playground.models.sec02.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProtoDemo {

    private static final Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);

    public static void main(String[] args) {
        // create person1
        var person1 = getPerson();

        // create another instance with same values
        var person2 = getPerson();

        // compare
        log.info("equals {}", person1.equals(person2));
        log.info("== {}", (person1 == person2));

        // mutable? No

        // create another instance with diff values
        var person3 = person1.toBuilder().setName("mike").build();
        log.info("person3: {}", person3);

        // compare
        log.info("equals {}", person1.equals(person3));
        log.info("== {}", (person1 == person3));

        //null?
        var person4 = person1.toBuilder().clearName().build();
        log.info("person4: {}", person4);
    }

    private static Person getPerson() {
        return Person.newBuilder()
                .setName("Vishal")
                .setAge(30)
                .build();
    }
}
