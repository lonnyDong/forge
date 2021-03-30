package cn.com.dong;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.com.dong.grpc.lib.UserInfo;
import cn.com.dong.grpc.lib.UserInfoRequest;
import cn.com.dong.grpc.lib.UserInfoServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

/**
 * @ClassName HelloWorldServer
 * @Description
 * @Author hugo_lei
 * @Date 13/5/20 上午11:09
 */
public class HelloWorldServer {


    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 9900;
        server = ServerBuilder.forPort(port)
                .addService(new GreeterImpl())
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    HelloWorldServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final HelloWorldServer server = new HelloWorldServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class GreeterImpl extends UserInfoServiceGrpc.UserInfoServiceImplBase {

        @Override
        public void getUserInfo(UserInfoRequest req, StreamObserver<UserInfo> responseObserver) {
            UserInfo userInfo = UserInfo.newBuilder().setAddress("ddd").setId("10001").build();
            responseObserver.onNext(userInfo);
            responseObserver.onCompleted();
        }
    }
}
