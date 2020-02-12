package TimeServer;

import com.grpc.TimeServerGrpc.TimeServerImplBase;
import com.grpc.TimeServerOuterClass.Times;
import java.time.Instant;

import io.grpc.stub.StreamObserver;

public class TimeServerService extends TimeServerImplBase {

    
    public void getTime(com.grpc.TimeServerOuterClass.Msg request,  StreamObserver<Times> responseObserver ) {
        Instant instant = null;
        instant = Instant.now();
        long requestReceived = instant.toEpochMilli();
        Times.Builder t = Times.newBuilder();

        t.setReceived(requestReceived);
        instant = Instant.now();
        long requestSent = instant.toEpochMilli();
        t.setSent(requestSent);
        responseObserver.onNext(t.build());
        responseObserver.onCompleted();
    }
}