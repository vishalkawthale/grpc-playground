package com.grpc.playground.server;

import com.grpc.playground.unary.service.BankService;

public class TestServer {
    public static void main(String[] args) {
        GrpcServer.create(new BankService())
                .start()
                .await();
    }
}
