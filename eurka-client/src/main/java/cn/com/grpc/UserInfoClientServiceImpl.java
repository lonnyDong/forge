package cn.com.grpc;

import cn.com.dong.grpc.lib.UserInfo;
import cn.com.dong.grpc.lib.UserInfoRequest;
import cn.com.dong.grpc.lib.UserInfoServiceGrpc;
import io.grpc.Channel;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoClientServiceImpl implements UserInfoClientService {

    @GrpcClient("order-center")
    private Channel serverChannel;

    @GetMapping("/v1")
    public void testApi(){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        sendMessage("123");
    }

    @Override
    public String sendMessage(String userId) {
        UserInfoServiceGrpc.UserInfoServiceBlockingStub stub = UserInfoServiceGrpc.newBlockingStub(serverChannel);
        UserInfo userInfo = stub.getUserInfo(UserInfoRequest.newBuilder().setId(userId).build());
        System.out.println(userInfo);
        return "success";
    }
}