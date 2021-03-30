package cn.com.dong;

import java.util.concurrent.TimeUnit;

import cn.com.dong.grpc.lib.UserInfo;
import cn.com.dong.grpc.lib.UserInfoRequest;
import cn.com.dong.grpc.lib.UserInfoServiceGrpc;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

/**
 * @ClassName HelloWorldClient
 * @Description
 * @Author hugo_lei
 * @Date 13/5/20 上午11:13
 */
public class HelloWorldClient {

    private final UserInfoServiceGrpc.UserInfoServiceBlockingStub blockingStub;

    /** Construct client for accessing HelloWorld server using the existing channel. */
    public HelloWorldClient(Channel channel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
        blockingStub = UserInfoServiceGrpc.newBlockingStub(channel);
    }

    /** Say hello to server. */
    public void greet(String name) {
        UserInfoRequest build = UserInfoRequest.newBuilder().setId("123").build();

        try {
            UserInfo userInfo = blockingStub.getUserInfo(build);
            System.out.println("res:"+userInfo.toString());
        } catch (StatusRuntimeException e) {
            return;
        }

    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting. The second argument is the target server.
     */
    public static void main(String[] args) throws Exception {
        String user = "hahahahah";
        // Access a service running on the local machine on port 50051
        String target = "localhost:9900";

        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        try {
            HelloWorldClient client = new HelloWorldClient(channel);
            client.greet(user);
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
            // resources the channel should be shut down when it will no longer be used. If it may be used
            // again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
