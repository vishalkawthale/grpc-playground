package com.grpc.playground.client;

import com.grpc.playground.proto.models.unary.AccountBalanceRequest;
import com.grpc.playground.proto.models.unary.BankServiceGrpc;
import com.grpc.playground.server.GrpcServer;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrpcClient {

    private static final Logger log = LoggerFactory.getLogger(GrpcClient.class);

    public static void main(String[] args) {

        var channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();

        var stub = BankServiceGrpc.newBlockingStub(channel);

        var balance = stub.getAccountBalance(AccountBalanceRequest.newBuilder().setAccountNumber(1).build());

        log.info("balance: {}", balance);

    }
}
