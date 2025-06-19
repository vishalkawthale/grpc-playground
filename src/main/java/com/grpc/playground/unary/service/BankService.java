package com.grpc.playground.unary.service;

import com.grpc.playground.proto.models.unary.AccountBalance;
import com.grpc.playground.proto.models.unary.AccountBalanceRequest;
import com.grpc.playground.proto.models.unary.BankServiceGrpc;
import com.grpc.playground.unary.repository.BankRepository;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void getAccountBalance(AccountBalanceRequest request, StreamObserver<AccountBalance> responseObserver) {
        var accountNumber = request.getAccountNumber();

        var accountBalance = AccountBalance.newBuilder()
                .setAccountNumber(accountNumber)
                .setAmount(BankRepository.getBalance(accountNumber))
                .build();

        responseObserver.onNext(accountBalance);
        responseObserver.onCompleted();

    }
}
