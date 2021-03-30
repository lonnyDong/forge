package cn.com.grpcserver;


import cn.com.dong.grpc.lib.UserInfo;
import cn.com.dong.grpc.lib.UserInfoRequest;
import cn.com.dong.grpc.lib.UserInfoServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcServerService extends UserInfoServiceGrpc.UserInfoServiceImplBase {

    @Override
    public void getUserInfo(UserInfoRequest req, StreamObserver<UserInfo> responseObserver) {
        UserInfo reply = UserInfo.newBuilder().setAddress("深圳").setId("2222").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }
}