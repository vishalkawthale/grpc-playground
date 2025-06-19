package com.grpc.playground.unary.repository;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BankRepository {

    private static final Map<Integer, Integer> repository = IntStream.range(1, 10)
            .boxed()
            .collect(Collectors.toMap(
                    Function.identity(),
                    o -> o*1000
            ));

    public static Integer getBalance(Integer accountNumber) {
        return repository.get(accountNumber);
    }
}
