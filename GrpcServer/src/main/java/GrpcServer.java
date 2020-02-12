import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import TimeServer.TimeServerService;

public class GrpcServer {

    public static void main(String args[]) throws IOException, InterruptedException {
        
        System.out.println("starting GRPC Server");
        Server server = ServerBuilder.forPort(9090).addService(new TimeServerService()).build();
        
        server.start();
        System.out.println("server started at "+ server.getPort());
        server.awaitTermination();
    }
}