package com.coding.service;

import com.coding.grpc.message.MessageServiceGrpc;
import com.coding.grpc.message.SendSmsReply;
import com.coding.grpc.message.SendSmsRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;


@GrpcService
public class MessageService extends MessageServiceGrpc.MessageServiceImplBase {

    private final LocalDateTime now = LocalDateTime.now();

    @Value("${spring.application.name}")
    private String name;

    @Override
    public void sendSmsCode(SendSmsRequest request, StreamObserver<SendSmsReply> responseObserver) {
        responseObserver.onNext(SendSmsReply.newBuilder()
                .setMessage(String.format("%s_%s", name, now.toString()))
                .build());
        responseObserver.onCompleted();
    }
}
