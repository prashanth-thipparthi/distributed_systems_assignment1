
import com.grpc.TimeServerGrpc;
import com.grpc.TimeServerGrpc.TimeServerBlockingStub;
import com.grpc.TimeServerOuterClass.Msg;
import com.grpc.TimeServerOuterClass.Times;

import java.io.FileWriter;
import java.io.PrintWriter;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class GrpcClient {

	static PrintWriter printWriter = null;
	static Instant instant = null;
	public static void main(String[] args) {
		try {
			printWriter = new PrintWriter(new FileWriter("logger.txt",true));
		
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();
			
			// stubs - generate from proto
			int count = 0;

			TimeServerBlockingStub clientStub = TimeServerGrpc.newBlockingStub(channel);
			Msg msg = Msg.newBuilder().setMsg("Sai Ram").build();
			
			while(count < 5) {				
				instant = Instant.now();
				long requestSent = instant.toEpochMilli();
				Times response = clientStub.getTime(msg);
				instant = Instant.now();
				long requestReceived = instant.toEpochMilli();		
				if(response == null) {
					System.out.println("No response from server");
				}else {
					//printWriter.printf("\n Client side: Sent = %d , received = %d -- server side: received = %s, sent = %s",requestSent,requestReceive,values[0],values[1]);
					printWriter.printf("\n%d %d %s %s",requestSent,requestReceived,response.getReceived(),response.getSent());
				}
				TimeUnit.SECONDS.sleep(1);
				count ++;
			}
			printWriter.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
