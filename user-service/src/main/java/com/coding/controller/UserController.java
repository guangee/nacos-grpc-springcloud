package com.coding.controller;

import com.coding.grpc.message.MessageServiceGrpc;
import com.coding.grpc.message.SendSmsReply;
import com.coding.grpc.message.SendSmsRequest;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author yunji
 */
@RequestMapping("user")
@RestController
public class UserController {

    @Value("${spring.application.name}")
    private String name;

    private final static LocalDateTime now = LocalDateTime.now();

    @GrpcClient("echo-service")
    private MessageServiceGrpc.MessageServiceBlockingStub blockingStub;

    @GetMapping("echo")
    public String echo(String phone, String code) {
        SendSmsReply sendSmsReply = blockingStub.sendSmsCode(SendSmsRequest.newBuilder().setPhone(phone).setCode(code).build());
        return String.format("im %s,%s", name, sendSmsReply.getMessage());
    }
}
